package lac.feature.main.app.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteCity(@SerializedName("code") val code: String,
                      @SerializedName("name") val name: String)