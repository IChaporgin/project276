package ru.ichaporgin.project276.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.ichaporgin.project276.databinding.ViewholderItemBinding
import ru.ichaporgin.project276.domain.ItemsModel

class ItemsAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
        lateinit var context: Context
    class ViewHolder(val binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemsAdapter.ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$" + items[position].price.toString()
        holder.binding.subtitleTxt.text = items[position].extra

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .into(holder.binding.imageView2)
    }

    override fun getItemCount(): Int = items.size
}