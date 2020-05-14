repositories {
    jcenter()
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.0-rc01")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.3.72")
    implementation("net.java.dev.jna:jna:4.2.2")
}

gradlePlugin {

    plugins {
        create("dynamic-flavor") {
            id = "dynamic-flavor"
            implementationClass = "DynamicFlavorPlugin"
        }
    }

}