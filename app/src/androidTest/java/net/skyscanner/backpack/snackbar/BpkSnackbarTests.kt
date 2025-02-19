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

package net.skyscanner.backpack.snackbar

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.karumi.shot.ActivityScenarioUtils.waitForActivity
import net.skyscanner.backpack.BpkSnapshotTest
import net.skyscanner.backpack.demo.R
import net.skyscanner.backpack.util.unsafeLazy
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkSnackbarTests : BpkSnapshotTest() {

  @get:Rule
  val rule = activityScenarioRule<AppCompatActivity>()

  private val root by unsafeLazy {
    FrameLayout(testContext).apply {
      rule.scenario.onActivity { activity ->
        activity.setContentView(this)
      }
    }
  }

  @Test
  fun default() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
    }
  }

  @Test
  fun defaultWithAction() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setAction("Action") {}
    }
  }

  @Test
  fun withTitle() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setAction("Action") {}
    }
  }

  @Test
  fun withIcon() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction("Action") {}
    }
  }

  @Test
  fun withTitleAndIcon() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction("Action") {}
    }
  }

  @Test
  fun iconOnly() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setAction(R.drawable.bpk_close, "Close") {}
    }
  }

  @Test
  fun iconOnly_withTitle() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setAction(R.drawable.bpk_close, "Close") {}
    }
  }

  @Test
  fun iconOnly_withIcon() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction(R.drawable.bpk_close, "Close") {}
    }
  }

  @Test
  fun iconOnly_withTitleAndIcon() {
    capture {
      BpkSnackbar.make(root, "Test", BpkSnackbar.LENGTH_INDEFINITE)
        .setTitle("Title")
        .setIcon(R.drawable.bpk_tick_circle)
        .setAction(R.drawable.bpk_close, "Close") {}
    }
  }

  private inline fun capture(crossinline what: () -> BpkSnackbar) {
    var snackbar: BpkSnackbar? = null
    rule.scenario.waitForActivity().also {
      runOnUi {
        snackbar = what()
        snackbar?.show()
      }
    }
    Espresso.onView(ViewMatchers.withId(R.id.snackbar_text)).perform(waitForOpaque(300))
      .check { _, _ ->
        rule.scenario.waitForActivity()
      }

    snap(snackbar!!.rawSnackbar.view, wrapView = false, width = 350)
  }
}

fun waitForOpaque(timeout: Long): ViewAction {
  return object : ViewAction {

    override fun getConstraints(): Matcher<View> {
      return isAssignableFrom(TextView::class.java)
    }

    override fun getDescription(): String {
      return "wait up to $timeout milliseconds for the view to be opaque"
    }

    override fun perform(uiController: UiController, view: View) {
      val endTime = System.currentTimeMillis() + timeout

      do {
        if (view.alpha == 1f) return
        uiController.loopMainThreadForAtLeast(50)
      } while (System.currentTimeMillis() < endTime)
    }
  }
}
