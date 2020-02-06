package com.example.myapplication.mock

object TournamentResponse : JsonMockProvider {
    override val json = """
        {
          "id": 1,
          "playersNumber": 16,
          "tournamentDescription": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed neque at diam rhoncus lacinia in in est. Aliquam turpis magna, tincidunt pharetra laoreet vitae, tempus luctus urna. Duis sit amet ullamcorper orci. Vestibulum et accumsan orci. Sed lacinia blandit odio a luctus. Pellentesque sit amet lorem iaculis, posuere turpis non, dignissim est. Nullam maximus fermentum velit, nec iaculis erat aliquam quis. Phasellus sed augue mi. Maecenas sed nisi lorem. Donec rhoncus dolor lectus, non ultricies massa vehicula ac. In pharetra quam urna, ac ornare neque rutrum quis. Phasellus ultricies lacinia nulla, at ultricies augue accumsan vitae. Praesent sodales magna vel placerat placerat.",
          "tournamentMode": "RANKED",
          "title": "My MockTournament 1",
          "_links": {
            "self": {
              "href": "http://localhost:8080/tournament/1"
            },
            "tournamentEntity": {
              "href": "http://localhost:8080/tournament/1"
            },
            "game": {
              "href": "http://localhost:8080/tournament/1/game"
            },
            "admin": {
              "href": "http://localhost:8080/tournament/1/admin"
            }
          }
        }
    """.trimIndent()
}