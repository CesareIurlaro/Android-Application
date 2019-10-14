package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.GameEntity
import com.example.myapplication.entities.MatchEntity
import com.example.myapplication.entities.TournamentEntity
import com.example.myapplication.entities.UserEntity
import com.example.myapplication.usecases.game.GetGamesByMode
import com.example.myapplication.usecases.game.GetGamesContainingName
import com.example.myapplication.usecases.match.GetAllAvailableMatchesUseCase
import com.example.myapplication.usecases.match.GetAllMatchesByUserUseCase
import com.example.myapplication.usecases.match.GetMatchesByTournament
import com.example.myapplication.usecases.registration.GetAllRegistrationsByMatch
import com.example.myapplication.usecases.registration.GetRegistrationsByTournamentUseCase
import com.example.myapplication.usecases.registration.GetRegistrationsByUser
import com.example.myapplication.usecases.tournament.*
import com.example.myapplication.usecases.user.GetUserInfoUseCase
import com.soywiz.klock.DateTimeTz
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getGamesByMode: GetGamesByMode,
    private val getGamesContainingName: GetGamesContainingName,
    private val getAllAvailableMatchesUseCase: GetAllAvailableMatchesUseCase,
    private val getAllMatchesByUserUseCase: GetAllMatchesByUserUseCase,
    private val getUserInfo: GetUserInfoUseCase,
    private val getCreatedTournamentsByAdmin: GetCreatedTournamentsByAdmin,
    private val getShowcaseTournaments: GetShowCaseTournaments,
    private val getRegistrationsByTournamentUseCase: GetRegistrationsByTournamentUseCase,
    private val getTournamentsByGame: GetTournamentsByGame,
    private val getTournamentsByMode: GetTournamentsByMode,
    private val getTournamentsContainingTitle: GetTournamentsContainingTitle,
    private val getRegistrationsByMatch: GetAllRegistrationsByMatch,
    private val getRegistrationsByUser: GetRegistrationsByUser,
    private val getMatchesByTournament: GetMatchesByTournament
) : ViewModel() {

    data class MatchWithPlayersCountModel(val matchEntity: MatchEntity, val registeredPlayer: Int)

    private val _matches = MutableLiveData<List<MatchWithPlayersCountModel>>()
    val text: LiveData<List<MatchWithPlayersCountModel>> = _matches

    val dummyUser = UserEntity("User", "user@user.user", "nickname", "image", true)

    val dummyGame = GameEntity("COD", listOf("Free4All"), "image", "icon")

    val dummyTournament =
        TournamentEntity(42, 42, "42", "42",
            "42", dummyUser, dummyGame)

    val dummyMatch =
        MatchEntity(42, DateTimeTz.nowLocal(), 42, true, dummyTournament)

    /*
        fun derp() {
            getAllAvailableMatchesUseCase.buildActionAsync(GetAllAvailableMatchesUseCase.Params(1)) {
                it.map { MatchWithPlayersCountModel(it.first, it.second) }
                    .let { _matches.value = it }
            }
        }
     */

    fun getGamesByMode() = viewModelScope.launch {
        getGamesByMode.buildAction(dummyGame.availableModes[0])
    }

    fun getGamesContainingName() = viewModelScope.launch {
        getGamesContainingName.buildAction(dummyGame.name)
    }

    fun getAllAvailableMatches() = viewModelScope.launch {
        getAllAvailableMatchesUseCase.buildAction()
            .map { MatchWithPlayersCountModel(it.first, it.second) }
            .let { _matches.value = it }
    }

    fun getMatchesByUser() = viewModelScope.launch {
        getAllMatchesByUserUseCase.buildAction()
    }

    fun getMatchesByTournament() = viewModelScope.launch {
        getMatchesByTournament.buildAction(dummyTournament)
    }

    fun getRegistrationsByMatch() = viewModelScope.launch {
        getRegistrationsByMatch.buildAction(dummyMatch)
    }

    fun getRegistrationByTournament() = viewModelScope.launch {
        getRegistrationsByTournamentUseCase.buildAction(dummyTournament)
    }

    fun getRegistrationsByUser() = viewModelScope.launch {
        getRegistrationsByUser.buildAction(dummyUser)
    }

    fun getTournamentsByAdmin() = viewModelScope.launch {
        getCreatedTournamentsByAdmin.buildAction()
    }


    fun getShowcaseTournaments() = viewModelScope.launch {
        getShowcaseTournaments.buildAction()
    }

    fun getTournamentsByGame() = viewModelScope.launch {
        getTournamentsByGame.buildAction(dummyGame)
    }

    fun getTournamentsByMode() = viewModelScope.launch {
        getTournamentsByMode.buildAction(dummyGame.availableModes[0])
    }

    fun getTournamentsContainingTitle() = viewModelScope.launch {
        getTournamentsContainingTitle.buildAction(dummyTournament.title)
    }

    fun getUserInformation() = viewModelScope.launch {
        getUserInfo.buildAction()
    }




}