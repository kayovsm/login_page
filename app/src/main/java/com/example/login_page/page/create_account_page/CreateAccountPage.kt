package com.example.login_page.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_page.ui.widget.ButtonApp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.login_page.ui.theme.AppTheme
import com.example.login_page.ui.theme.ColorApp
import com.example.login_page.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Email
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CreateAccountPage(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(false) }

    AppTheme(darkTheme = isDarkTheme) {
        val backgroundColor = if (isDarkTheme) ColorApp.background else ColorApp.backgroundLight

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Criar Conta",
                    style = MaterialTheme.typography.headlineMedium.copy(fontSize = 36.sp),
                    color = if (isDarkTheme) ColorApp.white else ColorApp.black
                )
                Text(
                    text = "Informe seus dados para criar uma conta",
                    style = MaterialTheme.typography.headlineMedium.copy(fontSize = 18.sp),
                    color = if (isDarkTheme) ColorApp.white else ColorApp.black
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Nome") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirmar senha") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ButtonApp(
                    label = "Criar conta",
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = ColorApp.buttonOperators,
                    textColor = ColorApp.white,
                    textSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Ja tem uma conta? Entrar")
                }
            }
            IconButton(
                onClick = { isDarkTheme = !isDarkTheme },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                val icon = if (isDarkTheme) R.drawable.dark_mode else R.drawable.light_mode
                val iconColor = if (isDarkTheme) ColorApp.white else ColorApp.black
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(iconColor)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountPagePreview() {
    val navController = rememberNavController()
    AppTheme {
        CreateAccountPage(navController)
    }
}