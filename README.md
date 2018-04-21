# StatusLayout

## Demo

<img src="https://github.com/oTranThanhNghia/StatusLayout/blob/master/captures/statuslayout-demo.gif"/>

## Download

<a href='https://github.com/oTranThanhNghia/StatusLayout/blob/master/demo/app-demo.apk'>File APK</a>

## Usage
```xml
<vn.ngh.statuslayout.StatusLayout
        android:id="@+id/statusLayout"
        android:background="@android:color/white"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <!-- Your content here -->
</vn.ngh.statuslayout.StatusLayout>
```

```kotlin
class LoadingStatus(activity: Activity) : BaseStatusLayout(activity) {
    override fun getLayoutID(): Int {
        return R.layout.layout_loading
    }

    override fun onCreate(rootView: View) {

    }

    override fun onDestroy() {

    }
}
```

```kotlin
statusLayout.baseStatusLayout = LoadingStatus(this@MainActivity)
statusLayout.showStatus()
```
## Java version
<a href='https://github.com/oTranThanhNghia/TestRetrofit/tree/master/SampleLayoutStatus'>https://github.com/oTranThanhNghia/TestRetrofit/tree/master/SampleLayoutStatus</a>

# Thanks for watching
