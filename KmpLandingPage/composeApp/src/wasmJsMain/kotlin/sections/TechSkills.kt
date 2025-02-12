package sections

import AppColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun techSkills(
    windowSizeClass: WindowSizeClass
) {

    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
        compactContent()
    } else {
        expandedContent()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun compactContent() {
    val compactIconSize = 36.dp

    FlowRow (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(AppColors.Background.argbColor))
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        skill(Res.drawable.tech_kotlin, Res.string.tech_exp_kotlin, compactIconSize)
        skill(Res.drawable.tech_cpp, Res.string.tech_exp_cpp, compactIconSize)
        skill(Res.drawable.tech_android, Res.string.tech_exp_android, compactIconSize)
        skill(Res.drawable.tech_java, Res.string.tech_exp_java, compactIconSize)
        skill(Res.drawable.tech_compose, Res.string.tech_exp_compose, compactIconSize)
        skill(Res.drawable.tech_swiftui, Res.string.tech_exp_swiftui, compactIconSize)
        skill(Res.drawable.tech_sqlite, Res.string.tech_exp_sqlite, compactIconSize)
        skill(Res.drawable.tech_git, Res.string.tech_exp_git, compactIconSize)
        skill(Res.drawable.tech_azuredevops, Res.string.tech_exp_azuredevops, compactIconSize)
    }
}

@Composable
private fun expandedContent() {
    val exandedIconSize = 48.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(AppColors.Background.argbColor))
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        skill(Res.drawable.tech_kotlin, Res.string.tech_exp_kotlin, exandedIconSize)
        skill(Res.drawable.tech_cpp, Res.string.tech_exp_cpp, exandedIconSize)
        skill(Res.drawable.tech_android, Res.string.tech_exp_android, exandedIconSize)
        skill(Res.drawable.tech_java, Res.string.tech_exp_java, exandedIconSize)
        skill(Res.drawable.tech_compose, Res.string.tech_exp_compose, exandedIconSize)
        skill(Res.drawable.tech_swiftui, Res.string.tech_exp_swiftui, exandedIconSize)
        skill(Res.drawable.tech_sqlite, Res.string.tech_exp_sqlite, exandedIconSize)
        skill(Res.drawable.tech_git, Res.string.tech_exp_git, exandedIconSize)
        skill(Res.drawable.tech_azuredevops, Res.string.tech_exp_azuredevops, exandedIconSize)
    }
}

@Composable
private fun skill(
    imageRes: DrawableResource,
    titleRes: StringResource,
    iconSize: Dp
) {
    val title = stringResource(titleRes)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(iconSize)) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = title,
                modifier = Modifier.size(iconSize)
            )
        }
        Text(
            text = title,
            color = Color(AppColors.OnBackground.argbColor),
            textAlign = TextAlign.Center
        )
    }
}