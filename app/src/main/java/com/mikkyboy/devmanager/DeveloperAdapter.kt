package com.mikkyboy.devmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeveloperAdapter(
    var developers: List<Developer>
) : RecyclerView.Adapter<DeveloperAdapter.DeveloperViewHolder>() {

    inner class DeveloperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dev, parent, false)
        return DeveloperViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeveloperViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle: TextView = findViewById(R.id.tvTitle)
            val tvSubtitle: TextView = findViewById(R.id.tvSubtitle)
            val ivDelete: ImageView = findViewById(R.id.ivDelete)

            tvTitle.text = developers[position].codeName
            tvSubtitle.text = developers[position].stack
            ivDelete.setOnClickListener {
                print("Delete => $position")
            }
        }
    }

    override fun getItemCount(): Int {
        return developers.size
    }
}