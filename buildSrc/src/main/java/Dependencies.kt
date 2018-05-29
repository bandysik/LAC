object Versions {
    val compileSdkVersion = 27
    val minSdkVersion = 19
    val targetSdkVersion = 27

    val kotlin = "1.2.21"

    //ANDROID
    val support = "27.1.1"
    val constraint = "1.1.0"
    val ktx = "0.3"

    //OTHER
    val koin = "0.9.3"
    val timber = "4.7.0"
    val stetho = "1.5.0"

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

    val ktx_core = "androidx.core:core-ktx:${Versions.ktx}"

    //OTHER
    val koin_core = "org.koin:koin-core:${Versions.koin}"
    val koin_android = "org.koin:koin-android:${Versions.koin}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    //TEST
    val junit = "junit:junit:${Versions.junit}"
    val android_test_runner = "com.android.support.test:runner:${Versions.android_test}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}