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
class BpkImageSkeletonTest : BpkSnapshotTest() {

  @Test
  fun square() {
    val skeleton = BpkImageSkeleton(testContext)
    skeleton.cornerType = BpkImageSkeleton.CornerType.Square
    snap(skeleton, width = 200, height = 200)
  }

  @Test
  fun rounded() {
    val skeleton = BpkImageSkeleton(testContext)
    skeleton.cornerType = BpkImageSkeleton.CornerType.Rounded
    snap(skeleton, width = 200, height = 200)
  }
}
