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

package net.skyscanner.backpack.compose.price

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.skyscanner.backpack.compose.price.internal.BpkPriceAlignEnd
import net.skyscanner.backpack.compose.price.internal.BpkPriceAlignStart

enum class BpkPriceAlign {
  Start,
  End,
}

enum class BpkPriceSize {
  Large,
  Small,
}

@Composable
fun BpkPrice(
  price: String,
  modifier: Modifier = Modifier,
  leadingText: String? = null,
  lineThroughText: String? = null,
  trailingText: String? = null,
  align: BpkPriceAlign = BpkPriceAlign.Start,
  size: BpkPriceSize = BpkPriceSize.Small,
) {
  when (align) {
    BpkPriceAlign.Start -> {
      BpkPriceAlignStart(
        price = price,
        modifier = modifier,
        leadingText = leadingText,
        lineThroughText = lineThroughText,
        trailingText = trailingText,
        size = size,
      )
    }
    BpkPriceAlign.End -> {
      BpkPriceAlignEnd(
        price = price,
        modifier = modifier,
        leadingText = leadingText,
        lineThroughText = lineThroughText,
        trailingText = trailingText,
        size = size,
      )
    }
  }
}
