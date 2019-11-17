buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {

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
    kotlin("multiplatform") apply false
    id("com.android.application") apply false
}

subprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

task<Copy>("copyPackages"){
    group = "jsmerda"
    subprojects {
        if("jsJar" in tasks.names)
            dependsOn(tasks["jsJar"])
    }
    from(file("$buildDir/js/")){
        exclude("**/yarn.lock")
        exclude("**/node_modules")
        exclude("**/*.json.hash")
        exclude("package.json")
    }
    into("web-client")
}
