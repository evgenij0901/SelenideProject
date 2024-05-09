plugins {
    java
    id("io.qameta.allure") version "2.10.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.codeborne:selenide:7.2.3")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("io.qameta.allure:allure-junit5:2.10.0")
    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy("allureReport")
}
