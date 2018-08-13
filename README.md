# LAC (Lightweight Android Core)
A template project for the rapid development of the Android application.

The project is based on the principles of clean architecture and multi-modularity.

## Languages, libraries and tools used
- [Kotlin](http://kotlinlang.org/)
- [Koin](https://insert-koin.io/)
- [Timber](https://github.com/JakeWharton/timber)
- [Retrofit](http://square.github.io/retrofit/)
- [OkHTTP](http://square.github.io/okhttp/)
- [LeakCanary](https://github.com/square/leakcanary)
- [Stetho](https://github.com/facebook/stetho)
- [Crashlytics](https://fabric.io/kits/android/crashlytics/)
- [Firebase](https://firebase.google.com/)
- [RxKotlin](https://github.com/ReactiveX/RxKotlin)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Gson](https://github.com/google/gson)
- Android Support Libraries

## Requirements 
- JDK 1.8
- Android SDK
- Android P (API 27)
- Latest Android SDK Tools and build tools.

## Scope
- MVP
- DI
- Kotlin
- Rx
- Multi-modularity
- Multi-plugin structure

All proguard files contains in folder **proguard**

All keystore files contains in folder **keystore**

## Modularity
![Modularity](https://github.com/bandysik/LAC/blob/master/art/Modularity.png)

## Description of modules
All modules have prefix **[core|feature|plugin]**

###### core - for base modules
It is parent for modules: app, plugin and feature. All dependencies is inherited.

###### feature - for feature modules
It is functional brick for app. A lot of this feature-modules construct full application.

All feature modules don't know about other feature modules. They know only about plugin modules.

###### plugin - for plugin modules
It is cement for feature modules. 

One plugin module can be associated with multiple feature modules.

The main idea of plugin module is decoupling of helper logic of application. This small modules we can share with other application.

### buildSrc
Module for managing gradle.

In the class Dependencies.kt, you need to describe the dependencies that are added in gradle-modules.
> For example, api Deps.koin_core

### core.app
Just base module without any logic ;) (for future)

### core.feature
Base module for features.

This module contains base resources for all feature modules. Here placed base style of application, color-schemes, strings etc.
>You can use MVP, MVVM or other patterns for building screens of application (for current project it is MVP)
>Also, in current implementation of project, it is place for base UI-elements.
>We can use this module for utils classes.

### core.plugin
Base module for plugins.

Just base module without any logic ;) (for future)

### app
Module for Android application

### feature.main
Module for main application feature.

We can have a lot of feature modules with user logic and custom architectural approach.

All resources for module should be placed here.

### plugin.analytic
Module for analytic functional.

Describe Analytic interface for analytic in application (Firebase Analytic).
>see AppFirebaseAnalytic

### plugin.logger
Module for logger functional.

Interface Logger helps to describe logging functionality in one place for all project. 

### plugin.navigator
Module for navigation functional.

If you need to go to screen from diffrent feature.modules then interface Navigator helps you. Just describe what you need and implement this interface in app module.
>for example AppNavigator

### plugin.remoteconfig
Module for remoteconfig functional

Describe interface RemoteConfig for support remote configuration settings (Firebase Remote Config).

Implementation of this interface placed in app module.
>see AppFirebaseRemoteConfig

## Architecture of feature module
Current project based on MVP and Clean.
![Architecture](https://github.com/bandysik/LAC/blob/master/art/Architecture.png)

We have the following packages:
- mobile, presentation
- domain
- data
- cache
- remote

All modules contains own model classes and mappers for communication between layers.

All dependencies collected in MainModule class.
>Give name of DI for module in format [name_of_module]Module

## Example
For example of using this project, you can see on the feature.main as main module

## Todos
- Write Tests
- Add some plugins (image loader, FCM etc.)
- Review code and remove unused classes
- Add mocking of data from locale assets for debug mode

## References
- [https://engineeringblog.yelp.com/2018/06/how-yelp-modularized-the-android-app.html](https://engineeringblog.yelp.com/2018/06/how-yelp-modularized-the-android-app.html)
- [https://github.com/bufferapp/android-clean-architecture-boilerplate/](https://github.com/bufferapp/android-clean-architecture-boilerplate/)
- [https://github.com/Ekito/koin-samples/](https://github.com/Ekito/koin-samples/)

## License
Apache License 2.0
