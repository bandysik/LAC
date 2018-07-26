package lac.feature.main.app.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteProvider(@SerializedName("id") val id: String,
                          @SerializedName("name") val name: String)