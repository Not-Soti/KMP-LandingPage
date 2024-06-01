import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import sections.contantInfo
import sections.profileInfo
import sections.workExperience


@Composable
fun WebSkeleton(windowSize: WindowSizeClass) {

    val lazyColumnState = rememberLazyListState()

    Scaffold(
        topBar = { topBar(lazyColumnState) }
    ) { padding ->
        MainContent(padding, windowSize, lazyColumnState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
                    contentDescription = ""
                )
            }
        },
    )
}

@Composable
private fun TopAppbarContent(
    lazyColumnState: LazyListState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        TopbarItem(stringResource(Res.string.profile_section_name), 0, lazyColumnState)
        TopbarItem(stringResource(Res.string.work_experience_section_name), 1, lazyColumnState)
        TopbarItem(stringResource(Res.string.contact_section_name), 2, lazyColumnState)
    }
}

@Composable
fun TopbarItem(
    title: String,
    position: Int,
    lazyColumnState: LazyListState
) {
    val scope = rememberCoroutineScope()
    Text(
        modifier = Modifier.clickable {
            scope.launch { lazyColumnState.animateScrollToItem(position) }
        },
        text = title,
        color = Color(AppColors.OnBackground.argbColor)
    )
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    windowSize: WindowSizeClass,
    lazyColumnState: LazyListState
) {

    //Needed to be loaded all time, otherwise swiping feels bad
    val backendExperience = stringResource(Res.string.work_experience_1_description)
    val mobileExperience = stringResource(Res.string.work_experience_2_description)

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
                profileInfo(
                    modifier = Modifier.fillParentMaxHeight(),
                    isCompact = windowSize.widthSizeClass == WindowWidthSizeClass.Compact
                )
            }

            item {
                Column(
                    modifier = Modifier.background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(AppColors.BackgroundGradient1.argbColor),
                                Color(AppColors.BackgroundGradient2.argbColor)
                            )
                        )
                    ),
                ) {
                    workExperience(
                        windowSizeClass = windowSize,
                        backendExperienceDesc = backendExperience,
                        mobileExperienceDesc = mobileExperience,
                    )

                    contantInfo(
                        windowSizeClass = windowSize,
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(AppColors.PrimaryVariant.argbColor))
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(Res.string.copyright_notice),
                            color = Color(AppColors.OnBackground.argbColor),
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }
        }
    }
}
