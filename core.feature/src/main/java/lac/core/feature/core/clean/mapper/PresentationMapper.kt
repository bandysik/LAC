package lac.core.feature.core.clean.mapper

interface PresentationMapper<out V, in D> {

    fun mapToView(type: D): V
}