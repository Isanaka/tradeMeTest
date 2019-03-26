package com.isanaka.trademe.view.home

import com.isanaka.trademe.data.network.ApiService
import com.isanaka.trademe.data.repository.AppRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest {
    @InjectMocks
    lateinit var presenter: HomeContract.Presenter
    @Mock
    lateinit var mockRepo: AppRepository
    @Mock
    lateinit var mockView:HomeContract.View


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testAttachView() {

    }

    @Test
    fun testShowCategories() {
    }

    @Test
    fun testOnListingSelected() {
    }

    @Test
    fun testOnCategorySelected() {
    }

    @Test
    fun testDetachView() {
    }

    @Test
    fun testGetRepo() {
    }
}