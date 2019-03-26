package com.isanaka.trademe.view.home

import com.isanaka.trademe.base.BasePresenter
import com.isanaka.trademe.base.BaseView
import com.isanaka.trademe.data.model.Category
import com.isanaka.trademe.data.model.CategoryDetails
import com.isanaka.trademe.data.model.Listing
import com.isanaka.trademe.data.model.ListingParam


class HomeContract {

    interface View : BaseView {
        fun showCategories(categories: List<Category>)
        fun showListings(listings: List<Listing>)
        fun updateCategoryTitle(categoryDetails: CategoryDetails)
        fun showListingDetails(params: ListingParam)
        fun showError(message: String)
        fun showInfo()
    }

    interface Presenter : BasePresenter<View> {
        fun onCategorySelected(category: String, position: Int)
        fun onListingSelected(position: Int)
    }
}