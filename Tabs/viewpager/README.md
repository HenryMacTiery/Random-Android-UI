# Sliding between Tabs using ViewPager

> Note: For sliding screens, android recommends the improved ViewPager2 library. For more information, see [Slide between fragments using ViewPager2](https://developer.android.com/training/animation/screen-slide-2) and the [ViewPager2 migration guide](https://developer.android.com/training/animation/vp2-migration).


**Disclaimer**  
This project covers my personal implementation. Refer to android documentation for [more details](https://developer.android.com/training/animation/screen-slide).


## Create the Views

### ***Add a ViewPager***
ViewPager objects have built-in swipe gestures to transition through pages, and they display screen slide animations by default, so you don't need to create your own animation. ViewPager uses PagerAdapter objects as a supply for new pages to display,

**activity_main.xml**

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.material.appbar.AppBarLayout
        android:id="@+id/appBarLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <com.google.android.material.tabs.TabLayout
            android:id="@+id/tabs"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:tabBackground="@color/design_default_color_primary_dark"
            app:tabGravity="fill"
            app:tabInlineLabel="true"
            app:tabMode="fixed"
            app:tabTextAppearance="@style/customTabStyle"
            app:tabTextColor="@color/white" />

    </com.google.android.material.appbar.AppBarLayout>

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/appBarLayout" />

</RelativeLayout>
```

## Create the fragment(s)

Create as many as needed as well as the related xml layouts.

```kotlin
import android.support.v4.app.Fragment

class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)
}
```

## Create the ViewPagerAdapter

```kotlin
class ViewPagerAdapter (supportFragmentManager: FragmentManager): FragmentStatePagerAdapter(supportFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentTitleList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  mFragmentTitleList[position]
    }

    fun addFragments(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}
```

## Combine it all in the MainActivity

```kotlin
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
        binding.viewPager.setPageTransformer(true, DepthPageTransformer())  // This example includes 2 pageTransformerExamples in the pageTransformers package

        //setup TabLayout with viewpager
        binding.tabs.setupWithViewPager(binding.viewPager)

        // Assign drawables to the tabs
        binding.tabs.getTabAt(0)?.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)?.setIcon(R.drawable.ic_favorite)
        binding.tabs.getTabAt(2)?.setIcon(R.drawable.ic_settings)

    }
}
```

## Customize the animation using PageTransformer

To display a different animation from the default screen slide animation, implement the ViewPager.PageTransformer interface and supply it to the view pager. The interface exposes a single method, transformPage(). At each point in the screen's transition, this method is called once for each visible page (generally there's only one visible page) and for adjacent pages just off the screen. For example, if page three is visible and the user drags towards page four, transformPage() is called for pages two, three, and four at each step of the gesture.

```kotlin
val mPager: ViewPager = findViewById(R.id.pager)
...
mPager.setPageTransformer(true, ZoomOutPageTransformer())
```

Links to some sample pageTransformers:  
- [ZoomOutPageTransformer](./app/src/main/java/com/timac/tabs/pageTransformers/ZoomOutPageTransformer.kt)  

- [DepthPageTransformer](./app/src/main/java/com/timac/tabs/pageTransformers/DepthPageTransformer.kt)


## Screenshots

With ZoomOutPageTransformer:  
![ZoomOutPageTransformer](https://media.giphy.com/media/hYGuL8ibJpSmFPQlY1/giphy.gif)  
With DepthPageTransformer:  
![DepthPageTransformer](https://media.giphy.com/media/8LBz0oqkT1kW6ji1xT/giphy.gif)