import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmplandingpage.composeapp.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * TODO:
 *  - Extract colors, strings and other values to resources
 *  - Split each page section to its own file
 *  - Get different padding values for multiple screen sizes?
 *  - Different text sizes also
 */

private enum class AppColors(val argbColor : Long) {
    background(0xff31363F),
    topbar(0xFF222831),
    white(0xffffffff)
}


@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            containerColor = Color(AppColors.background.argbColor),
            topBar = { topBar() }
        ) { padding ->
            MainContent(padding)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
private fun topBar() {

    val uriHandler = LocalUriHandler.current

    TopAppBar(
        modifier = Modifier.shadow(4.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(AppColors.topbar.argbColor)),
        title = {},
        actions = {
            Button(
                onClick = {
                    uriHandler.openUri("https://www.linkedin.com/in/sergio-torres-montero-a31735207/")
                },
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Image(
                    modifier = Modifier.size(36.dp),
                    painter = painterResource(Res.drawable.LinkedInOriginalLogo),
                    contentDescription = "TODO"
                )
            }
        },
    )

}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainContent(paddingValues: PaddingValues) {

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.server_room),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                profileInfo(Modifier.fillParentMaxHeight())
            }

            item {
                workExperience(Modifier.fillParentMaxHeight())
            }

            item {
                Spacer(Modifier.height(1.dp).fillMaxWidth().background(Color.Black))
            }

            item {
                contantInfo(Modifier.fillParentMaxHeight())
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun profileInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.fillMaxSize(0.5f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.clip(CircleShape),
                painter = painterResource(Res.drawable.profile_image),
                contentDescription = ""
            )
        }
        Text(
            text = "SERGIO TORRES",
            fontSize = 96.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
        Text(
            text = "Android Engineer · Backend Engineer",
            fontSize = 72.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun workExperience(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
        .background(Color(AppColors.white.argbColor))
        .padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        experienceItem(
            parentModifier = Modifier.weight(1f),
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

        experienceItem(
            parentModifier = Modifier.weight(1f),
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
}

@Composable
private fun experienceItem(
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
            modifier = Modifier.fillMaxSize(0.25f),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                painter = image,
                contentDescription = ""
            )
        }

        Text(
            //modifier = Modifier.weight(1f),
            text = description,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun contantInfo(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.background(Color.White).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("¡Contact me!")
    }
}