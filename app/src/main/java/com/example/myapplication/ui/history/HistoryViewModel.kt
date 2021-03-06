package com.example.myapplication.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.entities.TournamentEntity
import com.example.myapplication.entities.UserEntity
import com.example.myapplication.usecases.tournament.GetTournamentsByUserUseCase
import com.example.myapplication.usecases.user.info.GetUserInfoByUidUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class HistoryViewModel(
    private val getUserInfoByUidUseCase: GetUserInfoByUidUseCase,
    private val getTournamentsByUserUseCase: GetTournamentsByUserUseCase
) : ViewModel() {

    data class Model(val user: UserEntity, val tournaments: List<TournamentEntity>)

    val model = MutableLiveData<Model>()

    fun loadUserInfo(userId: String)  = viewModelScope.launch {
        val u = async { getUserInfoByUidUseCase.buildAction(userId) }
        val t = async { getTournamentsByUserUseCase.buildAction(userId) }
        model.value = Model(u.await(), t.await())
    }

}