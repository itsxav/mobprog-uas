package com.itsxav.myuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itsxav.myuas.databinding.ActivityDetailItemBinding
import com.itsxav.myuas.databinding.ActivityMainBinding

class DetailItem : AppCompatActivity() {
    private lateinit var binding: ActivityDetailItemBinding
    private lateinit var rvGenre : RecyclerView
    private lateinit var rvGameplay : RecyclerView
    private lateinit var genreGameArrayList : ArrayList<String>
    private lateinit var gamePlayGameArrayList : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailGameImg : ImageView  = binding.detailGameImg
        val titleGameTxt : TextView  = binding.titleGameTxt
        val ratingGameTxt : TextView  = binding.ratingGameTxt
        val dateGameTxt : TextView  = binding.dateGameTxt
        val descGameTxt : TextView  = binding.descGameTxt
        val devGameTxt : TextView  = binding.devGameTxt
        val pubGameTxt : TextView  = binding.pubGameTxt
        val btnGameFav : Button = binding.btnGameFav
        val btnBackDetail : ImageView = binding.btnBackDetail

        val bundle : Bundle?= intent.extras
        val imgGame = bundle!!.getInt("imgGame")
        val titleGame = bundle!!.getString("titleGame")
        val ratingGame = bundle!!.getString("ratingGame")
        val dateGame = bundle!!.getString("dateGame")
        val descGame = bundle!!.getString("descGame")
        val devGame = bundle!!.getString("developerGame")
        val pubGame = bundle!!.getString("publisherGame")
        val genreGame = bundle!!.getStringArrayList("genreGame")
        val imgGameplayGame = bundle!!.getIntegerArrayList("imgGameplayGame")

        detailGameImg.setImageResource(imgGame)
        titleGameTxt.text = titleGame
        ratingGameTxt.text = ratingGame
        dateGameTxt.text = dateGame
        descGameTxt.text = descGame
        devGameTxt.text = devGame
        pubGameTxt.text = pubGame

        btnGameFav.setOnClickListener {
            Toast.makeText(this, "Add Favorit", Toast.LENGTH_SHORT).show()
        }

        btnBackDetail.setOnClickListener {
            finish()
        }

        // RecyclerView Genre Game
        rvGenre = binding.rvGenreGame
        rvGenre.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true)

        genreGameArrayList = arrayListOf<String>()
        if (genreGame != null) {
            for (i in genreGame){
                genreGameArrayList.add(i)
            }
        }
        var adapterGenre = RecyclerViewGenreAdapter(genreGameArrayList)
        rvGenre.adapter = adapterGenre

        // RecyclerView Gameplay Game
        rvGameplay = binding.rvGameplayGame
        rvGameplay.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true)

        gamePlayGameArrayList = arrayListOf<Int>()
        if (imgGameplayGame != null) {
            for (i in imgGameplayGame){
                gamePlayGameArrayList.add(i)
            }
        }
        var adapterGameplay = RecyclerViewGameplayAdapter(gamePlayGameArrayList)
        rvGameplay.adapter = adapterGameplay
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}