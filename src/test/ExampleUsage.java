public class HeadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("Wrong usage! /headof <playerName>");
            return true;
        }

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            String playerName = strings[0];

            SkullCreator.itemFromNameOnline(playerName).whenComplete(((itemStack, throwable) -> {
                if (throwable == null) {
                    player.getInventory().addItem(itemStack);
                    player.sendMessage("Item of player " + playerName + " added to your inventory");
                }
            }));
            return true;
        }
        commandSender.sendMessage("Only players can execute!");
        return false;
    }
}