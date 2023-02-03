package com.example.kinopoisk.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.databinding.FilmListItemBinding
import com.squareup.picasso.Picasso


class FilmAdapter(private val adapterOnClick: (Film) -> Unit) :
    ListAdapter<Film, FilmAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: FilmListItemBinding, val adapterOnClick: (Film) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) = with(binding) {
            name.text = film.nameRu
            country.text = film.nameEn
            Picasso.get().load(film.posterUrl).into(poster)
            binding.filmItem.setOnClickListener {
                adapterOnClick(film)
            }
        }

        companion object {
            fun create(parent: ViewGroup, adapterOnClick: (Film) -> Unit): ItemHolder {
                return ItemHolder(
                    FilmListItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false), adapterOnClick
                )
            }
        }
    }


    class ItemComparator : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent, adapterOnClick)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

}