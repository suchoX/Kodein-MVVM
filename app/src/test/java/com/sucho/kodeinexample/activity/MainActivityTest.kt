package com.sucho.kodeinexample.activity


import androidx.test.core.app.ActivityScenario
import com.sucho.kodeinexample.IherbTestRunner
import com.sucho.kodeinexample.feature.main.MainActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(IherbTestRunner::class)
class MainActivityTest {
    private lateinit var testObj: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        testObj = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testCompanyName() {
        testObj.onActivity {
            it.viewModel.fetchRandomJoke()
            sleep(10000)
            val companyName = it.viewModel.stringLiveData.value
            Assert.assertTrue(companyName == "Github")
        }
    }
}
