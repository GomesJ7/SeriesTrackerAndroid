package fr.eseo.seriestracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.eseo.seriestracker.data.local.AppDatabase
import fr.eseo.seriestracker.data.local.dao.TvShowDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "series_tracker_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTvShowDao(db: AppDatabase): TvShowDao = db.tvShowDao()
}
