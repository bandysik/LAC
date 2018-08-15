object SdkVersions {
    val compileSdkVersion = 27
    val minSdkVersion = 19
    val targetSdkVersion = 27
}

object DepsVersions {
    val kotlin = "1.2.50"

    //ANDROID
    val support = "27.1.1"
    val constraint = "1.1.0"
    val ktx = "0.3"
    val room = "1.0.0"
    val firebase = "16.0.1"
    val firebaseConfig = "16.0.0"

    //OTHER
    val koin = "0.9.3"
    val timber = "4.7.0"
    val stetho = "1.5.0"
    val retrofit = "2.4.0"
    val okHttpVersion = "3.8.1"
    val leakcanary = "1.5.4"
    val crashlytics = "2.9.4"
    val rx_kotlin = "2.2.0"
    val rx_android = "2.0.2"

    //TEST
    val junit = "4.12"
    val android_test = "1.0.2"
    val espresso = "3.0.2"
}

object Deps {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${DepsVersions.kotlin}"

    //ANDROID
    val android_support_compat = "com.android.support:appcompat-v7:${DepsVersions.support}"
    val android_design = "com.android.support:design:${DepsVersions.support}"
    val android_vector = "com.android.support:support-vector-drawable:${DepsVersions.support}"
    val android_constraint =
            "com.android.support.constraint:constraint-layout:${DepsVersions.constraint}"

    val arch_room = "android.arch.persistence.room:runtime:${DepsVersions.room}"

    val ktx_core = "androidx.core:core-ktx:${DepsVersions.ktx}"

    val firebase_core = "com.google.firebase:firebase-core:${DepsVersions.firebase}"
    val firebase_config = "com.google.firebase:firebase-config:${DepsVersions.firebaseConfig}"
    val firebase_database = "com.google.firebase:firebase-database:${DepsVersions.firebase}"

    //OTHER
    val koin_core = "org.koin:koin-core:${DepsVersions.koin}"
    val koin_android = "org.koin:koin-android:${DepsVersions.koin}"

    val retrofit = "com.squareup.retrofit2:retrofit:${DepsVersions.retrofit}"
    val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${DepsVersions.retrofit}"
    val retrofit_adapter = "com.squareup.retrofit2:adapter-rxjava2:${DepsVersions.retrofit}"
    val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${DepsVersions.okHttpVersion}"

    val timber = "com.jakewharton.timber:timber:${DepsVersions.timber}"

    val stetho = "com.facebook.stetho:stetho:${DepsVersions.stetho}"

    val leakcanary = "com.squareup.leakcanary:leakcanary-android:${DepsVersions.leakcanary}"
    val leakcanary_no_op = "com.squareup.leakcanary:leakcanary-android-no-op:${DepsVersions.leakcanary}"

    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${DepsVersions.crashlytics}"

    val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${DepsVersions.rx_kotlin}"
    val rx_android = "io.reactivex.rxjava2:rxandroid:${DepsVersions.rx_android}"

    //TEST
    val junit = "junit:junit:${DepsVersions.junit}"
    val android_test_runner = "com.android.support.test:runner:${DepsVersions.android_test}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${DepsVersions.espresso}"
}