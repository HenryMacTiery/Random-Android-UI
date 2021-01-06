package com.timac.zoomrecylerlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.timac.zoomrecylerlayout.adapters.RecyclerAdapter
import com.timac.zoomrecylerlayout.databinding.ActivityMainBinding
import www.sanju.zoomrecyclerlayout.ZoomRecyclerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var tittleList = mutableListOf<String>()
    private var ratingList = mutableListOf<Int>()
    private var drawableList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addToList("Hawaii Beach",R.drawable.photo_one,3)
        addToList("Luxury Resort",R.drawable.photo_two,5)
        addToList("The cold woods",R.drawable.photo_three,4)

        setUpRecyclerView()

    }

    private fun addToList(title:String, image:Int, rating:Int){
        tittleList.add(title)
        ratingList.add(rating)
        drawableList.add(image)
    }

    private fun setUpRecyclerView(){
        val linearLayoutManager = ZoomRecyclerLayout(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        /*linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true*/
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvRecyclerHorizontal)
        binding.rvRecyclerHorizontal.isNestedScrollingEnabled = false
        binding.rvRecyclerHorizontal.layoutManager = linearLayoutManager // Add your recycler view to this ZoomRecycler layout

        binding.rvRecyclerHorizontal.adapter = RecyclerAdapter(drawableList,tittleList,ratingList)      //Set the RecyclerAdapter
    }

    fun toVertical(view: View) {
        intent = Intent(applicationContext,VerticalActivity::class.java)
        startActivity(intent)
    }
}