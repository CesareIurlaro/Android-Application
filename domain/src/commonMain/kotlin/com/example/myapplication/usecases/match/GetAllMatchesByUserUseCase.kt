package com.example.myapplication.usecases.match

import com.example.myapplication.entities.MatchEntity
import com.example.myapplication.entities.UserEntity
import com.example.myapplication.repositories.ArenaTournamentRepository
import com.example.myapplication.usecases.UseCaseWithParams

class GetAllMatchesByUserUseCase(
    private val repository: ArenaTournamentRepository
) : UseCaseWithParams<GetAllMatchesByUserUseCase.Params, List<MatchEntity>> {

    override suspend fun buildAction(params: Params): List<MatchEntity> {
        val toReturn = mutableListOf<MatchEntity>()
        var pageNumber = 0
        var pageContent = repository.getMatchesByUser(params.user.id, pageNumber)
        toReturn.addAll(pageContent)
        pageNumber++
        while (pageContent.isNotEmpty() && pageNumber <= params.maxPage) {
            pageContent = repository.getMatchesByUser(params.user.id, pageNumber)
            toReturn.addAll(pageContent)
            pageNumber++
        }
        return toReturn
    }

    suspend fun buildAction(page: Int = 1): List<MatchEntity> {
        val user = repository.getCurrentUser()
        return buildAction(Params(user, page))
    }

    data class Params(val user: UserEntity, val maxPage: Int = 1)

}