package alejandro.barrera.randomusermultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform