import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import style.AppTheme

/**
 * TODO:
 *  - Extract colors, strings and other values to resources
 *  - Get different padding values for multiple screen sizes?
 *  - Multiple languaje and autodetection
 *  - Añadir sección de "Se ofrecen servicios de back + mobile patatin patatan"
 *  - Compact - Burguer icon and content drawer
 */

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {

    val windowSizeClass = calculateWindowSizeClass()

    AppTheme(windowSizeClass) {
        WebSkeleton(windowSizeClass)
    }


}
