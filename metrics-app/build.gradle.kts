import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.hives"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.3.0-alpha14")
    implementation("net.logstash.logback:logstash-logback-encoder:7.0.1")

    implementation(platform("org.http4k:http4k-bom:4.19.5.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-jetty")

    implementation("io.micrometer:micrometer-registry-prometheus:1.8.2")
    implementation("io.micrometer:micrometer-core:1.8.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}