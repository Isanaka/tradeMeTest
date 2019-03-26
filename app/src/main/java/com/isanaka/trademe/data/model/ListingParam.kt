package com.isanaka.trademe.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListingParam(
    val listingId: String,
    val title: String,
    val photoUrl: String?
) : Parcelable