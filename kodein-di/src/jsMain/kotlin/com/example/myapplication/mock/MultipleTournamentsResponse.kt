package com.example.myapplication.mock

object MultipleTournamentsResponse : JsonMockProvider {
    override val json = """
        {
          "_embedded": {
            "tournamentEntities": [
              {
                "id": 1,
                "playersNumber": 16,
                "tournamentDescription": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed neque at diam rhoncus lacinia in in est. Aliquam turpis magna, tincidunt pharetra laoreet vitae, tempus luctus urna. Duis sit amet ullamcorper orci. Vestibulum et accumsan orci. Sed lacinia blandit odio a luctus. Pellentesque sit amet lorem iaculis, posuere turpis non, dignissim est. Nullam maximus fermentum velit, nec iaculis erat aliquam quis. Phasellus sed augue mi. Maecenas sed nisi lorem. Donec rhoncus dolor lectus, non ultricies massa vehicula ac. In pharetra quam urna, ac ornare neque rutrum quis. Phasellus ultricies lacinia nulla, at ultricies augue accumsan vitae. Praesent sodales magna vel placerat placerat.",
                "tournamentMode": "RANKED",
                "title": "My Mock Tournament 1",
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
              },
              {
                "id": 2,
                "playersNumber": 32,
                "tournamentDescription": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sed neque at diam rhoncus lacinia in in est. Aliquam turpis magna, tincidunt pharetra laoreet vitae, tempus luctus urna. Duis sit amet ullamcorper orci. Vestibulum et accumsan orci. Sed lacinia blandit odio a luctus. Pellentesque sit amet lorem iaculis, posuere turpis non, dignissim est. Nullam maximus fermentum velit, nec iaculis erat aliquam quis. Phasellus sed augue mi. Maecenas sed nisi lorem. Donec rhoncus dolor lectus, non ultricies massa vehicula ac. In pharetra quam urna, ac ornare neque rutrum quis. Phasellus ultricies lacinia nulla, at ultricies augue accumsan vitae. Praesent sodales magna vel placerat placerat.",
                "tournamentMode": "FREE_FOR_ALL",
                "title": "My Mock Tournament 2",
                "_links": {
                  "self": {
                    "href": "http://localhost:8080/tournament/2"
                  },
                  "tournamentEntity": {
                    "href": "http://localhost:8080/tournament/2"
                  },
                  "game": {
                    "href": "http://localhost:8080/tournament/2/game"
                  },
                  "admin": {
                    "href": "http://localhost:8080/tournament/2/admin"
                  }
                }
              }
            ]
          },
          "_links": {
            "self": {
              "href": "http://localhost:8080/tournament{?page,size,sort}",
              "templated": true
            },
            "profile": {
              "href": "http://localhost:8080/profile/tournament"
            },
            "search": {
              "href": "http://localhost:8080/tournament/search"
            }
          },
          "page": {
            "size": 20,
            "totalElements": 2,
            "totalPages": 1,
            "number": 0
          }
        }
    """.trimIndent()
}