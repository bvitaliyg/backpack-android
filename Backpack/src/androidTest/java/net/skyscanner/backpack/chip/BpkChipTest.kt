package net.skyscanner.backpack.chip

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import net.skyscanner.backpack.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkChipTest {
  private lateinit var context: Context

  @Before
  fun beforeAll() {
    context = InstrumentationRegistry.getInstrumentation().targetContext
  }

  @Test
  fun test_message() {
    val chip = BpkChip(context).apply {
      text = "Message"
    }
    Assert.assertEquals("Message", chip.text.toString())
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray900), chip.currentTextColor)
  }

  @Test
  fun test_selected_state() {
    val chip = BpkChip(context).apply {
      isSelected = true
    }
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkWhite), chip.currentTextColor)
  }

  @Test
  fun test_disabled_state() {
    val chip = BpkChip(context).apply {
      disabled = true
    }
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray300), chip.currentTextColor)
  }

  @Test
  fun test_toggle() {
    val chip = BpkChip(context).apply {
      isSelected = false
    }

    chip.toggle()
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkWhite), chip.currentTextColor)

    chip.toggle()
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray900), chip.currentTextColor)
  }

  @Test
  fun test_toggle_when_disabled() {
    val chip = BpkChip(context).apply {
      isSelected = false
      disabled = true
    }

    chip.toggle()
    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray300), chip.currentTextColor)
  }

  @Test
  fun test_set_chipBackgroundColor() {

    val chip = BpkChip(context).apply {
      Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray50), chipBackgroundColor)
      Assert.assertNotEquals(ContextCompat.getColor(context, R.color.bpkGray500), chipBackgroundColor)
      chipBackgroundColor = ContextCompat.getColor(context, R.color.bpkGray500)
    }

    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkGray500), chip.chipBackgroundColor)
  }

  @Test
  fun chipSelectedBackgroundColor() {

    val chip = BpkChip(context).apply {
      Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkBlue500), selectedBackgroundColor)
      Assert.assertNotEquals(ContextCompat.getColor(context, R.color.bpkYellow500), selectedBackgroundColor)
      selectedBackgroundColor = ContextCompat.getColor(context, R.color.bpkYellow500)
    }

    Assert.assertEquals(ContextCompat.getColor(context, R.color.bpkYellow500), chip.selectedBackgroundColor)
  }
}
