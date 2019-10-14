package com.example.myapplication.modules

import com.example.myapplication.usecases.game.GetGamesByMode
import com.example.myapplication.usecases.game.GetGamesContainingName
import com.example.myapplication.usecases.match.GetAllAvailableMatchesUseCase
import com.example.myapplication.usecases.match.GetAllMatchesByUserUseCase
import com.example.myapplication.usecases.match.GetAvailableMatchesPerPage
import com.example.myapplication.usecases.match.GetMatchesByTournament
import com.example.myapplication.usecases.registration.GetAllRegistrationsByMatch
import com.example.myapplication.usecases.registration.GetRegistrationsByTournamentUseCase
import com.example.myapplication.usecases.registration.GetRegistrationsByUser
import com.example.myapplication.usecases.tournament.*
import com.example.myapplication.usecases.user.GetUserInfoUseCase
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.instance
import org.kodein.di.erased.singleton

object UseCasesModule : KodeinModuleProvider {
    override fun provideModule(): Kodein.Builder.() -> Unit = {
        bind<GetGamesByMode>() with singleton { GetGamesByMode(instance()) }
        bind<GetGamesContainingName>() with singleton { GetGamesContainingName(instance()) }
        bind<GetTournamentsByGame>() with singleton { GetTournamentsByGame(instance()) }
        bind<GetTournamentsByMode>() with singleton { GetTournamentsByMode(instance()) }
        bind<GetTournamentsContainingTitle>() with singleton { GetTournamentsContainingTitle(instance()) }
        bind<GetAllAvailableMatchesUseCase>() with singleton {
            GetAllAvailableMatchesUseCase(
                instance(),
                instance()
            )
        }
        bind<GetAllMatchesByUserUseCase>() with singleton { GetAllMatchesByUserUseCase(instance()) }
        bind<GetCreatedTournamentsByAdmin>() with singleton { GetCreatedTournamentsByAdmin(instance()) }
        bind<GetAvailableMatchesPerPage>() with singleton { GetAvailableMatchesPerPage(instance()) }
        bind<GetUserInfoUseCase>() with singleton { GetUserInfoUseCase(instance()) }
        bind<GetShowCaseTournaments>() with singleton { GetShowCaseTournaments(instance()) }
        bind<GetMatchesByTournament>() with singleton { GetMatchesByTournament(instance()) }
        bind<GetAllRegistrationsByMatch>() with singleton { GetAllRegistrationsByMatch(instance()) }
        bind<GetRegistrationsByUser>() with singleton { GetRegistrationsByUser(instance()) }
        bind<GetRegistrationsByTournamentUseCase>() with singleton { GetRegistrationsByTournamentUseCase(instance(), instance()) }






    }
}