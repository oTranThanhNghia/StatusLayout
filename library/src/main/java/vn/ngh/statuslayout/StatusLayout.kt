package vn.ngh.statuslayout

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout

/**
 *
 */
class StatusLayout : RelativeLayout {

    private val TAG: String = "StatusLayout"

    private lateinit var groupStatus: RelativeLayout
    var baseStatusLayout: BaseStatusLayout? = null
        set(value) {
            value?.let {
                if (baseStatusLayout == value) {
                    Log.d(TAG, "same object")
                    return
                }
                activity = value.getStatusActivity()
                field = value
                initStatus()
            }
        }

    private var activity: Activity? = null
    private var layoutInflate: LayoutInflater

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        layoutInflate = LayoutInflater.from(context)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        initViews()
    }

    private fun initViews() {
        groupStatus = RelativeLayout(context)
        groupStatus.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        groupStatus.setBackgroundColor(Color.TRANSPARENT)
        this.addView(groupStatus)
        //default hidden
        hiddenStatus()
        initStatus()
    }

    private fun initStatus() {
        Log.i(TAG, "initStatus")
        activity?.let {
            it.runOnUiThread({
                removeAllView()
                var view: View? = null

                baseStatusLayout?.let {
                    try {
                        view = layoutInflate.inflate(it.getLayoutID(), groupStatus, false)
                    } catch (ex: InflateException) {
                        Log.e(TAG, ex.message)
                    }
                }

                view?.let {
                    it.layoutParams = ViewGroup.LayoutParams(groupStatus.layoutParams.width, groupStatus.layoutParams.height)
                    groupStatus.addView(it)
                    baseStatusLayout?.onCreate(it)
                }
            })
        }
    }

    fun hiddenStatus() {
        groupStatus.visibility = View.GONE
    }

    fun removeAllView() {
        if (groupStatus.childCount > 0) {
            baseStatusLayout?.let {
                it.onDestroy()
            }
            groupStatus.removeAllViews()
        }
        hiddenStatus()
    }

    fun showStatus() {
        groupStatus.visibility = View.VISIBLE
    }

}