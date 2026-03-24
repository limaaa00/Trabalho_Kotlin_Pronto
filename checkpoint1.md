# Projeto Android com Jetpack Compose

## Descrição
Este projeto foi desenvolvido em Kotlin utilizando Jetpack Compose, com o objetivo de praticar a navegação entre telas em um aplicativo Android.

O aplicativo possui quatro telas:
- Login
- Menu
- Perfil
- Pedidos

---

## Estrutura
O projeto está organizado da seguinte forma:

- MainActivity.kt
- screens
    - LoginScreen.kt
    - MenuScreen.kt
    - PerfilScreen.kt
    - PedidoScreen.kt

---

## Funcionamento

A navegação é controlada pelo NavController dentro da MainActivity.

Inicialmente, a aplicação utilizava apenas rotas simples, sem envio de informações entre as telas.

Exemplo:
```kotlin
composable("perfil") {
    PerfilScreen(modifier, navController)
}