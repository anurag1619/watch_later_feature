package com.example.roomtesting

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.*


class DragRecyclerView() :
    ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            // Set movement flags based on the layout manager
            return when (recyclerView.layoutManager) {
                is GridLayoutManager -> {
                    val dragFlags =
                        UP or DOWN or LEFT or RIGHT
                    val swipeFlags = 0
                    makeMovementFlags(dragFlags, swipeFlags)
                }
                is StaggeredGridLayoutManager -> {
                    val dragFlags =
                        UP or DOWN or LEFT or RIGHT
                    val swipeFlags = 0
                    makeMovementFlags(dragFlags, swipeFlags)
                }
                else -> {
                    val dragFlags = UP or DOWN
                    val swipeFlags = START or END
                    makeMovementFlags(dragFlags, swipeFlags)
                }
            }
        }

        override fun onMove(
            recyclerView: RecyclerView,
            selected: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val from = selected.adapterPosition
            val to = target.adapterPosition
            val adapter = recyclerView.adapter as MainAdapter
            val items = adapter.currentList.toMutableList()
            Collections.swap(items, from, to)
            adapter.submitList(items)
            return true
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
/*            val items = adapter.currentList.toMutableList()
            items.removeAt(viewHolder.adapterPosition)
            adapter.submitList(items)*/
        }
    })