package com.timac.customactivityoncrash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.timac.customactivityoncrash.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
//        setCrashConfigs()

        binding.apply {
            btnTrigger.setOnClickListener { triggerCrash() }
        }
    }

    /*private fun setCrashConfigs() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
                .enabled(true) //default: true
                .showErrorDetails(true) //default: true
                .showRestartButton(true) //default: true
                .logErrorOnRestart(false) //default: true
                .trackActivities(true) //default: false
                .minTimeBetweenCrashesMs(2000) //default: 3000
                .errorDrawable(R.drawable.ic_custom_drawable) //default: bug image
                .restartActivity(YourCustomActivity::class.java) //default: null (your app's launch activity)
                .errorActivity(YourCustomErrorActivity::class.java) //default: null (default error activity)
                .eventListener(YourCustomEventListener()) //default: null
                .apply()
    }*/

    private fun triggerCrash() {
        throw  RuntimeException("Boom!")
    }
}