/**
 * Backpack for Android - Skyscanner's Design System
 *
 * Copyright 2018 Skyscanner Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.skyscanner.backpack.compose.dialog

import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.isDialog
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.test.ext.junit.rules.activityScenarioRule
import net.skyscanner.backpack.BpkSnapshotTest
import net.skyscanner.backpack.BpkTestVariant
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.skyscanner.backpack.Variants
import net.skyscanner.backpack.demo.BackpackDemoTheme
import net.skyscanner.backpack.demo.R
import net.skyscanner.backpack.demo.compose.DestructiveDialogExample
import net.skyscanner.backpack.demo.compose.FlareDialogExample
import net.skyscanner.backpack.demo.compose.ImageDialogEndAlignmentExample
import net.skyscanner.backpack.demo.compose.ImageDialogStartAlignmentExample
import net.skyscanner.backpack.demo.compose.NoIconDialogExample
import net.skyscanner.backpack.demo.compose.SuccessOneButtonDialogExample
import net.skyscanner.backpack.demo.compose.SuccessThreeButtonsDialogExample
import net.skyscanner.backpack.demo.compose.SuccessTwoButtonsDialogExample
import net.skyscanner.backpack.demo.compose.WarningDialogExample
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkDialogTest : BpkSnapshotTest() {

  @get:Rule
  val composeTestRule = createEmptyComposeRule()

  @get:Rule
  val rule = activityScenarioRule<AppCompatActivity>()

  @Test
  fun successOneButton() = record {
    SuccessOneButtonDialogExample()
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun successTwoButtons() {
    record {
      SuccessTwoButtonsDialogExample()
    }
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun successThreeButtons() {
    record {
      SuccessThreeButtonsDialogExample()
    }
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun warning() {
    record {
      WarningDialogExample()
    }
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun destructive() {
    record {
      DestructiveDialogExample()
    }
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun noIcon() {
    record {
      NoIconDialogExample()
    }
  }

  @Test
  @Variants(BpkTestVariant.Default, BpkTestVariant.DarkMode)
  fun flare() {
    record {
      FlareDialogExample()
    }
  }

  @Test
  fun imageStartAlignment() {
    record {
      ImageDialogStartAlignmentExample()
    }
  }

  @Test
  fun imageEndAlignment() {
    record {
      ImageDialogEndAlignmentExample()
    }
  }

  private fun record(content: @Composable () -> Unit) {
    rule.scenario.onActivity { activity ->
      activity.setContent {
        BackpackDemoTheme(
          content = content,
        )
      }
    }

    val view = composeTestRule.onNode(isDialog()).fetchRootView()
    snap(view, background = R.color.bpkTextSecondary, width = 420)
  }

  private fun SemanticsNodeInteraction.fetchRootView(): View {
    val node = fetchSemanticsNode()
    return (node.root as ViewRootForTest).view
  }
}
