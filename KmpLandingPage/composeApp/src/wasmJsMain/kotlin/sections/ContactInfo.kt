package sections

import AppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import style.AppTheme

@Composable
fun contantInfo(windowSizeClass: WindowSizeClass) {

    Box(
        modifier = Modifier.background(Color(AppColors.Background.argbColor)).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
            CompactContent()
        } else {
            ExpandedContent()
        }
    }
}

@Composable
private fun ExpandedContent() {

    var nameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var subjectText by remember { mutableStateOf("") }
    var bodyText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(0.5f),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "¿Hablamos?",
            fontSize = AppTheme.textSize.subtitle,
            color = Color(AppColors.OnPrimary.argbColor)
        )

        Spacer(Modifier.height(24.dp))

        Row {
            TextField(
                modifier = Modifier.weight(1f),
                value = nameText,
                label = { Text("Nombre") },
                maxLines = 1,
                onValueChange = {
                    nameText = it
                }
            )
            Spacer(Modifier.width(8.dp))
            TextField(
                modifier = Modifier.weight(1f),
                value = emailText,
                label = { Text("Correo") },
                maxLines = 1,
                onValueChange = { emailText = it }
            )
        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = subjectText,
            label = { Text("Asunto") },
            maxLines = 1,
            onValueChange = { subjectText = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().height(480.dp),
            value = bodyText,
            label = { Text("Mensaje") },
            onValueChange = { bodyText = it }
        )

        Spacer(Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text("Enviar")
        }
    }

}

@Composable
private fun CompactContent() {

    var nameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var subjectText by remember { mutableStateOf("") }
    var bodyText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Let's talk!",
            fontSize = AppTheme.textSize.title,
            color = Color(AppColors.OnPrimary.argbColor)
        )

        Spacer(Modifier.height(24.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = nameText,
            label = { Text("Name") },
            maxLines = 1,
            onValueChange = {
                nameText = it
            }
        )
        TextField(

            modifier = Modifier.fillMaxWidth(),
            value = emailText,
            label = { Text("Email") },
            maxLines = 1,
            onValueChange = { emailText = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = subjectText,
            label = { Text("Subject") },
            maxLines = 1,
            onValueChange = { subjectText = it }
        )

        TextField(
            modifier = Modifier.fillMaxWidth().height(480.dp),
            value = bodyText,
            label = { Text("Message") },
            onValueChange = { bodyText = it }
        )

        Spacer(Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Text("Enviar")
        }
    }

}