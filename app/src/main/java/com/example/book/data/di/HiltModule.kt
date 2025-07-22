package com.example.book.data.di

import com.example.book.data.Repoimpl.AllBookRepoImpl
import com.example.book.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule{

    @Provides
    @Singleton
    fun provideRealtimeDatabase() : FirebaseDatabase{

        return  FirebaseDatabase.getInstance()
    }


    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase):AllBookRepo{

        return AllBookRepoImpl(firebaseDatabase)
    }
}
