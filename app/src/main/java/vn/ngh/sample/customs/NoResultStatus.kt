package vn.ngh.sample.customs

import android.app.Activity
import android.view.View
import vn.ngh.sample.R
import vn.ngh.statuslayout.BaseStatusLayout


/**
 *
 */
class NoResultStatus(activity: Activity) : BaseStatusLayout(activity) {
    override fun getLayoutID(): Int {
        return R.layout.layout_no_result
    }

    override fun onCreate(rootView: View) {

    }

    override fun onDestroy() {

    }

}