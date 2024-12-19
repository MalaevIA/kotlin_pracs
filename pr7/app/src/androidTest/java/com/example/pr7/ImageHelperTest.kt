package com.example.pr7

import android.content.Context
import android.graphics.Bitmap
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageHelperTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val imageHelper = ImageHelper(context)

    @Test
    fun testDownloadImage() = runBlocking {
        val url = "https://sun1-13.userapi.com/impg/YBSqa8ohZvZifBvip8GArdhYjDu9PSNSDNR7yg/XfQyuC12nlw.jpg?size=900x1027&quality=96&sign=f2ada84e5649c1ba66dc60c484671220&type=album"
        val image = imageHelper.downloadImage(url)
        assertNotNull("Image should be downloaded successfully", image)
    }

    @Test
    fun testSaveImage() = runBlocking {
        val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
        val filename = "test_image.png"

        try {
            imageHelper.saveImage(bitmap, filename)
        } catch (e: Exception) {
            throw AssertionError("Image saving failed", e)
        }
    }
}
