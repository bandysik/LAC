package lac.feature.main.app.remote.model

data class RemoteFeed(val id: String,
                      val city: String,
                      val created: String,
                      val description: String,
                      val provider: String,
                      val providerLink: String)