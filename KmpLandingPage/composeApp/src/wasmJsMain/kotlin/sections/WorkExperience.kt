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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.android_icon
import kmplandingpage.composeapp.generated.resources.icon_printer
import kmplandingpage.composeapp.generated.resources.trayectory
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun workExperience(modifier: Modifier = Modifier, windowSize: WindowSizeClass) {

    Column {
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
            .background(Color(AppColors.white.argbColor))
            .padding(4.dp)
    ) {
        MobileWorkExperience(Modifier.weight(1f))
        BackendWorkExperience(Modifier.weight(1f))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ExpandedContent(modifier: Modifier) {
    Row(
        modifier = modifier
            .background(Color(AppColors.white.argbColor))
            .padding(horizontal = 20.dp, vertical = 4.dp)
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

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun BackendWorkExperience(modifier: Modifier) {
    workExperienceItem(
        parentModifier = modifier,
        title = "2021 - 2023",
        description = "-Firmware development in C++ for Large Format Printers.\n" +
                "-Database development using SQLite\n" +
                "-Unit testing in C++ using Gtest\n" +
                "-System testing using Python\n" +
                "\n" +
                "As a member of a distributed scrum team, I develop strong and scalable software backed by a wide test coverage, using control versions sistems such as GIT and SVN, and multiple technologies regarding continuous integration.",
        image = painterResource(Res.drawable.icon_printer),
        verticalArrangement = Arrangement.Bottom
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MobileWorkExperience(modifier: Modifier) {
    workExperienceItem(
        parentModifier = modifier,
        title = "2023 - Today",
        description = "As a Mobile Engineer, I specialize in developing native applications for mobile devices using various technologies. I contribute value across the entire development lifecycle, from inception and expansion to testing and deployment of projects. Additionally, I assist clients in focusing their product in the best possible way.\n" +
                "\n" +
                "- Multiplatform applications with Kotlin Multiplatform and Compose/SwiftUI\n" +
                "- Android applications with Java, Views (XML), Kotlin, and Jetpack Compose\n" +
                "iOS applications with SwiftUI\n" +
                "- Clean architecture, MVVM, MVI\n" +
                "- Development and continuous integration on Azure DevOps\n" +
                "- Analytics tracking using Firebase",
        image = painterResource(Res.drawable.android_icon),
        verticalArrangement = Arrangement.Center
    )
}

@Composable
private fun workExperienceItem(
    parentModifier: Modifier,
    title: String,
    description: String,
    image: Painter,
    verticalArrangement: Arrangement.Vertical
) {
    Column(
        modifier = parentModifier.fillMaxHeight(),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier.fillMaxSize(0.5f).background(Color.Red),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                modifier = Modifier.fillMaxWidth(0.5f),
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }

        Text(
            text = description,
            overflow = TextOverflow.Ellipsis
        )
    }
}