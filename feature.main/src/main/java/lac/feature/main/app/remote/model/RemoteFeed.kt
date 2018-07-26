package lac.feature.main.app.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteFeed(@SerializedName("id") val id: String,
                      @SerializedName("city") val city: String,
                      @SerializedName("created") val created: String,
                      @SerializedName("description") val description: String,
                      @SerializedName("provider") val provider: String,
                      @SerializedName("providerLink") val providerLink: String)