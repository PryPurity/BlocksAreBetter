package Other.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class coal implements Listener {
    public boolean onCommand(CommandSender sender) {
        Player player = (Player) sender;
        if ((sender instanceof Player)) {
            int amountofCoal = 0;
            int itemschanged = 0;
            ItemStack[] arrayofItemStack;
            int j = (arrayofItemStack = player.getInventory().getContents()).length;
            for (int i = 0; i < j; i++) {
                ItemStack is = arrayofItemStack[i];
                if (is != null) {
                    if (is.getType() == Material.COAL) {
                        player.getInventory().remove(is);
                        amountofCoal += is.getAmount();
                    }
                }
            }
            player.updateInventory();
            itemschanged = amountofCoal;
            int coalToTransform = amountofCoal / 9;
            int coalOverflow = amountofCoal % 9;
            itemschanged -= coalOverflow;
            player.getInventory().addItem(new ItemStack(coalToTransform > 0 ? Material.COAL_BLOCK : Material.AIR, coalToTransform));
            player.sendMessage(ChatColor.DARK_GREEN + "You have successfully created " + itemschanged + " Coal blocks!");
            player.updateInventory();
        } else {
            player.sendMessage(ChatColor.DARK_RED + "No items are able to be changed.");
        }
        return false;
    }
}

}
