package style

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Padding(
    val small: Dp,
    val medium: Dp,
    val big: Dp
)

val CompactPadding = Padding(
    small = 4.dp,
    medium = 8.dp,
    big = 16.dp
)

val ExpandedPadding = Padding(
    small = 12.dp,
    medium = 24.dp,
    big = 48.dp
)

val LocalPadding = compositionLocalOf(defaultFactory = { ExpandedPadding })