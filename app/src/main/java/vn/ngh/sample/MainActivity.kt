package vn.ngh.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import vn.ngh.sample.customs.ErrorStatus
import vn.ngh.sample.customs.LoadingStatus
import vn.ngh.sample.customs.RetryStatus
import vn.ngh.statuslayout.BaseStatusLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        raGroup.setOnCheckedChangeListener({ group: RadioGroup?, checkedId: Int ->

            var baseStatusLayout: BaseStatusLayout? = null
            if (raLoading.isChecked) {
                baseStatusLayout = LoadingStatus(this@MainActivity)
            } else if (raTryAgain.isChecked) {
                baseStatusLayout = RetryStatus(this@MainActivity)
            } else if (raError.isChecked) {
                baseStatusLayout = ErrorStatus(this@MainActivity)
            } else if (raHidden.isChecked) {
                statusLayout.hiddenStatus()
            }
            if (baseStatusLayout != null) {
                statusLayout.baseStatusLayout = baseStatusLayout
                statusLayout.showStatus()
            }

        })
    }
}
