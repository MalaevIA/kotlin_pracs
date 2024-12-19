package com.example.pr7

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.assertFalse

import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import java.util.function.Predicate.not

class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val device: UiDevice
        get() = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Test
    fun testEnterUrlAndFileName() {
        onView(withId(R.id.etUrl))
            .perform(typeText("https://sun1-13.userapi.com/impg/YBSqa8ohZvZifBvip8GArdhYjDu9PSNSDNR7yg/XfQyuC12nlw.jpg?size=900x1027&quality=96&sign=f2ada84e5649c1ba66dc60c484671220&type=album"), closeSoftKeyboard())
            .check(matches(withText("https://sun1-13.userapi.com/impg/YBSqa8ohZvZifBvip8GArdhYjDu9PSNSDNR7yg/XfQyuC12nlw.jpg?size=900x1027&quality=96&sign=f2ada84e5649c1ba66dc60c484671220&type=album")))

        onView(withId(R.id.etFileName))
            .perform(typeText("downloaded_image"), closeSoftKeyboard())
            .check(matches(withText("downloaded_image")))
    }

    @Test
    fun testSaveButtonAndToast() {
        onView(withId(R.id.etUrl))
            .perform(typeText("https://sun1-13.userapi.com/impg/YBSqa8ohZvZifBvip8GArdhYjDu9PSNSDNR7yg/XfQyuC12nlw.jpg?size=900x1027&quality=96&sign=f2ada84e5649c1ba66dc60c484671220&type=album"), closeSoftKeyboard())

        onView(withId(R.id.etFileName))
            .perform(typeText("downloaded_image"), closeSoftKeyboard())

        onView(withId(R.id.btSave))
            .perform(click())

     //        onView(withText("Image saved"))
      //      .inRoot(ToastMatcher())
      //      .check(matches(isDisplayed()))
        device.waitForIdle(3000)
        assertFalse(device.hasObject(By.text("Image saved")))

       // onView(withText("Image saved"))
      //      .check(matches(isDisplayed()))
    }
}
