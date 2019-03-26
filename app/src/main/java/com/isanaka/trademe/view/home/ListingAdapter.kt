package com.isanaka.trademe.view.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.isanaka.trademe.R
import com.isanaka.trademe.core.onClick
import com.isanaka.trademe.data.model.Listing
import kotlinx.android.synthetic.main.listing_list_item.view.*


class ListingAdapter(private var items: MutableList<Listing>, private var onclick: ((View, Int) -> Unit)) :
    RecyclerView.Adapter<ListingAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemHolder =
        ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.listing_list_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position])
        holder.onClick(onclick)
    }

    inner class ItemHolder(
        val view: View

    ) : RecyclerView.ViewHolder(view) {

        private val imageView: ImageView = view.listingThumbnail
        private val textView: TextView = view.listingTitle

        fun bind(item: Listing) = with(item) {
            textView.text = this.title

            if (!photoUrls.isNullOrEmpty()) {
                val requestOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // because file name is always same

                Glide.with(view)
                    .load(this.photoUrls[0])
                    .apply(requestOptions)
                    .into(imageView)
            }
            view.tag = this.listingId
        }
    }

    fun add(list: List<Listing>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

}