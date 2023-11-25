/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.b106_402jeoung.PIYOU.presentation

import kotlin.random.Random
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import pl.droidsonroids.gif.GifDrawable
import com.b106_402jeoung.PIYOU.R
import com.b106_402jeoung.PIYOU.presentation.theme.PIYOUTheme

class MainActivity : AppCompatActivity() {

    private lateinit var imageButton: ImageButton
    private lateinit var handler: Handler
    private lateinit var toggleRunnable: Runnable
    private var isGifPlaying = false
    private var gestureList = arrayOf("eat", "fly", "happy", "hello", "yes")
    private lateinit var curPiyou: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        curPiyou = "sea"

        handler = Handler()

        // ActionBar 타이틀 비활성화
        supportActionBar?.hide()

        // 배경 이미지를 표시할 이미지 뷰 가져오기
        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)
        // 배경 이미지 설정
        backgroundImageView.setImageResource(R.drawable.watch_bg)

        imageButton = findViewById(R.id.imageButton)
        handler = Handler()
        val gifResource = this.resources.getIdentifier(curPiyou + "_" + "idle", "drawable", packageName)

        // GIF 애니메이션 시작
        val gifDrawable = GifDrawable(resources, gifResource)
        imageButton.setImageDrawable(gifDrawable)
        gifDrawable.start()
    }

    fun toggleAnimation(view: View) {
        if (isGifPlaying) {
            stopGifAnimation()
        } else {
            startGifAnimation()
        }
    }



    private fun startGifAnimation() {

        val selectedIdx = Random.nextInt(gestureList.size)
        val resourceId = this.resources.getIdentifier(curPiyou + "_" + gestureList[selectedIdx], "drawable", packageName)

        // GIF 애니메이션 시작
        val gifDrawable = GifDrawable(resources, resourceId)
        imageButton.setImageDrawable(gifDrawable)
        gifDrawable.start()

        // 1초 후에 GIF 애니메이션을 멈추도록 설정
        toggleRunnable = Runnable {
            stopGifAnimation()
        }
        handler.postDelayed(toggleRunnable, 1000)

        isGifPlaying = true
    }

    private fun stopGifAnimation() {
        // GIF 이미지 리소스 ID로 변경
        val gifResource = this.resources.getIdentifier(curPiyou + "_" + "idle", "drawable", packageName)

        // GIF 애니메이션 시작
        val gifDrawable = GifDrawable(resources, gifResource)
        imageButton.setImageDrawable(gifDrawable)
        gifDrawable.start()

        // 이전에 설정한 Runnable을 제거하여 반복 호출을 방지
        handler.removeCallbacks(toggleRunnable)

        isGifPlaying = false
    }
}

@Composable
fun WearApp(greetingName: String) {
    PIYOUTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
            Greeting(greetingName = greetingName)
        }
    }
}

@Composable
fun Greeting(greetingName: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(R.string.hello_world, greetingName)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android")
}