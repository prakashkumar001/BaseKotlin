package com.kotlin.example.adapter;

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.example.R
import com.kotlin.example.map.GoogleMapActivity
import kotlinx.android.synthetic.main.list_item.view.*

 class ListAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ListAdapter.ViewHolder {

        return ListAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    override fun getItemCount(): Int {

        return items.size;
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder?.textView?.text = items.get(position)

        holder?.itemView.setOnClickListener( View.OnClickListener {
            val intent=Intent(context,GoogleMapActivity::class.java)
            context.startActivity(intent)
        })


    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val textView = view.text
    }

}
