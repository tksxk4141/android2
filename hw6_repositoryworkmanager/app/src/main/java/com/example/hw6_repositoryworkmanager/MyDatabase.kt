package com.example.hw6_repositoryworkmanager

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class ContributorD(
    @PrimaryKey val login: String,
    val contributions: Int
)

@Dao
interface MyDao {
    @Query("SELECT * FROM ContributorD")
    fun getAll(): LiveData<List<ContributorD>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contributors: List<ContributorD>)

}

@Database(entities = [ContributorD::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract val myDao : MyDao

    companion object {
        private var INSTANCE: MyDatabase? = null
        fun getDatabase(context: Context) : MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, MyDatabase::class.java, "contributors_database")
                    .build()
            }
            return INSTANCE as MyDatabase
        }
    }
}