package com.timac.ratebottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mikhaellopez.ratebottomsheet.AskRateBottomSheet
import com.mikhaellopez.ratebottomsheet.RateBottomSheet
import com.mikhaellopez.ratebottomsheet.RateBottomSheetManager
import com.timac.ratebottomsheet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRateMe.setOnClickListener {
            showRateBottomSheet()
        }
    }

    private fun showRateBottomSheet() {
        RateBottomSheetManager(this)
                .setInstallDays(1) // 3 by default
                .setLaunchTimes(2) // 5 by default
                .setRemindInterval(1) // 2 by default
                .setShowAskBottomSheet(true) // True by default
                .setShowLaterButton(true) // True by default
                .setShowCloseButtonIcon(true) // True by default
                .setDebugForceOpenEnable(true)                            // to show bottom sheet without conditions check. False by Default
                .monitor()

        // Show bottom sheet if meets conditions
        // With AppCompatActivity or Fragment
        RateBottomSheet.showRateBottomSheetIfMeetsConditions(this,      // Optional Listeners after context
                listener = object : AskRateBottomSheet.ActionListener {
                    override fun onDislikeClickListener() {
                        Toast.makeText(this@MainActivity, "OnDislike", Toast.LENGTH_SHORT).show()
                    }

                    override fun onRateClickListener() {
                        Toast.makeText(this@MainActivity, "onRate", Toast.LENGTH_SHORT).show()
                    }

                    override fun onNoClickListener() {
                        Toast.makeText(this@MainActivity, "onNoClick", Toast.LENGTH_SHORT).show()
                    }
                })
    }
}