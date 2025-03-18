import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.external.javadoc.StandardJavadocDocletOptions

plugins {
    java
    id("com.diffplug.spotless") version "6.25.0"
}

group = "cz.kocaro03"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register<Jar>("javadocJar") {
    dependsOn(tasks.javadoc)
    archiveClassifier.set("javadoc")
    from(tasks.javadoc.get().destinationDir)
}

tasks.withType<Javadoc>().configureEach {
    (options as? StandardJavadocDocletOptions)?.let {
        it.encoding = "UTF-8"
        it.addStringOption("Xdoclint:none", "-quiet")
    }
}