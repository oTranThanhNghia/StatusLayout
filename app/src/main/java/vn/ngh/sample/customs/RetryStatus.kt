package vn.ngh.sample.customs

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.Toast
import vn.ngh.sample.R
import vn.ngh.statuslayout.BaseStatusLayout


/**
 *
 */
class RetryStatus(activity: Activity) : BaseStatusLayout(activity) {
    override fun getLayoutID(): Int {
        return R.layout.layout_retry
    }

    override fun onCreate(rootView: View) {
        val retryButton = rootView.findViewById<Button>(R.id.retryButton)
        retryButton.setOnClickListener({
            Toast.makeText(activity, R.string.retry, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroy() {

    }
}