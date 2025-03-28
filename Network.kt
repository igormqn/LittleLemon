package com.example.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val price: String
)

private suspend fun fetchMenu(): List<MenuItemNetwork> {
    val url = "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonSimpleMenu.json"
    val response: MenuNetwork = httpClient.get(url).body()
    return response.menu
}

fun MenuItemNetwork.toMenuItemRoom() = MenuItemRoom(
    id = this.id,
    title = this.title,
    price = this.price
)