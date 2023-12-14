package com.example.appdehoy

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.appdehoy.ui.theme.AppDeHoyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeHoyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Pantallas()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantallas(modifier: Modifier = Modifier) {
    var userString by remember { mutableStateOf(value = "") }
    var passwordString by remember { mutableStateOf(value = "") }

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login", fontSize = 32.sp)
            Text(text = "Welcome Back!", fontSize = 32.sp)
        }
        Divider()
        Column() {
            OutlinedTextField(value = userString, onValueChange = {userString = it}, label = {Text(text = "Username")}, placeholder = { Text(text = "Enter Your Username / Email")})
            OutlinedTextField(value = passwordString //Usa variable de estado
                ,onValueChange = {passwordString = it} //Actualiza la variable de estado con el input
                ,label = {Text(text = "Password")} //Label
                ,placeholder = { Text(text = "Enter Your Password")}, //Placeholder
                shape = RoundedCornerShape(percent = 20), //Esquinas redondeadas
                visualTransformation = PasswordVisualTransformation(), //Transforma los caracteres a bolitas
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ) // Quita la barrita de abajo
        }
    }
}