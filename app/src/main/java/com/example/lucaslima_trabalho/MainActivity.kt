package com.example.lucaslima_trabalho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lucaslima_trabalho.screens.LoginScreen
import com.example.lucaslima_trabalho.screens.MenuScreen
import com.example.lucaslima_trabalho.screens.PedidoScreen
import com.example.lucaslima_trabalho.screens.PerfilScreen
import com.example.lucaslima_trabalho.ui.theme.Lucaslima_trabalhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lucaslima_trabalhoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val  navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "pedidos") {
                            PedidoScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "perfil") {
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                    }
                }
            }
        }
    }
}
