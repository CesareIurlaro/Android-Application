package com.example.myapplication.mock

object MultipleRegistrationsResponse : JsonMockProvider {
    override val json = """
        {
          "_embedded": {
            "registrationEntities": [
              {
                "id": 1,
                "outcome": "Winner",
                "_links": {
                  "self": {
                    "href": "http://localhost:8080/registration/1"
                  },
                  "registrationEntity": {
                    "href": "http://localhost:8080/registration/1"
                  },
                  "tournament": {
                    "href": "http://localhost:8080/registration/1/tournament"
                  },
                  "user": {
                    "href": "http://localhost:8080/registration/1/user"
                  }
                }
              },
              {
                "id": 2,
                "outcome": "Loser",
                "_links": {
                  "self": {
                    "href": "http://localhost:8080/registration/2"
                  },
                  "registrationEntity": {
                    "href": "http://localhost:8080/registration/2"
                  },
                  "tournament": {
                    "href": "http://localhost:8080/registration/2/tournament"
                  },
                  "user": {
                    "href": "http://localhost:8080/registration/2/user"
                  }
                }
              },
              {
                "id": 3,
                "outcome": null,
                "_links": {
                  "self": {
                    "href": "http://localhost:8080/registration/3"
                  },
                  "registrationEntity": {
                    "href": "http://localhost:8080/registration/3"
                  },
                  "tournament": {
                    "href": "http://localhost:8080/registration/3/tournament"
                  },
                  "user": {
                    "href": "http://localhost:8080/registration/3/user"
                  }
                }
              }
            ]
          },
          "_links": {
            "self": {
              "href": "http://localhost:8080/registration{?page,size,sort}",
              "templated": true
            },
            "profile": {
              "href": "http://localhost:8080/profile/registration"
            },
            "search": {
              "href": "http://localhost:8080/registration/search"
            }
          },
          "page": {
            "size": 20,
            "totalElements": 3,
            "totalPages": 1,
            "number": 0
          }
        }
    """.trimIndent()
}