import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.LinkedInOriginalLogo
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.linkedin_url
import kmplandingpage.composeapp.generated.resources.server_room
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import sections.contantInfo
import sections.profileInfo
import sections.workExperience


@Composable
fun WebSkeleton(windowSize: WindowSizeClass) {

    val lazyColumnState = rememberLazyListState()

    Scaffold(
        containerColor = Color(AppColors.Background.argbColor),
        topBar = { topBar(lazyColumnState) }
    ) { padding ->
        MainContent(padding, windowSize, lazyColumnState)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalResourceApi::class)
@Composable
private fun topBar(
    lazyColumnState: LazyListState
) {

    val uriHandler = LocalUriHandler.current
    val urlLinkedin = stringResource(Res.string.linkedin_url)

    TopAppBar(
        modifier = Modifier
            .shadow(4.dp),
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(AppColors.PrimaryVariant.argbColor)),
        title = { TopAppbarContent(lazyColumnState) },
        actions = {
            Button(
                onClick = {
                    uriHandler.openUri(urlLinkedin)
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

@Composable
private fun TopAppbarContent(
    lazyColumnState: LazyListState
) {
    //TODO - Compact - Burguer icon and content drawer
    Row (
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ){
        TopbarItem("Profile", 0, lazyColumnState)
        TopbarItem("Experience", 1, lazyColumnState)
        TopbarItem("Contact", 2, lazyColumnState)
    }
}

@Composable
fun TopbarItem(
    title: String,
    position: Int,
    lazyColumnState: LazyListState
){
    val scope = rememberCoroutineScope()
    Text(
        modifier = Modifier.clickable {
            scope.launch { lazyColumnState.animateScrollToItem(position) }
        },
        text = title,
        color = Color(AppColors.OnBackground.argbColor)
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    windowSize: WindowSizeClass,
    lazyColumnState: LazyListState
) {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            state = lazyColumnState
        ) {
            item {
                profileInfo(Modifier.fillParentMaxHeight())
            }

            item {
                workExperience(windowSize = windowSize)
            }

            item {
                contantInfo(Modifier.fillParentMaxHeight())
            }
        }
    }
}
