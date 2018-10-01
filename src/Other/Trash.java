package Other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trash implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("bab.trash") || player.isOp()) {
            Inventory i = Bukkit.createInventory(null, 54, "Trashcan For Crap");
            player.openInventory(i);
            return true;
        }
        return false;
    }
}
