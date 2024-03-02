package com.example.soullive

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecentModelRVAdapter(private val context: Context, private var items: MutableList<String>) : BaseAdapter(){

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_recentsearch, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position) as String
        viewHolder.textViewItem.text = item

        viewHolder.buttonDelete.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }

        return view!!
    }

    fun addItem(item: String) {
        items.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    private class ViewHolder(view: View) {
        val textViewItem: TextView = view.findViewById(R.id.recentModel_tv)
        val buttonDelete : ImageButton = view.findViewById(R.id.delete_btn)
    }


}
