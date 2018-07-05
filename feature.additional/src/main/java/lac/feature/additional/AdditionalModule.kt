package lac.feature.additional

import android.app.Application
import lac.feature.additional.pro.proSubModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AdditionalModule {

    val additionalModule = applicationContext {

    }

    fun init(): List<Module> {
        return listOf(additionalModule, proSubModule)
    }
}