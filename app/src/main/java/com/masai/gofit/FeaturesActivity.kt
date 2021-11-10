package com.masai.gofit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType

class FeaturesActivity : AppCompatActivity() {
    private lateinit var sliderView: SliderView
    private lateinit var adapter: FeaturesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_features)
        sliderView = findViewById(R.id.imageSlider)
        adapter = FeaturesAdapter()
        sliderView.run {
            setInfiniteAdapterEnabled(true)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
            indicatorSelectedColor = Color.WHITE
            indicatorUnselectedColor = Color.GRAY
            scrollTimeInSec = 3
            isAutoCycle = true
            startAutoCycle()
        }
    }
}