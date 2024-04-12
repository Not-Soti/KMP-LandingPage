package sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import kmplandingpage.composeapp.generated.resources.Res
import kmplandingpage.composeapp.generated.resources.profile_image
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import style.AppTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun profileInfo(
    modifier: Modifier = Modifier
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
            fontSize = AppTheme.textSize.title,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Visible,
        )
        Text(
            text = "Android Engineer · Backend Engineer",
            fontSize = AppTheme.textSize.subtitle,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
    }
}