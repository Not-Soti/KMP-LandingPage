package style

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class TextSize(
    val title: TextUnit,
    val subtitle: TextUnit
)

val CompactTextSize = TextSize(
    title = 48.sp,
    subtitle = 36.sp
)

val ExpandedTextSize = TextSize(
    title = 96.sp,
    subtitle = 72.sp
)

val LocalTextSize = compositionLocalOf(defaultFactory = { ExpandedTextSize })