package com.example.jobhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobhub.ui.theme.JobHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobHubTheme {
                Tela()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true,backgroundColor = 55)
@Composable
fun Tela(){
    var User by remember{ mutableStateOf("") }
    var IdTexto = 1
    var Log = User
    var Password by remember{ mutableStateOf("") }
    var Pass = Password
    Image(
        painter = painterResource(id = R.drawable.azul),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 200.dp).fillMaxSize()
    ) {
        IdTexto = R.string.Main
        Text(
            text = stringResource(IdTexto),
            color = Color.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(top = 450.dp).fillMaxSize()
    ) {
        TextField(
            value = User,
            onValueChange = { User = it },
            label = {
                Text(
                    text = "Email or User"
                )
            },
            isError = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        TextField(
            value = Password,
            onValueChange = { Password = it },
            label = {
                Text(
                    text = "Password"
                )
            },
            isError = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
            Contas(id = R.drawable.facebook)
            Contas(id = R.drawable.google)
            Contas(id = R.drawable.linkedin)
        }
    }
}
@Composable
fun Contas(id:Int){
    val OnClickImage = {}

    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .clickable (onClick = OnClickImage)
            .size(35.dp)
            .clip(CircleShape)
            .border(1.5.dp, Color(2,16,237), CircleShape)

    )
}
