package com.example.tugas_pahlawan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_pahlawan.databinding.ItemContainerPahlawanBinding

typealias OnClickHero = (Hero) -> Unit

class HeroAdapter(private val listHero: List<Hero>, private val  onClickDisaster: OnClickHero) :
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {
    inner class ItemHeroViewHolder(private val binding: ItemContainerPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemImage: ImageView = itemView.findViewById(R.id.imageHero)
        fun bind(data: Hero) {
            with(binding) {
                txtHeroName.text = data.heroName
                txtHeroDesc.text = data.heroDesc
                itemImage.setImageResource(data.heroImage)
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemHeroViewHolder {
        val binding =
            ItemContainerPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHeroViewHolder(binding)
    }
    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
}

