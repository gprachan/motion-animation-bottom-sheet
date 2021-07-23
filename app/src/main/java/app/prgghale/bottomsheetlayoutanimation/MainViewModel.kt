package app.prgghale.bottomsheetlayoutanimation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _scrollValue = MutableLiveData<Float>()
    val scrollValue: LiveData<Float> = _scrollValue
    fun setScrollValue(value: Float) {
        val data = String.format("%.1f", value)
        if (data != _scrollValue.value.toString()) {
            _scrollValue.value = data.toFloat()
        }
    }

    var recentValue = 0f
}