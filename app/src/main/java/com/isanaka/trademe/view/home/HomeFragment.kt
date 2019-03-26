package com.isanaka.trademe.view.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.isanaka.trademe.R
import com.isanaka.trademe.base.BaseFragment
import com.isanaka.trademe.data.model.Category
import com.isanaka.trademe.data.model.CategoryDetails
import com.isanaka.trademe.data.model.Listing
import com.isanaka.trademe.data.model.ListingParam
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomeContract.Presenter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var listingAdapter: ListingAdapter



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgress()
        intializeView()
        presenter.attachView(this@HomeFragment)

    }

    fun intializeView() {
        horizontalList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        verticalList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        listingAdapter = ListingAdapter(mutableListOf(), onListingClicked)
    }

    override fun updateCategoryTitle(categoryDetails: CategoryDetails) {
        categorySelectedDetails.text = resources.getString(
            R.string.category_details,
            categoryDetails.title,
            categoryDetails.selected,
            categoryDetails.total
        )
    }

    override fun showCategories(categories: List<Category>) {
        categoryAdapter = CategoryAdapter(categories.toMutableList(), onCategoryClicked)
        categoryAdapter.add(categories)
        horizontalList.adapter = categoryAdapter
    }

    override fun showListings(listings: List<Listing>) {
        listingAdapter.add(listings)
        verticalList.adapter = listingAdapter
        hideProgress()
    }

    override fun showListingDetails(params: ListingParam) {
        val bundle = Bundle()
        bundle.putParcelable("listing", params)
        view?.findNavController()?.navigate(R.id.ListingDetails, bundle)
    }


    override fun onDetach() {
        super.onDetach()
        presenter.detachView()
    }

    override fun showError(message: String) {
        infoAndError.text = message
        infoAndError.visibility = View.VISIBLE
        hideProgress()
    }

    override fun showInfo() {
        infoAndError.text = resources.getString(R.string.no_listing_found_for_this_category)
        infoAndError.visibility = View.VISIBLE
        hideProgress()
    }

    private val onCategoryClicked: (View, Int, Int) -> Unit = { view, position, type ->
        run {
            infoAndError.visibility = View.GONE
            showProgress()
            listingAdapter.clear()
            presenter.onCategorySelected(view.tag.toString(), position)
        }
    }

    private val onListingClicked: (View, Int, Int) -> Unit = { view, position, type ->
        showProgress()
        presenter.onListingSelected(position)
    }

}