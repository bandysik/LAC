//package lac.feature.main.data.source.remote
//
//import okhttp3.OkHttpClient
//import retrofit2.Converter
//import retrofit2.Retrofit
//
//interface SchedulerProvider {
//    fun main(): Scheduler
//    fun thread(): Scheduler
//}
//
//fun schedules(): SchedulerProvider = object : SchedulerProvider {
//    override fun main(): Scheduler {
//        return AndroidSchedulers.mainThread()
//    }
//
//    override fun thread(): Scheduler {
//        return Schedulers.io()
//    }
//}
//
//fun okhttpClient(): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//        .connectTimeout(10, TimeUnit.SECONDS)
//        .readTimeout(10, TimeUnit.SECONDS)
//        .writeTimeout(10, TimeUnit.SECONDS)
//        .build();
//
//fun moshi(): Moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()
//
//fun converterFactory(moshi: Moshi): Converter.Factory = MoshiConverterFactory.create(moshi);
//
//
//fun retrofit(httpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit =
//        Retrofit.Builder()
//                .baseUrl("http://pinyin.consistence.io/")
//                .client(httpClient)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(converterFactory)
//                .build()