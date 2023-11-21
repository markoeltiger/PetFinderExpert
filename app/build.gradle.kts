import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.mark.petfinderexpert"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mark.petfinderexpert"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        val properties = Properties()
        val apiKey: String
        val apiSecret: String

        val localPropertiesFile = project.rootProject.file("local.properties")
        apiKey = if (localPropertiesFile.exists()) {
            properties.load(localPropertiesFile.inputStream())
            properties.getProperty("API_KEY") ?: ""
        } else {
            System.getenv("API_KEY") ?: ""
        }
        apiSecret = if (localPropertiesFile.exists()) {
            properties.load(localPropertiesFile.inputStream())
            properties.getProperty("API_SECERET") ?: ""
        } else {
            System.getenv("API_SECERET") ?: ""
        }

        buildConfigField(
            "String",
            "API_KEY",
            "\"$apiKey\""
        )
        buildConfigField(
            "String",
            "API_SECERET",
            "\"$apiSecret\""
        )
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"

    }
    buildFeatures {
        compose = true
        buildConfig = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.android.gms:play-services-basement:18.2.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")

    //daggerhilt
    implementation( "com.google.dagger:hilt-android:2.44")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt( "com.google.dagger:hilt-android-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // Retrofit & okhttp3
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    // JitpackUI
    implementation("com.github.bumptech.glide:glide:4.13.0")
    kapt("com.github.bumptech.glide:compiler:4.9.0")
    //SDP Library
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.intuit.ssp:ssp-android:1.0.6")
    // gson
    implementation("com.google.code.gson:gson:2.10.1")
    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Navigation
    val nav_version = "2.7.5"
    implementation ("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    //Testing
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:2.11.0")
    testImplementation ("android.arch.core:core-testing:1.1.1")
    testImplementation ("com.google.truth:truth:1.1")
    debugImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    androidTestImplementation ("org.mockito.kotlin:mockito-kotlin:4.1.0")
    androidTestImplementation ("io.mockk:mockk-android:1.12.3")
    androidTestImplementation ("org.mockito:mockito-android:5.7.0")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation ("io.mockk:mockk:1.12.3")
    testImplementation ("app.cash.turbine:turbine:1.0.0")
    testImplementation ("org.hamcrest:hamcrest:2.2")
    testImplementation ("org.hamcrest:hamcrest-library:2.2")
    testImplementation ("org.amshove.kluent:kluent:1.69")
    testImplementation ("org.amshove.kluent:kluent-android:1.69")
    testImplementation ("org.mockito:mockito-inline:3.11.2")

    // For Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:2.28-alpha")
    //Coil Image
    implementation("io.coil-kt:coil-compose:2.5.0")

}