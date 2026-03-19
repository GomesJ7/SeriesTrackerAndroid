package fr.eseo.seriestracker.di

import fr.eseo.seriestracker.network.SeriesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideSeriesApi(): SeriesApi {
        return Retrofit.Builder()
            .baseUrl(SeriesApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SeriesApi::class.java)
    }
}