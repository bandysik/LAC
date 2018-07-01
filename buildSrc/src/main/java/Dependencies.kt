object Versions {
    val compileSdkVersion = 27
    val minSdkVersion = 19
    val targetSdkVersion = 27

    val kotlin = "1.2.21"

    //ANDROID
    val support = "27.1.1"
    val constraint = "1.1.0"
    val ktx = "0.3"
    val room = "1.0.0"
    val firebase = "16.0.0"

    //OTHER
    val koin = "0.9.3"
    val timber = "4.7.0"
    val stetho = "1.5.0"
    val retrofit = "2.4.0"
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
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"

    //ANDROID
    val android_support_compat = "com.android.support:appcompat-v7:${Versions.support}"
    val android_design = "com.android.support:design:${Versions.support}"
    val android_vector = "com.android.support:support-vector-drawable:${Versions.support}"
    val android_constraint =
            "com.android.support.constraint:constraint-layout:${Versions.constraint}"

    val arch_room = "android.arch.persistence.room:runtime:${Versions.room}"

    val ktx_core = "androidx.core:core-ktx:${Versions.ktx}"

    val firebase_core = "com.google.firebase:firebase-core:${Versions.firebase}"
    val firebase_config = "com.google.firebase:firebase-config:${Versions.firebase}"

    //OTHER
    val koin_core = "org.koin:koin-core:${Versions.koin}"
    val koin_android = "org.koin:koin-android:${Versions.koin}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    val leakcanary_no_op = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakcanary}"

    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"
    val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"

    //TEST
    val junit = "junit:junit:${Versions.junit}"
    val android_test_runner = "com.android.support.test:runner:${Versions.android_test}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}