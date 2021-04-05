
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin
import org.jetbrains.kotlin.allopen.gradle.SpringGradleSubplugin
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

object RootProject {
    val PROJECT_NAME = "inform_system"
    val SERVICE = "service"
    val FRONT = "front_fx"

    val modules = listOf(SERVICE, FRONT)

    fun moduleByName(name: String) = modules.first { it == name }
}

plugins {
    val KOTLIN = "1.4.21"
    val SPRING_BOOT = "2.4.1"
    val SPRING_DEPENDENCY = "1.0.11.RELEASE"
    val KTLINT = "9.4.1"

    kotlin("jvm") version KOTLIN
    kotlin("kapt") version KOTLIN
    kotlin("plugin.spring") version KOTLIN apply false
    id("org.springframework.boot") version SPRING_BOOT apply false
    id("io.spring.dependency-management") version SPRING_DEPENDENCY
    id("org.jlleitschuh.gradle.ktlint") version KTLINT
}

repositories {
    mavenCentral()
}

subprojects {
    RootProject.moduleByName(name)

    apply<KotlinPlatformJvmPlugin>()
    apply<DependencyManagementPlugin>()
    apply<SpringGradleSubplugin>()
    apply<Kapt3GradleSubplugin>()
    apply<KtlintPlugin>()

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencyManagement {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }


}

configure(subprojects) {
    dependencies {
        kapt("org.springframework.boot:spring-boot-configuration-processor")
        implementation("io.github.microutils:kotlin-logging:1.12.0")
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.21")
    }
}