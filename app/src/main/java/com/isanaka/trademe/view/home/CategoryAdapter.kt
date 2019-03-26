package com.isanaka.trademe.view.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isanaka.trademe.R
import com.isanaka.trademe.core.onClick
import com.isanaka.trademe.data.model.Category
import kotlinx.android.synthetic.main.category_list_item.view.*


class CategoryAdapter(private var items: MutableList<Category>, private var onclick: ((View, Int, Int) -> Unit)) :
    RecyclerView.Adapter<CategoryAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemHolder =
        ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position])
        holder.onClick(onclick)
    }

    inner class ItemHolder(
        val view: View

    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: Category) = with(item) {
            view.categoryTitle.text = this.name
            view.tag = this.number
        }
    }

    fun add(list: List<Category>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

}