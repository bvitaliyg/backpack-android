#!/usr/bin/python3

from string import Template
import sys
import os

def generate_file(template, path, name, mapping):
  with open(template, 'r') as file:
      src = Template(file.read())
      result = src.safe_substitute(mapping)

      if not os.path.exists(path):
          os.mkdir(path)
      f = open(os.path.join(path, name), 'w')
      f.write(result)
      f.close()

      print(f'Created {name}')


if len(sys.argv) < 2:
  name = input("Enter the name of the component:\nBpk")
else:
  name = sys.argv[1]

if len(sys.argv) < 3:
  package = input("Enter the package name of the component, or leave empty for " + name.lower() + ":\n")
  if len(package) == 0:
    package = name.lower()
else:
  package = sys.argv[2]

print('')
print(f'Create compose component structure for {package}.Bpk{name}?')
confirmation = input("[Y/n]: ").lower()
if confirmation != "" and confirmation != "y" and confirmation != "yes":
  sys.exit("Component creation cancelled")

print('')
print('Creating compose component structure...')
print('')

mapping = {
  'name': name,
  'package': package
}
dirname = os.path.dirname(__file__)
generate_file(os.path.join(dirname, '../templates/component/Component.kt'), os.path.join(dirname, f'../backpack-compose/src/main/kotlin/net/skyscanner/backpack/compose/{package}/'), f'Bpk{name}.kt', mapping)
generate_file(os.path.join(dirname, '../templates/component/Story.kt'), os.path.join(dirname, f'../app/src/main/java/net/skyscanner/backpack/demo/compose/'), f'{name}Story.kt', mapping)
generate_file(os.path.join(dirname, '../templates/component/Test.kt'), os.path.join(dirname, f'../app/src/androidTest/java/net/skyscanner/backpack/compose/{package}/'), f'Bpk{name}Test.kt', mapping)
generate_file(os.path.join(dirname, '../templates/component/README.md'), os.path.join(dirname, f'../docs/compose/{name}/'), 'README.md', mapping)

print('')
print('To include the component in the demo app add the following line to the ComponentRegistry.kt COMPONENT list in alphabetic position:')
print(f'"{name}" composeStory {{ {name}Story() }}')
print('')

print('To add it to the screenshot generation add the following line to the DocsRegistry.kt screenshots list in alphabetic position:')
print(f'ComposeScreenshot("{name}", "default")')

print('')
print('Note: If the component already exists in the view system the guide above will need to be adopted slightly - see CONTRIBUTING.md for details')

print('')
print('Enjoy building the component!')
