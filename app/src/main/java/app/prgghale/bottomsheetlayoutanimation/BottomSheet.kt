package app.prgghale.bottomsheetlayoutanimation

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

fun BottomSheetBehavior<View>.expanded() {
  state = BottomSheetBehavior.STATE_EXPANDED
}

fun BottomSheetBehavior<View>.collapse() {
  state = BottomSheetBehavior.STATE_COLLAPSED
}