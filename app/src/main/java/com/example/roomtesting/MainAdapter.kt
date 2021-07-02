package com.example.roomtesting

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtesting.Interfaces.OnItemClickListener
import com.example.roomtesting.databinding.DesignSecondBinding
import com.squareup.picasso.Picasso
import com.tutomoney.by.roomtesting.Boxes.video_box

class MainAdapter(private val onItemClickListener: OnItemClickListener, private val itemTouchHelper: EnableDragRecyclerView) :
    ListAdapter<video_box, MainAdapter.ViewHolder>(DIFF_CALLBACK) {


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DesignSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding, onItemClickListener)
        binding.dragHandle.setOnTouchListener { view, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                itemTouchHelper.startDrag(viewHolder)
            }
            return@setOnTouchListener true
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        binding: DesignSecondBinding,
        private val onItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        var horizontalProgressBar = binding.horizontalProgressBar
        var imageView = binding.imageView
        var tvName = binding.tvName
        var tvVideoSize = binding.tvVideoSize
        var tvUpload = binding.tvUpload
        var tvVideoTime = binding.tvVideoTime
        var item: video_box? = null

        fun bind(item: video_box) {
            Picasso.get().load(item.i).fit().placeholder(R.drawable.tutomoney_background)
                .into(imageView)
            tvName.text = item.n
            tvVideoSize.text = item.s
            tvVideoTime.text = item.t
            this.item = item
            Picasso.get().load(item.i).fit().placeholder(R.drawable.tutomoney_background)
                .into(imageView)
        }

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            item?.let { onItemClickListener.onItemClicked(it.p, item!!) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<video_box>() {
            override fun areItemsTheSame(oldItem: video_box, newItem: video_box): Boolean {
                return oldItem.p == newItem.p
            }

            override fun areContentsTheSame(oldItem: video_box, newItem: video_box): Boolean {
                return oldItem.toString() == newItem.toString()
            }
        }
    }

}