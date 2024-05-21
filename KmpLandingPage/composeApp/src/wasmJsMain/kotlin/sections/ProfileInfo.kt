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
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import style.AppTheme

@Composable
fun profileInfo(
    modifier: Modifier = Modifier,
    isCompact: Boolean
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val androidSubtitle = stringResource(Res.string.profile_android_engineer)
        val backendSubtitle = stringResource(Res.string.profile_backend_engineer)

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
            text = stringResource(Res.string.profile_my_name).uppercase(),
            fontSize = AppTheme.textSize.title,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Visible,
        )

        if (isCompact) {
            Spacer(Modifier.height(24.dp))
            Text(
                text = androidSubtitle,
                fontSize = AppTheme.textSize.subtitle,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
            Text(
                text = backendSubtitle,
                fontSize = AppTheme.textSize.subtitle,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )

        } else {
            Text(
                text =  "$androidSubtitle · $backendSubtitle",
                fontSize = AppTheme.textSize.subtitle,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
        }


    }
}