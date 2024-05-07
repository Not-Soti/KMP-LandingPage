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
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.android_icon
import kmplandingpage.composeapp.generated.resources.icon_printer
import kmplandingpage.composeapp.generated.resources.trayectory
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
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        WorkExperienceEntry { MobileWorkExperience() }
        WorkExperienceEntry { BackendWorkExperience() }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ExpandedContent(modifier: Modifier) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp, vertical = 4.dp)
    ) {

        BackendWorkExperience(Modifier.weight(1f))

        Box(
            modifier = Modifier.weight(1f).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.trayectory),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }

        MobileWorkExperience(Modifier.weight(1f))

    }
}

@Composable
private fun WorkExperienceEntry(
    content: @Composable () -> Unit
) {
    Row(modifier = Modifier.height(IntrinsicSize.Max)) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.height(24.dp).width(4.dp).background(Color(0xFFFF204E)))
            Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(Color(0xFFFF204E)))
            Box(modifier = Modifier.fillMaxHeight().width(4.dp).background(Color(0xFFFF204E)) )
        }

        content()
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BackendWorkExperience(modifier: Modifier = Modifier) {
    workExperienceItem(
        parentModifier = modifier,
        title = stringResource(Res.string.work_experience_1_title),
        description = stringResource(Res.string.work_experience_1_description),
        image = painterResource(Res.drawable.icon_printer),
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MobileWorkExperience(modifier: Modifier = Modifier) {
    workExperienceItem(
        parentModifier = modifier,
        title = stringResource(Res.string.work_experience_2_title),
        description = stringResource(Res.string.work_experience_2_description),
        image = painterResource(Res.drawable.android_icon),
    )
}

@Composable
private fun workExperienceItem(
    parentModifier: Modifier,
    title: String,
    description: String,
    image: Painter,
) {
    Column(
        modifier = parentModifier.fillMaxHeight().padding(vertical = 12.dp, horizontal = 12.dp),
    ) {

        Box (contentAlignment = Alignment.CenterStart) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Fit
            )

            Row (
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