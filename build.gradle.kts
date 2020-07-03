plugins {
    idea
    Dependencies.plugins.forEach { (n, v) -> id(n) version v }
}

group = "com.github.nwillc"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}

dependencies {
    Dependencies.artifacts(
        "io.gitlab.arturbosch.detekt:detekt-cli",
        "io.gitlab.arturbosch.detekt:detekt-formatting"
    ) { detekt(it) }

    Dependencies.artifacts(
          "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
      ) { implementation(it) }

    Dependencies.artifacts(
        "org.assertj:assertj-core",
        "org.junit.jupiter:junit-jupiter"
    ) { testImplementation(it) }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
