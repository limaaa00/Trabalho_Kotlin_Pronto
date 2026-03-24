# Navigation Compose - Passagem de Parâmetros
 
Evolução do projeto anterior, agora com passagem de parâmetros entre telas usando Jetpack Compose Navigation.
 
## Telas
 
- LoginScreen
- MenuScreen
- PerfilScreen
- PedidosScreen
 
## O que foi feito
 
### 1. Parâmetros obrigatórios - Tela de Perfil
 
A rota foi alterada para receber `nome` e `idade` obrigatoriamente:
 
```kotlin
composable(
    route = "perfil/{nome}/{idade}",
    arguments = listOf(
        navArgument("nome") { type = NavType.StringType },
        navArgument("idade") { type = NavType.IntType }
    )
) {
    val nome = it.arguments?.getString("nome")
    val idade = it.arguments?.getInt("idade")
    PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!, idade!!)
}
```
 
Os parâmetros ficam embutidos na rota entre chaves `{}`. O `NavType` é necessário para o sistema saber o tipo de cada um. Na tela, eles são recebidos como parâmetros normais da função e exibidos no texto.
 
A navegação é feita assim:
```kotlin
navController.navigate("perfil/Fulano de Tal/27")
```
 
### 2. Parâmetro opcional - Tela de Pedidos
 
A rota usa query parameter (`?`) para tornar o parâmetro opcional:
 
```kotlin
composable(
    route = "pedidos?cliente={cliente}",
    arguments = listOf(
        navArgument("cliente") { defaultValue = "Cliente Genérico" }
    )
) {
    PedidosScreen(modifier = Modifier.padding(innerPadding), navController, it.arguments?.getString("cliente"))
}
```
 
O `defaultValue` garante que, se nenhum cliente for passado, a tela ainda funciona normalmente com o valor padrão. Não precisa declarar `NavType` porque o padrão já é String.
 
Navegando com valor:
```kotlin
navController.navigate("pedidos?cliente=Cliente XPTO")
```
 
Navegando sem valor (usa o defaultValue):
```kotlin
navController.navigate("pedidos")
```
 
### 3. Múltiplos parâmetros
 
No MenuScreen, o botão de Perfil envia os dois parâmetros juntos na mesma chamada:
 
```kotlin
navController.navigate("perfil/Fulano de Tal/27")
```
 
O Navigation Compose mapeia cada valor pela posição na rota, então `"Fulano de Tal"` vai para `{nome}` e `"27"` vai para `{idade}`.
 
## Diferença entre obrigatório e opcional
 
| | Obrigatório | Opcional |
|---|---|---|
| Sintaxe | `rota/{param}` | `rota?param={param}` |
| Valor padrão | Não tem | Sim, com `defaultValue` |
| NavType | Necessário | Não obrigatório |
