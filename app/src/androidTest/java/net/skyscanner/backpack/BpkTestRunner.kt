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
import android.view.View
import com.karumi.shot.ShotTestRunner

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
      registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityDestroyed(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
          BpkTestVariant.current.applyToActivity(activity)
          val flags: Int = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

          activity.window.decorView.systemUiVisibility = flags
        }
      })
    }

  override fun newActivity(cl: ClassLoader?, className: String?, intent: Intent?): Activity =
    BpkTestVariant.current.newActivity(super.newActivity(cl, className, intent))
}
