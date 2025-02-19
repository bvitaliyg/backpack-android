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

package net.skyscanner.backpack.skeleton

import androidx.test.ext.junit.runners.AndroidJUnit4
import net.skyscanner.backpack.BpkSnapshotTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkCircleSkeletonTest : BpkSnapshotTest() {

  @Test
  fun small() {
    val skeleton = BpkCircleSkeleton(testContext)
    skeleton.size = BpkCircleSkeleton.CircleSize.Small
    snap(skeleton, width = 50, height = 50)
  }

  @Test
  fun large() {
    val skeleton = BpkCircleSkeleton(testContext)
    skeleton.size = BpkCircleSkeleton.CircleSize.Large
    snap(skeleton, width = 75, height = 75)
  }

  @Test
  fun customSize() {
    val skeleton = BpkCircleSkeleton(testContext)
    skeleton.size = BpkCircleSkeleton.CircleSize.Custom
    skeleton.diameter = (50 * testContext.resources.displayMetrics.density).toInt()
    snap(skeleton, width = 75, height = 75)
  }
}
