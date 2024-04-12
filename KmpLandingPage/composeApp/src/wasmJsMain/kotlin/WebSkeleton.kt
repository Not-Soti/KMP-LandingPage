import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.LinkedInOriginalLogo
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.server_room
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import sections.contantInfo
import sections.profileInfo
import sections.workExperience


@Composable
fun WebSkeleton(windowSize: WindowSizeClass){
    Scaffold(
        containerColor = Color(AppColors.background.argbColor),
        topBar = { topBar() }
    ) { padding ->
        MainContent(padding, windowSize)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
private fun topBar() {

    val uriHandler = LocalUriHandler.current

    TopAppBar(
        modifier = Modifier.shadow(4.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(AppColors.topbar.argbColor)),
        title = { },
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
private fun MainContent(paddingValues: PaddingValues, windowSize: WindowSizeClass) {

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
                workExperience(Modifier.fillParentMaxHeight(), windowSize)
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
