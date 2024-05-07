package sections

import AppColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun workExperience(modifier: Modifier = Modifier, windowSize: WindowSizeClass) {

    Column(Modifier.background(Color(AppColors.Background.argbColor))) {
        if (windowSize.widthSizeClass == WindowWidthSizeClass.Compact) {
            CompactContent(modifier)
        } else {
            ExpandedContent(modifier)
        }
    }

}

@Composable
private fun CompactContent(modifier: Modifier) {

    val experienceIconSize = 48.dp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        WorkExperienceEntry(iconSize = experienceIconSize) { MobileWorkExperience(iconSize = experienceIconSize) }
        WorkExperienceEntry(iconSize = experienceIconSize) { BackendWorkExperience(iconSize = experienceIconSize) }
    }
}

@Composable
private fun ExpandedContent(modifier: Modifier) {

    val experienceIconSize = 96.dp

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth(.3f)
                .padding(4.dp)
        ) {
            WorkExperienceEntry(iconSize = experienceIconSize) { MobileWorkExperience(iconSize = experienceIconSize) }
            WorkExperienceEntry(iconSize = experienceIconSize) { BackendWorkExperience(iconSize = experienceIconSize) }
        }
    }
}

@Composable
private fun WorkExperienceEntry(
    iconSize: Dp,
    content: @Composable () -> Unit
) {
    Row(modifier = Modifier.height(IntrinsicSize.Max)) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.height(iconSize.div(2)).width(4.dp).background(Color(0xFFFF204E)))
            Box(modifier = Modifier.size(iconSize.div(2)).clip(CircleShape).background(Color(0xFFFF204E)))
            Box(modifier = Modifier.fillMaxHeight().width(4.dp).background(Color(0xFFFF204E)))
        }

        content()
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BackendWorkExperience(
    modifier: Modifier = Modifier,
    iconSize: Dp
) {
    workExperienceItem(
        parentModifier = modifier,
        title = stringResource(Res.string.work_experience_1_title),
        description = stringResource(Res.string.work_experience_1_description),
        image = painterResource(Res.drawable.icon_printer),
        iconSize = iconSize
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MobileWorkExperience(
    modifier: Modifier = Modifier,
    iconSize : Dp
) {
    workExperienceItem(
        parentModifier = modifier,
        title = stringResource(Res.string.work_experience_2_title),
        description = stringResource(Res.string.work_experience_2_description),
        image = painterResource(Res.drawable.android_icon),
        iconSize = iconSize
    )
}

@Composable
private fun workExperienceItem(
    parentModifier: Modifier,
    title: String,
    description: String,
    image: Painter,
    iconSize: Dp
) {
    Column(
        modifier = parentModifier.fillMaxHeight().padding(vertical = 12.dp, horizontal = 12.dp),
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Image(
                modifier = Modifier.size(iconSize),
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Fit
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = Color(AppColors.OnPrimary.argbColor)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = description,
            color = Color(AppColors.OnBackground.argbColor),
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}