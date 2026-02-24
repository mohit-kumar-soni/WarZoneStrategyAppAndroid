package com.example.warzonestrategy


sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Battle : Screen("battle")
    object Result : Screen("result/{win}") {
        fun passResult(win: Boolean) = "result/$win"
    }
}
