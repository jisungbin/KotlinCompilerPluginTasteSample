@file:Suppress("UnstableApiUsage")

rootProject.name = "KotlinCompilerPluginTasteSample"

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

include(
  ":sample",
  ":compiler",
)
