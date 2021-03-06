package unito.taas.project.controllers

import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class UserExceptionHandler {

    private val content by lazy {
        ResponseEntity.ok().contentType(MediaType.TEXT_HTML)
            .body(ClassPathResource("static/index.html").file.readText())
    }

    @GetMapping("{res:\\w+}")
    fun serve(@PathVariable res: String) =
        try {
            ResponseEntity.ok().apply {
                if (res.endsWith(".js"))
                    header("Content-Type", "application/javascript")
                body(ClassPathResource("static/${res}").file.readText())
            }
        } catch (e: Throwable) {
            content
        }

    @GetMapping("tournament/**")
    fun serve() = content

}
