package com.example.warzonestrategy


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(nav: NavController) {
    val auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", fontSize = 25.sp)
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(email, { email = it }, label = { Text("Email") })
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(password, { password = it }, label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation())
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    nav.navigate(Screen.Battle.route)
                }
        }) {
            Text("Login",fontSize = 20.sp)
        }
        Spacer(Modifier.height(16.dp))

        TextButton(onClick = {
            nav.navigate(Screen.Signup.route)

        })
        {
            Spacer(Modifier.height(10.dp))
            Text("Go to Signup",fontSize = 20.sp)
        }

    }
}
