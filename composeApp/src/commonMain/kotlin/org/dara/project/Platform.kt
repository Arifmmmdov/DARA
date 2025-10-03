package org.dara.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform