package com.itsxav.myuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.itsxav.myuas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvGame : RecyclerView
    private lateinit var gameArrayList : ArrayList<ItemsGameModel>
    lateinit var imgGame : ArrayList<Int>
    lateinit var titleGame : ArrayList<String>
    lateinit var dateGame : ArrayList<String>
    lateinit var ratingGame : ArrayList<String>
    lateinit var genreGame : ArrayList<ArrayList<String>>
    lateinit var descGame : ArrayList<String>
    lateinit var developerGame : ArrayList<String>
    lateinit var publisherGame : ArrayList<String>
    lateinit var imgGameplayGame : ArrayList<ArrayList<Int>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

//        binding.btnToFav.setOnClickListener {
//            Toast.makeText(this, "To Screen Favorit", Toast.LENGTH_SHORT).show()
//        }

        imgGame = arrayListOf(
            R.drawable.gtav_logo,
            R.drawable.roblox_logo,
            R.drawable.dota_logo,
            R.drawable.re_logo,
            R.drawable.xplane_logo,
            R.drawable.fifa_logo,
            R.drawable.gow_logo,
            R.drawable.ml_logo,
            R.drawable.aov_logo,
            R.drawable.game10,
        )

        titleGame = arrayListOf(
            "GTA V",
            "Roblox",
            "Dota 2",
            "Resident Evil",
            "Xplane",
            "FIFA",
            "God of War",
            "Mobile Legends",
            "AOV",
            "The Witcher 3 : Wild Hunt",
        )

        dateGame = arrayListOf(
            "2022-7-1",
            "2024-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
            "2022-7-1",
        )

        ratingGame = arrayListOf(
            "4.0",
            "3.9",
            "3.5",
            "3.5",
            "3.8",
            "3.7",
            "3.2",
            "3.1",
            "4.0",
            "3.3",
        )

        genreGame = arrayListOf(
            arrayListOf("Action-Adventure","Open World"),
            arrayListOf("Creation System","Massively Multiplayer Online"),
            arrayListOf("MOBA","Strategy"),
            arrayListOf("Survival Horror","third-person shooter and first-person shooter games"),
            arrayListOf("Flight Simulation"),
            arrayListOf("Football Simulation"),
            arrayListOf("Action adventure game","Fantasy"),
            arrayListOf("MOBA","Strategy"),
            arrayListOf("MOBA","Strategy"),
            arrayListOf("Action","Fantasy"),
        )

        descGame = arrayListOf(
            "Grand Theft Auto V (GTA 5) adalah permainan laga-petualangan 2013 yang dikembangkan oleh Rockstar North dan diterbitkan oleh Rockstar Games. erlatar di dalam negara bagian fiksi San Andreas, yang berbasis di California Selatan, kisah pemain tunggal mengikuti tiga kriminal dan upaya mereka untuk melakukan pencurian sementara di bawah tekanan dari agen pemerintah dan tokoh-tokoh kejahatan yang kuat. ",
            "Roblox adalah sebuah platform permainan daring dan sistem pembuatan permainan yang memungkinkan pengguna memprogram permainan dan memainkan permainan yang dibuat oleh pengguna lain. Didirikan oleh David Baszucki dan almarhum Erik Cassel pada tahun 2004 dan secara resmi dirilis pada tahun 2006, platform ini menjadi tempat permainan yang dibuat pengguna dalam banyak genre, seperti permainan balap, permainan bermain-peran, simulasi dan kursus rintangan, diberi kode dalam bahasa pemrograman Lua.",
            "Dota 2 dimainkan dalam pertandingan antara dua tim yang terdiri dari lima pemain, dengan masing-masing tim menempati dan mempertahankan basis terpisah mereka sendiri di peta.  Masing-masing dari sepuluh pemain secara mandiri mengontrol karakter kuat yang dikenal sebagai 'pahlawan' yang semuanya memiliki kemampuan unik dan gaya permainan yang berbeda.  Selama pertandingan, pemain mengumpulkan poin pengalaman dan item untuk pahlawan mereka untuk mengalahkan pahlawan tim lawan dalam pertarungan pemain lawan pemain.  Sebuah tim menang dengan menjadi yang pertama menghancurkan 'Kuno' tim lain, sebuah bangunan besar yang terletak di dalam markas mereka.",
            "Resident Evil, yang dikenal di Jepang sebagai Biohazard, adalah serial permainan video horor Jepang dan waralaba media yang dibuat oleh Capcom. Ini terdiri dari game survival horror game survival horror, third-person shooter, dan first-person shooter. Waralaba telah berkembang menjadi serial film aksi langsung, film animasi, serial televisi, buku komik, novelisasi, novel, drama audio, dan media serta barang dagangan lainnya.",
            "X-Plane adalah seri mesin simulasi penerbangan yang dikembangkan dan diterbitkan oleh Laminar Research pada tahun 1995. X-Plane adalah satu-satunya simulator penerbangan yang cocok untuk Windows dan macOS, dengan versi desktop komersial dijual untuk macOS, Windows, dan Linux.",
            "Fifa adalah gim simulasi bertema sepak bola yang dirilis oleh Electronic Arts (EA) dan merupakan bagian dari seri FIFA. Gim ini adalah seri ke-30 di seri permainan tersebut. Gim ini dapat dimainkan di komputer, Nintendo Switch, PlayStation 4, PlayStation 5, Xbox One, Xbox seri X/S, dan Google Stadia. Edisi ini akan menjadi edisi final atas kerjasama EA dengan FIFA di seri sepak bola.",
            "God Of War mengangkat cerita berdasarkan mitologi yunani kuno. Ceritanya mengikuti Kratos, seorang prajurit Spartan dan kemudian Dewa Perang Yunani, yang ditipu untuk membunuh keluarganya oleh mantan tuannya, Dewa Perang Yunani asli Ares. Ini memicu serangkaian peristiwa yang mengarah pada perang dengan jajaran mitologis yang berbeda. Gim berbasis Yunani melihat Kratos mengikuti jalan balas dendam karena intrik para dewa Olympian",
            "Mobile Legends: Bang Bang adalah permainan video seluler ber-genre multiplayer online battle arena (MOBA) yang dikembangkan dan diterbitkan oleh Moonton, anak perusahaan dari ByteDance.",
            "Arena of Valor , sebelumnya Strike of Kings adalah adaptasi internasional dari Honor of Kings, sebuah arena pertarungan daring multipemain yang dikembangkan oleh  TiMi Studio Group dan diterbitkan oleh Level Infinite untuk Android, iOS, dan Nintendo Switch untuk pasar di luar Tiongkok Daratan.",
            "The Witcher 3: Wild Hunt mengisahkan Geralt of Rivia, yang mencari anak angkatnya, Ciri, yang sedang diburu oleh musuh lama Geralt, Wild Hunt. Ciri rupanya memiliki kemampuan khusus yang bisa membuat Wild Hunt mengadilkan dunia. Geralt telah menganggap Ciri sebagai anaknya sendiri, sehingga ia memutuskan untuk mengejarnya sebelum Wild Hunt berhasil menemukan Ciri.",
        )

        developerGame = arrayListOf(
            "Rockstar",
            "Roblox Corporation",
            "Valve",
            "Capcom, Nintendo, Sega, Ubisoft, Virgin Group",
            "Laminar Researchv",
            "EA Sports, Electronic Arts",
            "Santa Monica Studio",
            "Moonton",
            "TiMi Studio Group",
            "CD Projekt Red",
        )

        publisherGame = arrayListOf(
            "TakeTwoInteractive",
            "Roblox Corporation",
            "Valve",
            "Capcom",
            "Laminar Research",
            "EA Sports, Electronic Arts, EA Vancouver, EA Romania, EA Canada & EA Romania",
            "Sony Interactive Entertainment",
            "Moonton",
            "Level Infinite, ‎Garena",
            "CD Projekt",
        )

        imgGameplayGame = arrayListOf(
            arrayListOf(R.drawable.gtav_gameplay1, R.drawable.gtav_gameplay2, R.drawable.gtav_gameplay3),
            arrayListOf(R.drawable.roblox_gameplay1, R.drawable.roblox_gameplay2, R.drawable.roblox_gameplay3),
            arrayListOf(R.drawable.dota2_gameplay2, R.drawable.dota2_gameplay1, R.drawable.dota2_gameplay3),
            arrayListOf(R.drawable.re_gameplay1, R.drawable.re_gameplay2, R.drawable.re_gameplay3),
            arrayListOf(R.drawable.xplane_gameplay3, R.drawable.xplane_gameplay2, R.drawable.xplane_gameplay1),
            arrayListOf(R.drawable.fifa_gameplay3, R.drawable.fifa_gameplay2, R.drawable.fifa_gameplay1),
            arrayListOf(R.drawable.gow_gameplay3, R.drawable.gow_gameplay2, R.drawable.gow_gameplay1),
            arrayListOf(R.drawable.ml_gameplay1, R.drawable.ml_gameplay2, R.drawable.ml_gameplay3),
            arrayListOf(R.drawable.aov_gameplay3, R.drawable.aov_gameplay2, R.drawable.aov_gameplay1),
            arrayListOf(R.drawable.game2, R.drawable.game3, R.drawable.game4),
        )

        rvGame = binding.rvListGame;
        rvGame.layoutManager = LinearLayoutManager(this)

        gameArrayList = arrayListOf<ItemsGameModel>()
        getListGame()

    }

    private fun getListGame() {
        for (i in imgGame.indices){
            val games = ItemsGameModel(imgGame[i],titleGame[i],dateGame[i],ratingGame[i],genreGame[i],descGame[i],developerGame[i],publisherGame[i],imgGameplayGame[i])
            gameArrayList.add(games)
        }

        var adapter = RecyclerViewGameAdapter(gameArrayList)
        rvGame.adapter = adapter

        adapter.setOnItemClickListener(object : RecyclerViewGameAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//              Toast.makeText(this@MainActivity,"Berhasil pindah",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity,DetailItem::class.java)
                intent.putExtra("imgGame",gameArrayList[position].imgGame)
                intent.putExtra("titleGame",gameArrayList[position].titleGame)
                intent.putExtra("dateGame",gameArrayList[position].dateGame)
                intent.putExtra("ratingGame",gameArrayList[position].ratingGame)
                intent.putExtra("genreGame",(gameArrayList[position].genreGame))
                intent.putExtra("descGame",gameArrayList[position].descGame)
                intent.putExtra("developerGame",gameArrayList[position].developerGame)
                intent.putExtra("publisherGame",gameArrayList[position].publisherGame)
                intent.putExtra("imgGameplayGame",gameArrayList[position].imgGameplayGame)
                startActivity(intent)
            }
        })
    }
}