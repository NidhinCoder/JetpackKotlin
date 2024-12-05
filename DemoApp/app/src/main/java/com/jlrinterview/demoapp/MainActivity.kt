package com.jlrinterview.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jlrinterview.demoapp.ViewModel.RegisterViewModel
import com.jlrinterview.demoapp.data.User
import com.jlrinterview.demoapp.ui.theme.DemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            MyApp(userViewModel)
        }
    }
}

@Composable
fun MyApp(userViewModel:RegisterViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register")
        { RegisterScreen(navController = navController,userViewModel) }
        composable("success") { SuccessScreen() }
    }
}

@Composable
fun LoginScreen(navController: NavController) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange
            = {newUserName->userName = newUserName},
            label = { Text(text = "Username") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange
            = {newPassword->password = newPassword},
            label = { Text(text = "Password") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Handle login */ }) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("register") }) {
            Text(text = "Register")
        }
    }
}

@Composable
fun RegisterScreen(navController: NavController,userViewModel:RegisterViewModel) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = userName,
            onValueChange
            = { userTyped -> userName = userTyped },
            label = { Text(text = "Username") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange
            = { userTyped -> password = userTyped },
            label = { Text(text = "password") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange
            = { userTyped -> email = userTyped },
            label = { Text(text = "email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = phoneNumber,
            onValueChange
            = { userTyped -> phoneNumber = userTyped },
            label = { Text(text = "phoneNumber") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {

            userViewModel.addUser(userName,password,email,phoneNumber)
            navController.navigate("login") // Navigate back to login screen
        }) {
            Text(text = "Register")
        }
    }

}

@Composable
fun SuccessScreen() {
    Text(text = "Success Screen", modifier = Modifier.fillMaxSize())
}


