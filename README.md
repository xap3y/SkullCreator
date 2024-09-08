# SkullCreator

## Fork of [SkullCreator](https://github.com/deanveloper/SkullCreator) with extra stuff

The only difference is that it is written in Kotlin, and allows you to get <br>
head from name or UUID online (using MojangAPI)

## Installation

[![Maven Central Version](https://img.shields.io/maven-central/v/eu.xap3y/skullcreator)](https://central.sonatype.com/artifact/eu.xap3y/skullcreator)

<details>
<summary>Maven</summary>

### Add skullcreator as a dependency:

```xml
<dependency>
    <groupId>eu.xap3y</groupId>
    <artifactId>skullcreator</artifactId>
    <version>1.0</version>
</dependency>
```

### And shade it:

```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.6.0</version>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>shade</goal>
                </goals>
                <configuration>
                    <relocations>
                        <relocation>
                            <pattern>eu.xap3y.skullcreator</pattern>
                            <!-- Replace your.package with your real package -->
                            <shadedPattern>your.package.skullcreator</shadedPattern>
                        </relocation>
                    </relocations>
                </configuration>
            </execution>
        </executions>
    </plugin>
</plugins>
```
</details>


<details>
<summary>Gradle (Groovy) </summary>

### Add skullcreator as a dependency:

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'eu.xap3y:skullcreator:1.0'
}

```

### Don't forget to shadow it:

```groovy
plugins {
    id 'com.github.johnrengelman.shadow' version '8.1.1'
}

tasks {
    shadowJar {
        // Dont forget to replace 'your.package' with your package
        relocate 'eu.xap3y.skullcreator', "your.package.skullcreator"
    }
}
```

</details>

<details>
<summary>Gradle (Kotlin DSL)</summary>

### Add skullcreator as a dependency:

```kotlin
repositories {
    mavenCentral()
}
dependencies {
    implementation("eu.xap3y:skullcreator:1.0")
}
```

```kotlin
plugins {
    id("com.github.johnrengelman.shadow") version ("8.1.1")
}

tasks {
    shadowJar {
        relocate("eu.xap3y.skullcreator", "your.package.skullcreator")
    }
}
```
</details>

## Usage

> [!NOTE]\
> Same as the original [SkullCreator](https://github.com/deanveloper/SkullCreator) only except the new stuff below

**You can look at some examples [here](https://github.com/xap3y/SkullCreator/tree/main/src/test)** \
**Docs are available at [skullcreator.xap3y.eu](https://skullcreator.xap3y.eu)**
### By Name (Online)

`SkullCreator.itemFromNameOnline("XAP3Y")` returning `CompletableFuture<ItemStack>` <br>

#### Example (Kotlin)
```kotlin
SkullCreator.itemFromNameOnline("XAP3Y").whenComplete { item, _ ->
    player.inventory.addItem(item)
}
```

### By UUID (Online)

The argument has to be UUID in string. It doesn't matter if you put the UUID with dashed or not <br>
`SkullCreator.itemFromUuidOnline("f1c3931e93d341258fdc9b1dc39bc4d6")` <br> 
which also returns `CompletableFuture<ItemStack>`

#### Example (Kotlin)
```kotlin
SkullCreator.itemFromUuidOnline("f1c3931e93d341258fdc9b1dc39bc4d6").whenComplete { item, _ ->
    player.inventory.addItem(item)
}
```





