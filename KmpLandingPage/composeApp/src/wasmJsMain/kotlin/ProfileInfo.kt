import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.profile_image
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun profileInfo(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass
) {
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