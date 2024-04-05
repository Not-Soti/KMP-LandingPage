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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmplandingpage.composeapp.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            containerColor = Color(0xff31363F),
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
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF222831)),
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
            modifier = Modifier.fillMaxWidth(1f),
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
                Column(
                    modifier = Modifier.fillParentMaxHeight().fillMaxWidth(),
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
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillParentMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Trabajo actual")
                    Box(
                        modifier = Modifier.fillMaxSize(0.5f),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            modifier = Modifier.size(128.dp),
                            painter = painterResource(Res.drawable.android_icon),
                            contentDescription = ""
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(Color.Black))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillParentMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Trabajo anterior")
                    Box(
                        modifier = Modifier.fillMaxSize(0.5f),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            modifier = Modifier.size(128.dp),
                            painter = painterResource(Res.drawable.icon_printer),
                            contentDescription = ""
                        )
                    }
                }
            }

        }
    }
}