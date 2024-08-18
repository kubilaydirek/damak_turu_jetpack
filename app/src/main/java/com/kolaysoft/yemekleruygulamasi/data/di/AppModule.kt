package com.kolaysoft.yemekleruygulamasi.data.di

import android.app.Application
import androidx.room.Room
import com.kolaysoft.yemekleruygulamasi.data.database.AppDatabase
import com.kolaysoft.yemekleruygulamasi.data.database.FoodDAO
import com.kolaysoft.yemekleruygulamasi.data.repository.AllFoodRepository
import com.kolaysoft.yemekleruygulamasi.data.repositoryImp.AllFoodRepositoryImp
import com.kolaysoft.yemekleruygulamasi.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://kasimadalan.pe.hu/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "AppDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodDAO(appDatabase: AppDatabase): FoodDAO {
        return appDatabase.foodDAO
    }

    @Provides
    @Singleton
    fun provideAllFoodRepository(
        apiService: ApiService,
        foodDAO: FoodDAO
    ): AllFoodRepository {
        return AllFoodRepositoryImp(apiService, foodDAO)
    }
}