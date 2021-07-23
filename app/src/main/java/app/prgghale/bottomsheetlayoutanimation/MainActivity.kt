package app.prgghale.bottomsheetlayoutanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.util.toRange
import androidx.lifecycle.lifecycleScope
import app.prgghale.bottomsheetlayoutanimation.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var bottomView: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bottomView = BottomSheetBehavior.from(binding.bottomSheetView.root)
        bottomView.peekHeight = 300
        bottomView.collapse()
        binding.bottomSheetView.slider.setOnClickListener { }


        bottomView.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    binding.bottomSheetView.parent.setTransitionDuration(700)
                    binding.bottomSheetView.parent.transitionToEnd()
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    binding.bottomSheetView.parent.setTransitionDuration(800)
                    binding.bottomSheetView.parent.transitionToStart()
                }
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    if (binding.bottomSheetView.parent.transitionTimeMs == 800L) {
                        binding.bottomSheetView.parent.transitionToEnd()
                    } else {
                        binding.bottomSheetView.parent.transitionToStart()
                    }
                }

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })
    }
}