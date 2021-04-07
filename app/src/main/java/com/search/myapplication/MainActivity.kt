package com.search.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.search.myapplication.adapter.StringsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var stringsAdapter: StringsAdapter
    private var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createItems()
        setRecycler()
    }

    private fun createItems() {
        for (i in 0..100) {
            list.add("item $i")
        }
    }

    private fun setRecycler() {
        stringsAdapter = StringsAdapter(list)
        listItems.layoutManager = LinearLayoutManager(this)
        listItems.adapter = stringsAdapter

        listItems.orientation =
            DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING
        listItems.reduceItemAlphaOnSwiping = true

        val onItemSwipeListener = object : OnItemSwipeListener<String> {

            override fun onItemSwiped(
                position: Int,
                direction: OnItemSwipeListener.SwipeDirection,
                item: String
            ): Boolean {
                return false
            }
        }
        listItems.swipeListener = onItemSwipeListener
    }
}