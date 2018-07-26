package lac.feature.main.app.remote

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import lac.feature.main.app.remote.model.RemoteCity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MainServiceFactory {
    fun makeMainService(isDebug: Boolean): MainService {
        val okHttpClient = makeOkHttpClient(makeLoggingInterceptor(isDebug))
        return makeMainService(okHttpClient, makeGson())
    }

    private fun makeMainService(okHttpClient: OkHttpClient, gson: Gson): MainService {
        val retrofit =
                Retrofit.Builder()
                    .baseUrl("https://www.dropbox.com/s/")
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        return retrofit.create(MainService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private fun makeGson(): Gson {
        return GsonBuilder().setLenient()
//            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//            .registerTypeAdapter(object : TypeToken<Map<Int, RemoteCity>>() {}.type,)
            .create()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
        return logging
    }
}