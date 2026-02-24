package com.example.warzonestrategy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.warzonestrategy.ui.theme.WarZoneStrategyTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            WarZoneStrategyTheme {
                Navigation()
            }

        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Signup.route) {
            SignupScreen(navController)
        }
        composable(Screen.Battle.route) {
            BattleScreen(navController)
        }
        composable(Screen.Result.route) {
            ResultScreen(it.arguments?.getString("win") == "true")
        }
    }
}
