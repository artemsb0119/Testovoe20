package com.example.testovoe20

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MatchAdapter(private val context: Context, var matchs: List<Match>) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchs[position]
        holder.tire.text = "-"
        holder.team1.text = match.team1
        holder.team2.text = match.team2
        holder.textViewSport.text = match.sport
        holder.textViewDate.text = match.date
        holder.textViewShow.text = "Show details"
        holder.textViewKoef.text = match.koef
        Glide.with(holder.itemView.context).load(match.image1).into(holder.image1)
        Glide.with(holder.itemView.context).load(match.image2).into(holder.image2)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("match", match)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return matchs.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tire: TextView = itemView.findViewById(R.id.tire)
        val team1: TextView = itemView.findViewById(R.id.team1)
        val team2: TextView = itemView.findViewById(R.id.team2)
        val image1: ImageView = itemView.findViewById(R.id.image1)
        val image2: ImageView = itemView.findViewById(R.id.image2)
        val textViewSport: TextView = itemView.findViewById(R.id.textViewSport)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        val textViewShow: TextView = itemView.findViewById(R.id.textViewShow)
        val textViewKoef: TextView = itemView.findViewById(R.id.textViewKoef)
    }
}