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

package net.skyscanner.backpack

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.split
import android.view.View
import com.karumi.shot.ShotTestRunner
import java.util.concurrent.TimeUnit

@Suppress("unused")
class BpkTestRunner : ShotTestRunner() {

  override fun onCreate(args: Bundle) {
    if (args.getString("variant") == "themed") {
      args.putString("notPackage", "net.skyscanner.backpack.compose")
    }
    args.putString("filter", "net.skyscanner.backpack.VariantFilter")
    super.onCreate(args)
  }

  @Suppress("DEPRECATION", "OVERRIDE_DEPRECATION")
  override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application =
    super.newApplication(cl, className, context).apply {
      setupDemoMode()
      registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityDestroyed(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
          BpkTestVariant.current.applyToActivity(activity)
          activity.hideNavBar()
        }
      })
    }

  override fun newActivity(cl: ClassLoader?, className: String?, intent: Intent?): Activity =
    BpkTestVariant.current.newActivity(super.newActivity(cl, className, intent))

  private fun Activity.hideNavBar() {
    window.insetsController
    val flags: Int = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
      or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
      or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
      or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

    window.decorView.systemUiVisibility = flags
  }

  private fun Application.setupDemoMode() {
//    runCommand("settings put global sysui_demo_allowed 1")
//    amBroadcast("command", "enter")
//    amBroadcast("command", "clock", "hhmm", "1010")
//    amBroadcast("command", "battery", "plugged", "false")
//    amBroadcast("command", "battery", "level", "100")
//    amBroadcast("command", "network", "wifi", "show", "level", "4")
//    amBroadcast("command", "network", "mobile", "show", "datatype", "none", "level", "4")
//    amBroadcast("command", "notifications", "visible", "false")
  }

  private fun Application.amBroadcast(vararg values: String) {
    Intent()
      .apply {
        action = "com.android.systemui.demo"
        values
          .toList()
          .chunked(2)
          .forEach { putExtra(it.first(), it.lastOrNull()) }
      }.let { sendBroadcast(it)}
  }

  private fun runCommand(command: String) {
    ProcessBuilder(command)
      .redirectOutput(ProcessBuilder.Redirect.INHERIT)
      .redirectError(ProcessBuilder.Redirect.INHERIT)
      .start()
      .waitFor(60, TimeUnit.MINUTES)
  }
}
