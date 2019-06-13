package Other.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class emerald implements Listener {
    public boolean onCommand(CommandSender sender) {
        Player player = (Player) sender;
        if ((sender instanceof Player)) {
            if (player.hasPermission("bab.blocks.emerald") || player.isOp()) {
                int amountofEmeralds = 0;
                int itemschanged = 0;
                ItemStack[] arrayofItemStack;
                int j = (arrayofItemStack = player.getInventory().getContents()).length;
                for (int i = 0; i < j; i++) {
                    ItemStack is = arrayofItemStack[i];
                    if (is != null) {
                        if (is.getType() == Material.EMERALD) {
                            player.getInventory().remove(is);
                            amountofEmeralds += is.getAmount();
                        }
                    }
                }
                player.updateInventory();
                itemschanged = amountofEmeralds;
                int emeraldsToTransform = amountofEmeralds / 9;
                int emeraldOverflow = amountofEmeralds % 9;
                itemschanged -= emeraldOverflow;
                player.getInventory().addItem(new ItemStack(emeraldsToTransform > 0 ? Material.EMERALD_BLOCK : Material.AIR, emeraldsToTransform));
                player.sendMessage(ChatColor.DARK_GREEN + "You have successfully created " + itemschanged + " Diamond blocks!");
                player.updateInventory();
            } else {
                player.sendMessage(ChatColor.DARK_RED + "No items are able to be changed.");
            }
            return false;
        }
        return false;
    }
}
