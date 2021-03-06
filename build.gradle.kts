/*
 * BSD 2-Clause License
 * 
 * Copyright (c) 2019, AndreasFagschlunger
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
plugins {
    `java-library`
    `maven-publish`
}

group = "at.o2xfs"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
    withJavadocJar()
    withSourcesJar()
}

repositories {
    if((version as String).endsWith("-SNAPSHOT")) {
        maven {
            url = uri("https://repo.fagschlunger.co.at/libs-snapshot-local")
        }
    }
    maven {
        url = uri("https://repo.fagschlunger.co.at/libs-release-local")
    }
    mavenCentral()
}

dependencies {
    api("at.o2xfs:o2xfs-memory-databind:1.0-SNAPSHOT")
    api("com.fasterxml.jackson.core:jackson-databind:2.11.0")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.11.0")
    implementation("at.o2xfs:o2xfs-log:1.0-SNAPSHOT")
    implementation("org.apache.commons:commons-lang3:3.9")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            url = if((version as String).endsWith("-SNAPSHOT")) uri("https://repo.fagschlunger.co.at/libs-snapshot-local") else uri("https://repo.fagschlunger.co.at/libs-release-local")
            credentials {
                val maven_username: String? by project
                val maven_password: String? by project
                username = maven_username
                password = maven_password
            }
        }
    }
}