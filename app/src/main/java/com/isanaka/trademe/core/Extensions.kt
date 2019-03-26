package com.isanaka.trademe.core

import android.support.v7.widget.RecyclerView
import android.view.View

fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(it, adapterPosition)
    }
    return this
}