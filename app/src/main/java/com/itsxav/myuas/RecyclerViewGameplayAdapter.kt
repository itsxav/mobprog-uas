package com.itsxav.myuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewGameplayAdapter (private val gameplayGameList : ArrayList<Int>) : RecyclerView.Adapter<RecyclerViewGameplayAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val gameplayGameImg : ImageView = itemView.findViewById(R.id.gameplay_game_img)
    }

    override fun getItemCount(): Int {
        return gameplayGameList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewGameplayAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gameplay_game,parent,false);

        return RecyclerViewGameplayAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameplayGameImg.setImageResource(gameplayGameList[position])
    }

}