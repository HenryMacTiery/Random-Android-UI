package com.timac.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timac.tabs.databinding.ActivityMainBinding
import com.timac.tabs.fragments.FavoriteFragment
import com.timac.tabs.fragments.HomeFragment
import com.timac.tabs.fragments.SettingsFragment
import com.timac.tabs.adapters.ViewPagerAdapter
import com.timac.tabs.pageTransformers.DepthPageTransformer
import com.timac.tabs.pageTransformers.ZoomOutPageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabs()
    }

    private fun setUpTabs() {
        // Create an instance of ViewPagerAdapter
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)

        // Use the instance to addFragments using custom the method created in the adapter addFragments()
        pagerAdapter.addFragments(HomeFragment(),"Home")
        pagerAdapter.addFragments(FavoriteFragment(),"Fav")
        pagerAdapter.addFragments(SettingsFragment(),"Settings")

        // Assign the adapter to the viewpager
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.setPageTransformer(true, ZoomOutPageTransformer())  // This example includes 2 pageTransformerExamples in the pageTransformers package

        // setup TabLayout with viewpager
        binding.tabs.setupWithViewPager(binding.viewPager)

        // Assign drawables to the tabs
        binding.tabs.getTabAt(0)?.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)?.setIcon(R.drawable.ic_favorite)
        binding.tabs.getTabAt(2)?.setIcon(R.drawable.ic_settings)

    }
}