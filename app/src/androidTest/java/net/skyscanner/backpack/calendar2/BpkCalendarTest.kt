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

package net.skyscanner.backpack.calendar2

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jakewharton.threetenabp.AndroidThreeTen
import net.skyscanner.backpack.BpkSnapshotTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BpkCalendarTest : BpkSnapshotTest() {

  @Before
  fun setup() {
    AndroidThreeTen.init(testContext)
  }

  @Test
  fun default() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.Default)
    snap(calendar, padding = 0)
  }

  @Test
  fun labeledCalendarDefault() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.Labeled)
    snap(calendar, padding = 0)
  }

  @Test
  fun past() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.Past)
    snap(calendar, padding = 0)
  }

  @Test
  fun leapFebruary() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.LeapFebruary)
    calendar.setSelection(BpkCalendarTestCases.Selection.LeapFebruary)
    snap(calendar, padding = 0)
  }

  @Test
  fun nonLeapFebruary() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.NonLeapFebruary)
    calendar.setSelection(BpkCalendarTestCases.Selection.NonLeapFebruary)
    snap(calendar, padding = 0)
  }

  @Test
  fun todayIsLastDayOfMonth() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.TodayIsLastDayOfMonth)
    calendar.setSelection(BpkCalendarTestCases.Selection.TodayIsLastDayOfMonth)
    snap(calendar, padding = 0)
  }

  @Test
  fun todayIsNewYear() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.TodayIsNewYear)
    calendar.setSelection(BpkCalendarTestCases.Selection.TodayIsNewYear)
    snap(calendar, padding = 0)
  }

  @Test
  fun withRangeSet() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithRangeSetProgrammatically)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithRangeSetProgrammatically)
    snap(calendar, padding = 0)
  }

  @Test
  fun withSingleDaySet() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithSingleDaySetProgrammatically)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithSingleDaySetProgrammatically)
    snap(calendar, padding = 0)
  }

  @Test
  fun withDisabledDates() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithDisabledDates)
    snap(calendar, padding = 0)
  }

  @Test
  fun withDisabledDates_SelectSingle() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithDisabledDates_SelectSingle)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithDisabledDates_SelectSingle)
    snap(calendar, padding = 0)
  }

  @Test
  fun withDisabledDates_SelectRange() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithDisabledDates_SelectRange)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithDisabledDates_SelectRange)
    snap(calendar, padding = 0)
  }

  @Test
  fun withDisabledDates_SelectDisabledDate() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithDisabledDates_SelectDisabledDate)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithDisabledDates_SelectDisabledDate)
    snap(calendar, padding = 0)
  }

  @Test
  fun withWholeMonthButtonEnabled() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithWholeMonthButtonEnabled)
    snap(calendar, padding = 0)
  }

  @Test
  fun withWholeMonthSet() {
    val calendar = BpkCalendar(testContext)
    calendar.setParams(BpkCalendarTestCases.Params.WithWholeMonthSetProgrammatically)
    calendar.setSelection(BpkCalendarTestCases.Selection.WithWholeMonthSetProgrammatically)
    snap(calendar, padding = 0)
  }
}
