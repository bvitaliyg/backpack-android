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

package net.skyscanner.backpack.fab

import androidx.test.ext.junit.runners.AndroidJUnit4
import net.skyscanner.backpack.BpkSnapshotTest
import net.skyscanner.backpack.demo.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkFabTest : BpkSnapshotTest() {

  private val fab = BpkFab(testContext)

  @Test
  fun default() {
    snap(fab)
  }

  @Test
  fun customIcon() {
    fab.setImageResource(R.drawable.bpk_search)
    snap(fab)
  }

  @Test
  fun customIcon_Disabled() {
    fab.setImageResource(R.drawable.bpk_search)
    fab.isEnabled = false
    snap(fab)
  }
}
