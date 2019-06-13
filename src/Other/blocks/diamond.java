package Other.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class diamond implements Listener {
    public boolean onCommand(CommandSender sender) {
        Player player = (Player) sender;
        if ((sender instanceof Player)) {
            int amountofDiamonds = 0;
            int itemschanged = 0;
            ItemStack[] arrayofItemStack;
            int j = (arrayofItemStack = player.getInventory().getContents()).length;
            for (int i = 0; i < j; i++) {
                ItemStack is = arrayofItemStack[i];
                if (is != null) {
                    if (is.getType() == Material.DIAMOND) {
                        player.getInventory().remove(is);
                        amountofDiamonds += is.getAmount();
                    }
                }
            }
            player.updateInventory();
            itemschanged = amountofDiamonds;
            int diamondsToTransform = amountofDiamonds / 9;
            int diamondOverflow = amountofDiamonds % 9;
            itemschanged -= diamondOverflow;
            player.getInventory().addItem(new ItemStack(diamondsToTransform > 0 ? Material.DIAMOND_BLOCK : Material.AIR, diamondsToTransform));
            player.sendMessage(ChatColor.DARK_GREEN + "You have successfully created " + itemschanged + " Diamond blocks!");
            player.updateInventory();
        } else {
            player.sendMessage(ChatColor.DARK_RED + "No items are able to be changed.");
        }
        return false;
    }
}
