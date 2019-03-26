package com.isanaka.trademe.data.repository

import com.isanaka.trademe.data.model.CategoryResponse
import com.isanaka.trademe.data.model.ListingResponse
import com.isanaka.trademe.data.network.ApiError
import io.reactivex.disposables.Disposable

interface AppRepository {

    fun getCategories(
        success: (CategoryResponse) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable

    fun getListings(
        categoryNumber: String,
        success: (ListingResponse) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable
}