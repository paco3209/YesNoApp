package com.alfgarsan.android.mvvmrxyesno.di

import com.alfgarsan.android.mvvmrxyesno.model.data.api.AnswerApiService
import com.alfgarsan.android.mvvmrxyesno.model.repository.AnswerRepository
import com.alfgarsan.android.mvvmrxyesno.model.repository.AnswerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://yesno.wtf"

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideYesNoApi(): AnswerApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnswerApiService::class.java)


    @Singleton
    @Provides
    fun provideMainRepository(api: AnswerApiService): AnswerRepository =
        AnswerRepositoryImpl(api)

}