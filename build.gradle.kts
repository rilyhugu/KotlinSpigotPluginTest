import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import java.net.URI
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.7.10"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven { url = URI("https://repo.papermc.io/repository/maven-public/") }
}

group = "com.github.rilyhugu"
version = "1.0-SNAPSHOT"
java.sourceCompatibility=JavaVersion.VERSION_17
val mcVersion = "1.18.2"


dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Spigot API or Use paper if you want
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")

    library(kotlin("stdlib")) // All platforms
    library("com.google.code.gson", "gson", "2.8.7") // All platforms
    bukkitLibrary("com.google.code.gson", "gson", "2.8.7") // Bukkit only
}


bukkit {
    main = "com.github.rilyhugu.testplugin.TestPlugin"

    apiVersion = "1.18"

    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    author = "Rily"
    prefix = "TestPlugin"

    /*
    commands {
        register("command") {
            description = "Just a command!"
            aliases = listOf("cmd")
            permission = "command.children"
            usage = "/command"
            permissionMessage = "no perm"
        }
    }


    permissions {
        register("command.*") {
            children = listOf("ktt.children")

        }

        register("command.children") {
            description = "the childlen command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
    }
    */
}




application {
    // Define the main class for the application.
    mainClass.set("kotlinTest")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}