package com.alfgarsan.android.mvvmrxyesno.model.repository

import com.alfgarsan.android.mvvmrxyesno.model.domain.Answer
import com.alfgarsan.android.mvvmrxyesno.model.data.api.AnswerApiService
import io.reactivex.Observable
import javax.inject.Inject

class AnswerRepositoryImpl @Inject constructor(
    private val answerApiService: AnswerApiService
    //In this example there isn't DAO for answer
) : AnswerRepository{

    override fun getAnswer(): Observable<Answer> {
        return answerApiService.getAnswer().map { it.toDomain()}
    }
}