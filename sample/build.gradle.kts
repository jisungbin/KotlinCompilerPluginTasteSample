plugins {
  kotlin("jvm")
  application
}

application {
  mainClass = "MainKt"
}

kotlin {
  jvmToolchain(21)
}

dependencies {
  kotlinCompilerPluginClasspath(project(":compiler"))
}
