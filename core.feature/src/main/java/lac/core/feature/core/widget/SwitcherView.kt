package lac.core.feature.core.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.view_switcher.view.*
import lac.core.feature.R

class SwitcherView @JvmOverloads constructor(context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyleAttr: Int = 0) : LinearLayout(context,
        attrs,
        defStyleAttr) {

    init {
        View.inflate(getContext(), R.layout.view_switcher, this)
    }

    val label by lazy { this.findViewById<TextView>(R.id.view_switcher_tvLabel) }

    var isChecked: Boolean = false
        get() = view_switcher_sButton.isChecked

    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener?) {
        view_switcher_sButton.setOnCheckedChangeListener(listener)
    }
}