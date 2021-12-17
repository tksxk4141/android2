package com.example.hw6_repositoryworkmanager

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepository(context: Context) {
    private val baseURL = "https://api.github.com/"
    private val api = retrofitInit(baseURL)
    private val myDao = MyDatabase.getDatabase(context).myDao

    val contributors = myDao.getAll()

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            val contributors = api.contributors("jyheo","android-kotlin-lecture")

            val contributorDs = contributors.map{
                ContributorD(it.login, it.contributions)
            }
            myDao.insertAll(contributorDs)
        }
    }

}