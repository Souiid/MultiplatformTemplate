package com.idrisssouissi.multiplatformtemplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform