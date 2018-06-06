package lac.plugin.analytic.impl

import lac.plugin.analytic.Analytic

internal class FileAnalytic : Analytic {
    override fun event(name: String) {
        println("ANALYTIC FILE $name")
    }
}