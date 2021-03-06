import java.net.InetAddress

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        jcenter()
    }
    dependencies {
        val androidxNavigationVersion: String by project
        val gmsVersion: String by project

        classpath("com.google.gms:google-services:$gmsVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$androidxNavigationVersion")


        // From JDKK 9+ some classes have been moved to Maven. Kapt needs those classes
        // to parse xml and stuff. Load them manually if the current JDK do not contains
        // them.
        if (JavaVersion.current() >= JavaVersion.VERSION_1_9) {
            logger.info("Loading JAXB classes into classpath")
            val jaxbVersion: String by project
            val javaxActivationVersion: String by project
            classpath("javax.xml.bind", "jaxb-api", jaxbVersion)
            classpath("com.sun.xml.bind", "jaxb-core", jaxbVersion)
            classpath("com.sun.xml.bind", "jaxb-impl", jaxbVersion)
            classpath("javax.activation", "activation", javaxActivationVersion)
        }
    }
}

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }

    compileSdkVersion(29)
    buildToolsVersion("30.0.0-rc1")
    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("default") {
            storeFile = file("my-release-key.keystore")
            storePassword = "abcdef1234"
            keyAlias = "alias_name"
            keyPassword = "abcdef1234"
        }
    }

    buildTypes {

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            buildConfigField("String", "SERVER_PROTOCOL", "\"http\"")
            buildConfigField("String", "SERVER_URL", "\"\"")
            buildConfigField("int", "SERVER_PORT", "0")
        }

        getByName("debug") {
            matchingFallbacks = listOf("release")
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "SERVER_PROTOCOL", "\"http\"")
            buildConfigField("String", "SERVER_URL", "\"\"")
            buildConfigField("int", "SERVER_PORT", "0")
        }

        create("mock") {
            isDebuggable = true
            isMinifyEnabled = false
            matchingFallbacks = listOf("release")
            buildConfigField("String", "SERVER_PROTOCOL", "\"http\"")
            buildConfigField("String", "SERVER_URL", "\"mock\"")
            buildConfigField("int", "SERVER_PORT", "42")
        }

        create("localTesting") {
            isDebuggable = true
            isMinifyEnabled = false
            val serverUrl = InetAddress.getLocalHost().hostAddress
            println("Building for host: $serverUrl")
            buildConfigField("String", "SERVER_PROTOCOL", "\"http\"")
            buildConfigField("String", "SERVER_URL", "\"$serverUrl\"")
            buildConfigField("int", "SERVER_PORT", "8080")
            matchingFallbacks = listOf("release")
        }

        all {
            signingConfig = signingConfigs["default"]
        }

    }

    packagingOptions {
        exclude("META-INF/ktor-http.kotlin_module")
        exclude("META-INF/kotlinx-io.kotlin_module")
        exclude("META-INF/atomicfu.kotlin_module")
        exclude("META-INF/ktor-utils.kotlin_module")
        exclude("META-INF/kotlinx-coroutines-io.kotlin_module")
        exclude("META-INF/kotlinx-coroutines-core.kotlin_module")
        exclude("META-INF/kotlinx-serialization-runtime.kotlin_module")
        exclude("META-INF/ktor-http-cio.kotlin_module")
        exclude("META-INF/ktor-client-json.kotlin_module")
        exclude("META-INF/ktor-client-core.kotlin_module")
        exclude("META-INF/ktor-client-serialization.kotlin_module")
        exclude("META-INF/ktor-client-mock.kotlin_module")
        exclude("META-INF/ktor-client-logging.kotlin_module")
    }

}

apply(plugin = "androidx.navigation.safeargs.kotlin")
apply(plugin = "com.google.gms.google-services")

dependencies {

    val androidxAppCompatVersion: String by project
    val androidxCoreVersion: String by project
    val androidxLegacyVersion: String by project
    val androidxNavigationVersion: String by project
    val androidxLifecycleVersion: String by project
    val materialVersion: String by project
    val constraintLayoutVersion: String by project
    val glideVersion: String by project
    val slf4jAndroidVersion: String by project
    val recyclerViewDividerVersion: String by project
    val materialDesignVersion: String by project
    val socialButtonsVersion: String by project
    val facebookSdkVersion: String by project
    val androidKeyboardHiderVersion: String by project
    val googleAuthSdkVersion: String by project

    val junitVersion: String by project
    val espressoVersion: String by project
    val androidTestRunnerVersion: String by project
    val flexibleAdapterVersion: String by project
    val androidxPagingVersion: String by project
    val imagepickerVersion: String by project
    val inlineActivityResultVersion: String by project

    implementation(project(":kodein-di"))

    implementation("androidx.appcompat", "appcompat", androidxAppCompatVersion)
    implementation("androidx.core", "core-ktx", androidxCoreVersion)
    implementation("androidx.legacy", "legacy-support-v4", androidxLegacyVersion)
    implementation("com.google.android.material", "material", materialVersion)
    implementation("androidx.constraintlayout", "constraintlayout", constraintLayoutVersion)
    implementation("androidx.navigation", "navigation-fragment", androidxNavigationVersion)
    implementation("androidx.navigation", "navigation-ui", androidxNavigationVersion)
    implementation("androidx.lifecycle", "lifecycle-extensions", androidxLifecycleVersion)
    implementation("androidx.lifecycle", "lifecycle-viewmodel-ktx", androidxLifecycleVersion)
    implementation("androidx.lifecycle", "lifecycle-runtime-ktx", androidxLifecycleVersion)
    implementation("androidx.lifecycle", "lifecycle-livedata-ktx", androidxLifecycleVersion)
    implementation("androidx.navigation", "navigation-fragment-ktx", androidxNavigationVersion)
    implementation("androidx.navigation", "navigation-ui-ktx", androidxNavigationVersion)
    implementation("androidx.paging", "paging-runtime", androidxPagingVersion)
    implementation("eu.davidea", "flexible-adapter", flexibleAdapterVersion)
    implementation("com.github.fondesa", "recycler-view-divider", recyclerViewDividerVersion)
    implementation("com.google.android.material", "material", materialDesignVersion)
    implementation("in.championswimmer", "Android-SocialButtons", socialButtonsVersion)
    implementation("com.facebook.android", "facebook-android-sdk", facebookSdkVersion)
    implementation("com.github.lamba92", "AndroidKeyboardHider", androidKeyboardHiderVersion)
    implementation("com.google.android.gms", "play-services-auth", googleAuthSdkVersion)

    implementation("com.github.dhaval2404", "imagepicker", imagepickerVersion)
    implementation("com.github.florent37", "inline-activity-result-kotlin", inlineActivityResultVersion)
    implementation("com.github.bumptech.glide", "glide", glideVersion)
    kapt("com.github.bumptech.glide", "compiler", glideVersion)
    runtimeOnly("org.slf4j", "slf4j-android", slf4jAndroidVersion)

    testImplementation("junit", "junit", junitVersion)
    androidTestImplementation("androidx.test", "runner", androidTestRunnerVersion)
    androidTestImplementation("androidx.test.ext", "junit", androidTestRunnerVersion)
    androidTestImplementation("androidx.test.espresso", "espresso-core", espressoVersion)

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

@Suppress("unused")
fun DependencyHandler.ktor(module: String, version: String? = null): Any =
    "io.ktor:ktor-$module${version?.let { ":$version" } ?: ""}"
