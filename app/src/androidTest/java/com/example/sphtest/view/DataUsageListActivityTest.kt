package com.example.sphtest.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import com.example.sphtest.adapter.DataUsageListAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher


@RunWith(AndroidJUnit4::class)
class DataUsageListActivityTest{

    @get:Rule
    val activityRule = ActivityTestRule(DataUsageListActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(DataUsageListActivity::class.java)
    }

    @Test
    fun onItemClick() {
        ActivityScenario.launch(DataUsageListActivity::class.java)
        onView(withId(com.example.sphtest.R.id.recyclerView_dataList)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(6, click()))
    }

    @Test
    fun testRecyclerViewScroll() {
        ActivityScenario.launch(DataUsageListActivity::class.java)
        onView(withId(com.example.sphtest.R.id.recyclerView_dataList)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
    }

    @Test
    fun testRecyclerViewItem() {
        ActivityScenario.launch(DataUsageListActivity::class.java)
        onView(withId(com.example.sphtest.R.id.recyclerView_dataList)).perform(
            RecyclerViewActions.scrollToHolder(
                withHolderTimeView("Year")
            )
        );
    }

    private fun withHolderTimeView(text: String): Matcher<RecyclerView.ViewHolder> {
        return object :
            BoundedMatcher<RecyclerView.ViewHolder, DataUsageListAdapter.ViewHolder>(DataUsageListAdapter.ViewHolder::class.java!!) {
            override fun describeTo(description: Description) {
                description.appendText("No ViewHolder found with text: $text")
            }
            override fun matchesSafely(item: DataUsageListAdapter.ViewHolder): Boolean {
                val timeViewText =
                    item.itemView.findViewById(com.example.sphtest.R.id.textView_year_label) as TextView
                return timeViewText.text.toString().contains(text)
            }
        }
    }

}