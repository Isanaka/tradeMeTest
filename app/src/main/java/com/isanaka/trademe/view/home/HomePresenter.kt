package com.isanaka.trademe.view.home

import com.isanaka.trademe.data.model.*
import com.isanaka.trademe.data.network.ApiError
import com.isanaka.trademe.data.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable


class HomePresenter(val repo: AppRepository) : HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: HomeContract.View? = null
    private var categories: List<Category> = mutableListOf()
    private var listings: List<Listing> = mutableListOf()
    private var lastSelectedIndex = 0

    override fun attachView(view: HomeContract.View) {
        this.view = view
        showCategories()
    }

    fun showCategories() {
        repo.getCategories(
            fun(it: CategoryResponse) {
                categories = it.Subcategories
                view?.showCategories(categories)
                onCategorySelected(categories[lastSelectedIndex].number, lastSelectedIndex)
            },
            fun(it: ApiError) {
                view?.showError(it.message)
            },
            { view?.hideProgress() }
        ).also {
            if (it != null)
                compositeDisposable.add(it)
        }

    }

    override fun onListingSelected(position: Int) {

        listings.getOrNull(position)?.let {
            var params = ListingParam(
                listingId = "#" + it.listingId,
                title = it.title,
                photoUrl = it.photoUrls?.getOrNull(0)
            )
            view?.showListingDetails(params)

        }

    }

    override fun onCategorySelected(category: String, position: Int) {

        repo.getListings(category,
            fun(it: ListingResponse) {
                lastSelectedIndex = position
                view?.updateCategoryTitle(
                    CategoryDetails(
                        title = categories[position].name,
                        selected = position + 1,
                        total = categories.size
                    )
                )

                if (it.list.isNotEmpty()) {
                    listings = it.list
                    view?.showListings(listings)
                } else {
                    view?.showInfo()
                }
            },
            fun(it: ApiError) {
                view?.showError(it.message)
            },
            { view?.hideProgress() }
        ).also {
            if (it != null)
                compositeDisposable.add(it)
        }
    }

    override fun detachView() {
        this.view = null
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}