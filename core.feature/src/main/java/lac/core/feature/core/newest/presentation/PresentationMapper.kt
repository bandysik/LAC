package lac.core.feature.core.newest.presentation

interface PresentationMapper<out V, in D> {

    fun mapToView(type: D): V
}