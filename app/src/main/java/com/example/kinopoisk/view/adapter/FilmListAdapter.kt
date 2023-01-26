package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.Test.Film

class FilmListAdapter() : RecyclerView.Adapter<FilmListAdapter.ListViewHolder?>() {
    private var filmList = emptyList<Film>()

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvTitle)
        val country: TextView = itemView.findViewById(R.id.tvCases)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.film_list_item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = filmList[position]
        holder.name.text = currentItem.name
        holder.country.text = currentItem.country
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun setData(films: List<Film>){
        filmList = films
        notifyDataSetChanged()
    }
}