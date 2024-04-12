import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import style.AppTheme

/**
 * TODO:
 *  - Extract colors, strings and other values to resources
 *  - Split each page section to its own file
 *  - Get different padding values for multiple screen sizes?
 *  - Different text sizes also
 */

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {

    val windowSizeClass = calculateWindowSizeClass()

    AppTheme(windowSizeClass) {
        WebSkeleton(windowSizeClass)
    }


}
