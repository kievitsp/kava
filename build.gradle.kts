plugins {
    kotlin("jvm") version "1.8.22"
    id("com.google.devtools.ksp") version "1.8.22-1.0.11"
}

version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.22-1.0.11")
    implementation("com.squareup:kotlinpoet:1.14.2")
    testImplementation(kotlin("test"))
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("src/main/kotlin")
    }
    sourceSets.test {
        kotlin.srcDir("src/test/kotlin")
    }

    resources.text
}

repositories {
    mavenCentral()
}

java {
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.test {
    useJUnitPlatform()
}
