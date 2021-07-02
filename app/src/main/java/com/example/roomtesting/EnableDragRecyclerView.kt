package com.example.roomtesting

import android.app.Activity
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class EnableDragRecyclerView(activity: Activity) : ItemTouchHelper(object : SimpleCallback(
    UP or DOWN,
    ACTION_STATE_IDLE
) {

    var initialPosition: Int? = -1
    var finalPosition: Int? = -1

    override fun onMove(
        recyclerView: RecyclerView,
        selected: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val from = selected.adapterPosition
        val to = target.adapterPosition
        val adapter = recyclerView.adapter as MainAdapter
        adapter.notifyItemMoved(from, to)

        val mainActivity = activity as MainActivity
        mainActivity.moveItem(from,to)
        return true
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("Not yet implemented")
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)

        if (actionState == ACTION_STATE_DRAG) {
            initialPosition = viewHolder?.adapterPosition
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        finalPosition = viewHolder.adapterPosition

        if (initialPosition != finalPosition)
            Log.d("dsfsd", "($initialPosition,$finalPosition)")
    }
})

/*

STEP : 1 Use the below code in any activity

class MainActivity : AppCompatActivity() {
    private val itemTouchHelper by lazy{
        EnableDragRecyclerView()()
    }
    val adapter = AnyAdapter(itemTouchHelper)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }
}

STEP : 2 Use the below code in adapter onCreateViewHolder function

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AnyDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding)
        binding.imageView.setOnTouchListener { view, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                itemTouchHelper.startDrag(viewHolder)
            }
            return@setOnTouchListener true
        }

        return viewHolder
    }

*/




