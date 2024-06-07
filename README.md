# SkullCreator

## Fork of [SkullCreator](https://github.com/deanveloper/SkullCreator) with extra stuff

The only difference is that it is written in Kotlin, and allows you to get <br>
head from name or UUID online (using MojangAPI)

## Download

<details>
<summary>Maven</summary>

First, add JitPack to your repositories

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Then add this as dependency

```xml
<dependency>
    <groupId>com.github.xap3y</groupId>
    <artifactId>SkullCreator</artifactId>
    <version>1.0</version>
    <scope>compile</scope>
</dependency>
```

</details>


<details>
<summary>Gradle</summary>

```sql
repositories {
    maven { url 'https://jitpack.io' }
}
             
dependencies {
    compileOnly "com.github.xap3y:SkullCreator:1.0"
}
```

</details>

## Usage

> [!NOTE]\
> Same as the original [SkullCreator](https://github.com/deanveloper/SkullCreator) only except the new stuff below

**You can look at some examples [here](https://github.com/xap3y/SkullCreator/tree/main/src/test)**

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





