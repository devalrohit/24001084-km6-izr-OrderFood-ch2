package com.catnip.layoutingexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.catnip.layoutingexample.databinding.ItemCatalogBinding
import com.example.layoutexaple.model.Catalog
import java.text.NumberFormat
import java.util.*

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    private val data = mutableListOf<Catalog>()

    fun submitData(items: List<Catalog>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val binding = ItemCatalogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CatalogViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class CatalogViewHolder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Catalog) {
            binding.tvCatalogName.text = item.name
            binding.ivCatalogImage.setImageResource(item.image)
            // Format price with currency symbol and Rp prefix
            val formattedPrice = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(item.price)
            binding.tvCatalogPrice.text = formattedPrice
        }
    }
}

