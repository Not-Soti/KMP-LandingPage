package style

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.Rubik_VariableFont_wght
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getAppTypography() : Typography{
    val customFontFamily = FontFamily(
        Font(
            resource = Res.font.Rubik_VariableFont_wght,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
    val defaultTypography = Typography()

    return Typography(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = customFontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = customFontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = customFontFamily),

        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = customFontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = customFontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = customFontFamily),

        titleLarge = defaultTypography.titleLarge.copy(fontFamily = customFontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = customFontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = customFontFamily),

        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = customFontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = customFontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = customFontFamily),

        labelLarge = defaultTypography.labelLarge.copy(fontFamily = customFontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = customFontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = customFontFamily)
    )
}
