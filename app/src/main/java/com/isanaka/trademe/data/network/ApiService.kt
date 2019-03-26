package com.isanaka.trademe.data.network

import com.isanaka.trademe.data.model.CategoryResponse
import com.isanaka.trademe.data.model.ListingResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/Categories/0.json?depth=1&with_counts=false")
    fun getCategories(): Observable<CategoryResponse>

    @GET("v1/Search/General.json?buy=All&rows=20&photo_size=Large")
    fun getListings(@Query("category") category: String): Observable<ListingResponse>

}