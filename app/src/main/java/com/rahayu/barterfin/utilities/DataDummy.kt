package com.rahayu.barterfin.utilities

// Data Model Product (pindahkan ke file terpisah jika besar)
data class Product(
    val id: String,
    val title: String,
    val imageUrl: String,
    val category: String,
    val location: String,
    val price: String,
    val description: String,
    var isFavorite: Boolean = false // Tambahkan state favorite jika diperlukan
)

// Dummy Data
val dummyProducts = listOf(
    Product(
        id = "1",
        title = "PANARYBODY QN251 Men Shoes...",
        imageUrl = "https://images.unsplash.com/photo-1542291026-79eddc9cdfd2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", // Ganti dengan URL gambar Anda
        category = "Shoe",
        location = "Pineapple st...",
        price = "Rp 160.000",
        description = "PANARYBODY QN251 Men Sneakers, comfortable and lig..."
    ),
    Product(
        id = "2",
        title = "Stylish Backpack for Everyday Use",
        imageUrl = "https://images.unsplash.com/photo-1549298904-4061a99aa42e?q=80&w=1968&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        category = "Bag",
        location = "Maple Ave...",
        price = "Rp 250.000",
        description = "A durable and spacious backpack perfect for students and travelers."
    ),
    Product(
        id = "3",
        title = "Vintage Camera (Collector's Item)",
        imageUrl = "https://images.unsplash.com/photo-1518178864703-911e899b8209?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        category = "Electronics",
        location = "Oak Lane...",
        price = "Rp 800.000",
        description = "A fully functional vintage camera, great for enthusiasts and collectors."
    ),
    Product(
        id = "4",
        title = "Handcrafted Wooden Chair",
        imageUrl = "https://images.unsplash.com/photo-1567584102947-66a9c72e274b?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        category = "Furniture",
        location = "Cedar Road...",
        price = "Rp 400.000",
        description = "Beautifully crafted wooden chair, sturdy and comfortable."
    ),
    Product(
        id = "5",
        title = "Gaming Headset with RGB Lighting",
        imageUrl = "https://images.unsplash.com/photo-1629837265516-7d40a233b497?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        category = "Electronics",
        location = "Elm Street...",
        price = "Rp 320.000",
        description = "High-quality gaming headset for an immersive audio experience."
    )
)