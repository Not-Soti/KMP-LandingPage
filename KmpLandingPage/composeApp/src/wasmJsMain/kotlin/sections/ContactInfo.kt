package sections

import AppColors
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import kmplandingpage.composeapp.generated.resources.*
import kotlinx.browser.window
import org.jetbrains.compose.resources.stringResource
import org.w3c.dom.url.URL
import style.AppTheme

@Composable
fun contantInfo(windowSizeClass: WindowSizeClass) {

    val nameText = remember { mutableStateOf("") }
    val emailText = remember { mutableStateOf("") }
    val subjectText = remember { mutableStateOf("") }
    val bodyText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
            Column {
                CompactContent(
                    name = nameText,
                    email = emailText,
                    subject = subjectText,
                    message = bodyText
                )
                Spacer(Modifier.height(8.dp))
                SendEmailButton(
                    isCompact = true,
                    name = nameText.value,
                    email = emailText.value,
                    subject = subjectText.value,
                    message = bodyText.value
                )
                Spacer(
                    Modifier.height(12.dp)
                )
            }
        } else {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ExpandedContent(
                    name = nameText,
                    email = emailText,
                    subject = subjectText,
                    message = bodyText
                )
                Spacer(Modifier.height(8.dp))
                SendEmailButton(
                    isCompact = false,
                    name = nameText.value,
                    email = emailText.value,
                    subject = subjectText.value,
                    message = bodyText.value
                )
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun ExpandedContent(
    name: MutableState<String>,
    email: MutableState<String>,
    subject: MutableState<String>,
    message: MutableState<String>
) {
    Column(
        modifier = Modifier.fillMaxWidth(0.5f),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = stringResource(Res.string.contact_section_title),
            fontSize = AppTheme.textSize.subtitle,
            color = Color(AppColors.OnPrimary.argbColor)
        )

        Spacer(Modifier.height(24.dp))

        Row {
            TextField(
                modifier = Modifier.weight(1f),
                value = name.value,
                label = { Text(stringResource(Res.string.contact_input_name)) },
                maxLines = 1,
                onValueChange = {
                    name.value = it
                }
            )
            Spacer(Modifier.width(8.dp))
            TextField(
                modifier = Modifier.weight(1f),
                value = email.value,
                label = { Text(stringResource(Res.string.contact_input_email)) },
                maxLines = 1,
                onValueChange = { email.value = it }
            )
        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = subject.value,
            label = { Text(stringResource(Res.string.contact_input_subject)) },
            maxLines = 1,
            onValueChange = { subject.value = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().height(480.dp),
            value = message.value,
            label = { Text(stringResource(Res.string.contact_input_body)) },
            onValueChange = { message.value = it }
        )
    }

}

@Composable
private fun CompactContent(
    name: MutableState<String>,
    email: MutableState<String>,
    subject: MutableState<String>,
    message: MutableState<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(Res.string.contact_section_title),
            fontSize = AppTheme.textSize.title,
            color = Color(AppColors.OnPrimary.argbColor)
        )

        Spacer(Modifier.height(24.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name.value,
            label = { Text(stringResource(Res.string.contact_input_name)) },
            maxLines = 1,
            onValueChange = {
                name.value = it
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go
            )
        )
        TextField(

            modifier = Modifier.fillMaxWidth(),
            value = email.value,
            label = { Text(stringResource(Res.string.contact_input_email)) },
            maxLines = 1,
            onValueChange = { email.value = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = subject.value,
            label = { Text(stringResource(Res.string.contact_input_subject)) },
            maxLines = 1,
            onValueChange = { subject.value = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().height(360.dp),
            value = message.value,
            label = { Text(stringResource(Res.string.contact_input_body)) },
            onValueChange = { message.value = it }
        )
    }
}

@Composable
private fun SendEmailButton(
    isCompact: Boolean,
    name: String,
    email: String,
    subject: String,
    message: String
) {
    val buttonSizeRatio = if (isCompact) {
        1f
    } else {
        0.5f
    }

    val mailtoUrl =
        "mailto:example@gmail.com?" +
                "subject=$name: $subject" +
                "&body=$message"

    val horizontalPadding = if (isCompact) 8.dp else 0.dp

    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(buttonSizeRatio),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(AppColors.OnPrimary.argbColor),
                contentColor = Color(AppColors.OnBackground.argbColor)
            ),
            onClick = {
                window.open(
                    URL(mailtoUrl).href,
                    "_blank"
                )
            }
        ) {
            Text(stringResource(Res.string.contact_button_title).uppercase())
        }
    }
}