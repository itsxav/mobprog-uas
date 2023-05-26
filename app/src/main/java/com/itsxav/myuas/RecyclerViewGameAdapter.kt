package com.itsxav.myuas

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerViewGameAdapter(private val gameList: ArrayList<ItemsGameModel>) :RecyclerView.Adapter<RecyclerViewGameAdapter.ViewHolder>() {

    private lateinit var mlistener: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mlistener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imgGame : ImageView = itemView.findViewById(R.id.game_img)
        val txtTitle : TextView = itemView.findViewById(R.id.title_txt)
        val txtDate : TextView = itemView.findViewById(R.id.date_txt)
        val txtRating : TextView = itemView.findViewById(R.id.rating_txt)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game,parent,false);

        return ViewHolder(view, mlistener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItemGame = gameList[position]
        holder.imgGame.setImageResource(currentItemGame.imgGame)
        holder.txtTitle.text = currentItemGame.titleGame
        holder.txtDate.text = currentItemGame.dateGame
        holder.txtRating.text = currentItemGame.ratingGame
    }

    override fun getItemCount(): Int {
        return gameList.size;
    }
}