package style

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    windowSizeClass: WindowSizeClass,
    content: @Composable () -> Unit
) {

    val textSize = if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        CompactTextSize
    } else {
        ExpandedTextSize
    }

    val padding = if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        CompactPadding
    } else {
        ExpandedPadding
    }

    CompositionLocalProvider(
        LocalTextSize provides textSize,
        LocalPadding provides padding
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object AppTheme {
    val textSize: TextSize
        @Composable get() = LocalTextSize.current

    val padding: Padding
        @Composable get() = LocalPadding.current
}