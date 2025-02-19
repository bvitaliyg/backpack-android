# Panel

[![Maven Central](https://img.shields.io/maven-central/v/net.skyscanner.backpack/backpack-compose)](https://search.maven.org/artifact/net.skyscanner.backpack/backpack-compose)
[![Class reference](https://img.shields.io/badge/Class%20reference-Android-blue)](https://backpack.github.io/android/backpack-compose/net.skyscanner.backpack.compose.panel)
[![Source code](https://img.shields.io/badge/Source%20code-GitHub-lightgrey)](https://github.com/Skyscanner/backpack-android/tree/main/backpack-compose/src/main/kotlin/net/skyscanner/backpack/compose/panel)

## Default

| Day | Night |
| --- | --- |
| <img src="https://raw.githubusercontent.com/Skyscanner/backpack-android/main/docs/compose/Panel/screenshots/all.png" alt="Panel component" width="375" /> |<img src="https://raw.githubusercontent.com/Skyscanner/backpack-android/main/docs/compose/Panel/screenshots/all_dm.png" alt="Panel component - dark mode" width="375" /> |

## Installation

Backpack Compose is available through [Maven Central](https://search.maven.org/artifact/net.skyscanner.backpack/backpack-compose). Check the main [Readme](https://github.com/skyscanner/backpack-android#installation) for a complete installation guide.

## Usage

Example of a Panel:

```Kotlin
import net.skyscanner.backpack.compose.panel.BpkPanel

BpkPanel {
    content()
}
```

Example of a Panel with no padding:

```Kotlin
import net.skyscanner.backpack.compose.panel.BpkPanel
import net.skyscanner.backpack.compose.panel.BpkPanelPadding

BpkPanel(padding = BpkPanelPadding.None) {
  content()
}
```
