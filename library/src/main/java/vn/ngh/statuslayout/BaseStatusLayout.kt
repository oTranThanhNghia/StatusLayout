package vn.ngh.statuslayout

import android.app.Activity
import android.view.View

/**
 *
 */
abstract class BaseStatusLayout(protected var activity: Activity) {

    fun getStatusActivity(): Activity {
        return activity
    }

    abstract fun getLayoutID(): Int
    abstract fun onCreate(rootView: View)
    abstract fun onDestroy()
}