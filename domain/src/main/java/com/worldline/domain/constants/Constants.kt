package com.worldline.domain.constants

/**
 * Constants
 */
class Constants {
    companion object {
        val EMPTY_STRING: String = ""

        val DEFAULT_LONG: Long = 0

        val DEFAULT_INT: Int = 0

        fun preferencesName(buildType: BuildType): String = when (buildType) {
            BuildType.DEBUG -> "t21_debug"
            BuildType.RELEASE -> "t21"
        }

        fun notificationChannelId(buildType: BuildType): String = when (buildType) {
            BuildType.DEBUG -> "t21_debug"
            BuildType.RELEASE -> "t21"
        }
    }
}

fun buildType(type: String): BuildType = when (type) {
    "debug" -> BuildType.DEBUG
    else -> BuildType.RELEASE
}

enum class BuildType {
    DEBUG, RELEASE
}