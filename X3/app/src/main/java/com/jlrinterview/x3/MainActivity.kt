package com.jlrinterview.x3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jlrinterview.x3.ui.theme.X3Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<RegistrationViewModel>()
            //RegistrationScreen(viewModel = viewModel)

        }

    }
}

@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel){

    val uiState by viewModel.uiState.collectAsState()

    val usernameRegex = Regex("^[a-zA-Z0-9_]+$")
    val passwordRegex = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    val phoneRegex = Regex("^\\d{10}$") // Adjust for your specific phone number format


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    var isUsernameValid by remember { mutableStateOf(false) }
    var isPasswordValid by remember { mutableStateOf(false) }
    var isPhoneNumberValid by remember { mutableStateOf(false) }
    var isRegistrationSuccessful by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = username,
            onValueChange = { newUsername ->
                username = newUsername
                isUsernameValid = usernameRegex.matches(newUsername)
            },
            label = { Text("Username") },
            isError = !isUsernameValid,
            singleLine = true
        )
        OutlinedTextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
                isPasswordValid = passwordRegex.matches(newPassword)
            },
            label = { Text("Password") },
            isError = !isPasswordValid,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { newPhoneNumber ->
                phoneNumber = newPhoneNumber
                isPhoneNumberValid = phoneRegex.matches(newPhoneNumber)
            },
            label = { Text("Phone number") },
            isError = !isPhoneNumberValid,
            singleLine = true,

        )
        Button(
            onClick = {
                // Check if all fields are valid
                if (isUsernameValid && isPasswordValid && isPhoneNumberValid) {
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(1000) // Replace with actual registration logic
                        isRegistrationSuccessful = true
                        delay(3000) // Delay for 3 seconds before clearing
                        username = ""
                        password = ""
                        phoneNumber = ""
                        isRegistrationSuccessful = false

                        viewModel.registerUser(username, password, phoneNumber)

                    }

                } else {
                    // Show error messages or other feedback
                }
            },
            enabled = isUsernameValid && isPasswordValid && isPhoneNumberValid
        )
        {
            Text("Register")
        }

        when (uiState) {
            is RegistrationViewModel.UiState.Loading -> {
                CircularProgressIndicator()
            }
            is RegistrationViewModel.UiState.Success -> {
                Text((uiState as RegistrationViewModel.UiState.Success).message)
            }
            is RegistrationViewModel.UiState.Error -> {
                Text((uiState as RegistrationViewModel.UiState.Error).message)
            }
            else -> {
                // Handle idle state
            }
        }

    }

}



