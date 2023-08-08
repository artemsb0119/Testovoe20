package com.example.testovoe20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class DetailActivity : AppCompatActivity() {

    private lateinit var levo: ImageView
    private lateinit var team1: TextView
    private lateinit var team2: TextView
    private lateinit var textViewSport: TextView
    private lateinit var textViewDate: TextView
    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var textViewText: TextView
    private lateinit var textViewRes: TextView
    private lateinit var textViewKoef: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        levo = findViewById(R.id.levo)
        team1 = findViewById(R.id.team1)
        team2 = findViewById(R.id.team2)
        textViewSport = findViewById(R.id.textViewSport)
        textViewDate = findViewById(R.id.textViewDate)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        textViewText = findViewById(R.id.textViewText)
        textViewRes = findViewById(R.id.textViewRes)
        textViewKoef = findViewById(R.id.textViewKoef)

        levo.setOnClickListener {
            finish()
        }

        val match = intent.getSerializableExtra("match") as? Match
        if (match != null) {
            team1.text = match.team1
            team2.text = match.team2
            textViewSport.text = match.sport
            textViewDate.text = match.date

            Glide.with(this)
                .load(match.image1)
                .into(image1)

            Glide.with(this)
                .load(match.image2)
                .into(image2)

            textViewKoef.text = match.koef
            textViewText.text = match.prognoz
            textViewRes.text = match.res
        }
    }
}