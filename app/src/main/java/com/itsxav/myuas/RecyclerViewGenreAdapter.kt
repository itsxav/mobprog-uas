package com.itsxav.myuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewGenreAdapter (private val genreGameList: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewGenreAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val txtGenre : TextView = itemView.findViewById(R.id.genre_game_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre_game,parent,false);

        return RecyclerViewGenreAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtGenre.text = genreGameList[position]
    }

    override fun getItemCount(): Int {
        return genreGameList.size
    }
}