package com.search.myapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
import com.search.myapplication.R
import kotlinx.android.synthetic.main.list_item.view.*

class StringsAdapter(dataList: MutableList<String>) :
    DragDropSwipeAdapter<String, StringsAdapter.ViewHolder>(dataList) {

    inner class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {
        val dragIcon: ImageView = itemView.findViewById(R.id.drag_icon)
    }

    override fun getViewHolder(itemView: View) = ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getViewToTouchToStartDraggingItem(
        item: String,
        viewHolder: StringsAdapter.ViewHolder,
        position: Int
    ): View {
        return viewHolder.dragIcon
    }

    override fun onBindViewHolder(
        item: String,
        viewHolder: StringsAdapter.ViewHolder,
        position: Int
    ) {
        val it = dataSet[position]
        viewHolder.itemView.text_item.text = it
    }
}