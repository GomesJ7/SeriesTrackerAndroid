package fr.eseo.seriestracker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.eseo.seriestracker.repository.SeriesRepository
import fr.eseo.seriestracker.repository.SeriesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSeriesRepository(
        impl: SeriesRepositoryImpl
    ): SeriesRepository
}
