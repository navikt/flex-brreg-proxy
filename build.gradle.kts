import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jlleitschuh.gradle.ktlint") version "12.3.0"
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
}

group = "no.nav.helse.flex"
version = "1.0.0"
description = "flex-brreg-proxy"
java.sourceCompatibility = JavaVersion.VERSION_21

ext["okhttp3.version"] = "4.12" // Token-support tester trenger MockWebServer.

repositories {
    mavenCentral()
    maven {
        url = uri("https://github-package-registry-mirror.gc.nav.no/cached/maven-release")
    }
}

val logstashLogbackEncoderVersion = "8.1"
val kluentVersion = "1.73"
val commonsTextVersion = "1.14.0"
val tokenSupportVersion = "5.0.39"
val apacheCxfVersion = "4.1.4"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.retry:spring-retry:2.0.12")

    implementation("no.nav.security:token-validation-spring:$tokenSupportVersion")
    // Påkrevd av token-validation-spring
    implementation("org.hibernate.validator:hibernate-validator")
    implementation("no.nav.security:token-client-spring:$tokenSupportVersion")

    implementation("org.apache.httpcomponents.client5:httpclient5")
    implementation("org.apache.commons:commons-text:$commonsTextVersion")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashLogbackEncoderVersion")

    implementation("org.apache.cxf:cxf-rt-frontend-jaxws:$apacheCxfVersion")
    implementation("org.apache.cxf:cxf-rt-transports-http:$apacheCxfVersion")
    implementation("com.sun.xml.messaging.saaj:saaj-impl:3.0.4")

    testImplementation("no.nav.security:token-validation-spring-test:$tokenSupportVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")
}

configure<SourceSetContainer> {
    named("main") {
        java.srcDir("src/main/java")
        java.srcDir("src/generated/java")
    }
}

ktlint {
    version.set("1.5.0")
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        freeCompilerArgs.add("-Xjsr305=strict")
        if (System.getenv("CI") == "true") {
            allWarningsAsErrors.set(true)
        }
    }
}

tasks {
    test {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
        testLogging {
            events("PASSED", "FAILED", "SKIPPED")
            exceptionFormat = TestExceptionFormat.FULL
        }
        failFast = false
    }
}

tasks {
    bootJar {
        archiveFileName = "app.jar"
    }
}
