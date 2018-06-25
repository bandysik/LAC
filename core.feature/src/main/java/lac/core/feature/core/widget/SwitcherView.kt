package lac.core.feature.core.widget

import android.content.Context
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet

class SwitcherView @JvmOverloads constructor(context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyleAttr: Int = 0) : SwitchCompat(context,
                                                                                   attrs,
                                                                                   defStyleAttr){
    init {
        typeface
    }
}