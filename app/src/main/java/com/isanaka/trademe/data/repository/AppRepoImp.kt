package com.isanaka.trademe.data.repository

import com.isanaka.trademe.data.model.CategoryResponse
import com.isanaka.trademe.data.model.ListingResponse
import com.isanaka.trademe.data.network.ApiDisposable
import com.isanaka.trademe.data.network.ApiError
import com.isanaka.trademe.data.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppRepoImp(
    val apiService: ApiService
) : AppRepository {
    private val TAG = AppRepoImp::class.java.simpleName
    override fun getCategories(
        success: (CategoryResponse) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        return apiService
            .getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<CategoryResponse>(
                    {

                        success(it)
                    },
                    failure
                )
            )
    }

    override fun getListings(
        categoryNumber: String,
        success: (ListingResponse) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        return apiService
            .getListings(categoryNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<ListingResponse>(
                    {

                        success(it)
                    },
                    failure
                )
            )
    }


}