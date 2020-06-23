package com.example.roomactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter (var articleList : ArrayList<User>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dataitem, parent,
                false))

    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: DashboardAdapter.ViewHolder, position: Int) {
        holder.bindData(articleList[position])

    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var title: TextView? = null
        var author: TextView? = null
        var layoutView: LinearLayout? = null


        init {
            title = view.findViewById(R.id.title)
            author = view.findViewById(R.id.author)
            layoutView = view.findViewById(R.id.layoutView)
        }

        fun bindData(articleList: User){

            title?.text = articleList.name
            author?.text = articleList.age
        }

    }


}