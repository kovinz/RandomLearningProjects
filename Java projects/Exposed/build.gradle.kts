plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.exposed", "exposed-core", "0.20.1")
    compile("org.jetbrains.exposed", "exposed-dao", "0.20.1")
    compile("org.jetbrains.exposed", "exposed-jdbc", "0.20.1")
    compile("com.h2database", "h2", "1.4.199")
    compile("org.slf4j", "slf4j-api", "1.7.5")
    compile("org.slf4j", "slf4j-simple", "1.6.4")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}