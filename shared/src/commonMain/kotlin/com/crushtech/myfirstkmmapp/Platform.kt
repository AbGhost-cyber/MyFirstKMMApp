package com.crushtech.myfirstkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
