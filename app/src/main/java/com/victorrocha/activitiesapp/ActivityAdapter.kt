package com.victorrocha.activitiesapp
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item.view.*

class ActivityAdapter (
    private val activities: MutableList<Activity>
    ): RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        return ActivityViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_item,
                parent,
                false
            )
        )
    }

    fun addActivity(activity: Activity) {
        activities.add(activity)
        notifyItemInserted(activities.size - 1)
    }

    fun deleteDoneTodos() {
        activities.removeAll { activity ->
            activity.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvActivityTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvActivityTitle.paintFlags = tvActivityTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvActivityTitle.paintFlags = tvActivityTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        var curActivity = activities[position]
        holder.itemView.apply {
            tvActivityTitle.text = curActivity.title
            cbDone.isChecked = curActivity.isChecked
            toggleStrikeThrough(tvActivityTitle, curActivity.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvActivityTitle, isChecked)
                curActivity.isChecked = !curActivity.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}