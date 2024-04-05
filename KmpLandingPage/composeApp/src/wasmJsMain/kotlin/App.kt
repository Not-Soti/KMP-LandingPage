import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmplandingpage.composeapp.generated.resources.LinkedInOriginalLogo
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.server_room
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

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box {

                Image(
                    modifier = Modifier.fillParentMaxHeight(1f),
                    painter = painterResource(Res.drawable.server_room),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "SERGIO TORRES",
                    fontSize = 128.sp,
                    color = Color.White
                )
            }
        }

        item {
            Box(modifier = Modifier.background(Color.Red).fillMaxWidth()){
                Column {
                    Text("TRABAJO ACTUAL -> Moviles")
                }
            }
        }

        item {
            Box(modifier = Modifier.background(Color.White).fillMaxWidth()){
                Column {
                    Text("TRABAJO 1 -> Impresoras")
                }
            }
        }

    }
}