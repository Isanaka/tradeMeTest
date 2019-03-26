package com.isanaka.trademe.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.isanaka.trademe.R
import com.isanaka.trademe.base.BaseFragment
import com.isanaka.trademe.data.model.ListingParam
import kotlinx.android.synthetic.main.fragment_listing_details.*


class ListingDetailsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_listing_details, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listing: ListingParam? = arguments?.getParcelable("listing")
        listing?.let {
            listingDetailsTitle.text = it.title
            listingId.text = it.listingId
            it.photoUrl?.let {
                val requestOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .onlyRetrieveFromCache(true)

                Glide.with(this)
                    .load(it)
                    .apply(requestOptions)
                    .into(listingPhoto)

            }.also { hideProgress() }
        }
    }
}