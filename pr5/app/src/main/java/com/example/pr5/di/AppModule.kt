package com.example.pr5.di

import android.content.Context
import androidx.room.Room
import com.example.pr5.data.AppDatabase
import com.example.pr5.data.ProductDao
import com.example.pr5.retrofit.api.MainApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMainApi(retrofit: Retrofit): MainApi =
        retrofit.create(MainApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "product_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao = database.productDao()
}