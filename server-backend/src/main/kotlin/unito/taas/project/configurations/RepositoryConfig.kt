package unito.taas.project.configurations

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import unito.taas.project.data.*
import kotlin.reflect.KClass


@Configuration
class RepositoryConfig : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration): Unit = with(config) {
        exposeIdsFor(TournamentEntity::class, RegistrationEntity::class, GameEntity::class, ModeEntity::class)
    }

    private fun RepositoryRestConfiguration.exposeIdsFor(vararg kClasses: KClass<*>) =
            exposeIdsFor(*kClasses.map { it.java }.toTypedArray())
}
