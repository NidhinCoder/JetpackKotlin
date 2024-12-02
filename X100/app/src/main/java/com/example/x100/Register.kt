package com.example.x100

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController,viewModel: RegisterViewModel) {


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var phoneNumber by remember { mutableStateOf("")}
    var successMessage by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        if (successMessage.isNotEmpty()) {
            Text(text = successMessage)
        }
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text(text = "Phone number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )



        Button(onClick = {
            if(validateFields(username,password,email,phoneNumber))
            {
                val user = User(
                    id = 1,
                    username = username,
                    password = password,
                    email = email,
                    phoneNumber = phoneNumber
                )
                viewModel.insertUser(user)
                successMessage = "Registered successfully!"
                navController.navigate("home")

            }
            else
            {
                successMessage = "Invalid data"
            }
            // Validate input fields here
            // If validation passes, navigate to the next screen

        }) {
            Text(text = "Register")
        }
    }



    // Register screen content
    Button(onClick = { navController.navigate("home")  }) {
        Text(text = "Go Back")
    }


}

private fun validateFields(username: String, password: String, email: String, phoneNumber: String): Boolean {
    return username.isNotEmpty() &&
            password.isNotEmpty() &&
            isValidEmail(email)
    // Add more validation rules as needed
}

private fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return emailRegex.matches(email)

}

