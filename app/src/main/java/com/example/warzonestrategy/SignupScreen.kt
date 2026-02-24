package com.example.warzonestrategy


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignupScreen(nav: NavController) {
    val auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Signup",fontSize = 25.sp)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(email, { email = it }, label = { Text("Email") })
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(password, { password = it }, label = { Text("Password") })
        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    nav.navigate(Screen.Battle.route)
                }
        }) {
            Spacer(Modifier.height(16.dp))
            Text("Create Account",fontSize = 20.sp)


        }
        TextButton(onClick = {
            nav.navigate(Screen.Login.route)

        })
        {
            Spacer(Modifier.height(10.dp))
            Text("Already have an Account",fontSize = 20.sp)
        }
    }
}
