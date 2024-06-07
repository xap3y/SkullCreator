// Get all heads of offline players and store them in list
List<ItemStack> list = new java.util.ArrayList<>(List.of());

Arrays.stream(Bukkit.getOfflinePlayers()).toList().forEach((offlinePlayer -> {
    ItemStack head = SkullCreator.itemFromUuid(offlinePlayer.getUniqueId());
    list.add(head);
}));


// Get head from Base64 (using this one: https://minecraft-heads.com/custom-heads/head/95624-machine-part)
ItemStack base64Item = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODI5ZmZlYTRmMWM5N2MzZWE4ODVjMDBjMjg1OTM4ZTk0YjVjNjgyZThiNTBiYWFiYzYxOTc1YmFmYjI2MzFkZCJ9fX0=");

// Get head from URL
ItemStack urlItem = SkullCreator.itemFromUrl("https://textures.minecraft.net/texture/829ffea4f1c97c3ea885c00c285938e94b5c682e8b50baabc61975bafb2631dd");

// Get head of random player, even they never joined the server
try {
    ItemStack playerSkull = SkullCreator.itemFromNameOnline("Notch").get(2L, TimeUnit.SECONDS);
} catch (InterruptedException | ExecutionException | TimeoutException e) {
    // Oh no..
}

// Get head of notch using his UUID
try {
    ItemStack playerSkull = SkullCreator.itemFromUuidOnline("069a79f4-44e9-4726-a5be-fca90e38aaf5").get(2L, TimeUnit.SECONDS);
} catch (InterruptedException | ExecutionException | TimeoutException e) {
    // Oh no..
}