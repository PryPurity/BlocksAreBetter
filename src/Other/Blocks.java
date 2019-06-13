package Other;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Blocks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (player.hasPermission("bab.blocks") || player.isOp()) {
                int amountofEmeralds = 0;
                int amountofIron = 0;
                int amountofGold = 0;
                int amountofGlowstone = 0;
                int amountofNetherbricks = 0;
                int amountofKelp = 0;
                int coal = 0;
                int redstone = 0;
                int lapis = 0;
                int itemsChanged = 0;
                int itemsChanged2 = 0;
                ItemStack[] arrayofItemStack;
                int j = (arrayofItemStack = player.getInventory().getContents()).length;
                for (int i = 0; i < j; i++) {
                    ItemStack is = arrayofItemStack[i];
                    if (is != null) {
                        if (is.getType() == Material.EMERALD) {
                            amountofEmeralds += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.IRON_INGOT) {
                            player.getInventory().remove(is);
                            amountofIron += is.getAmount();
                        }
                        if (is.getType() == Material.GLOWSTONE_DUST) {
                            amountofGlowstone += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.GOLD_INGOT) {
                            player.getInventory().remove(is);
                            amountofGold += is.getAmount();
                        }
                        if (is.getType() == Material.NETHER_BRICK) {
                            player.getInventory().remove(is);
                            amountofNetherbricks += is.getAmount();
                        }
                        if (is.getType() == Material.DRIED_KELP) {
                            player.getInventory().remove(is);
                            amountofKelp += is.getAmount();
                        }
                        if (is.getType() == Material.COAL) {
                            player.getInventory().remove(is);
                            coal += is.getAmount();
                        }
                        if (is.getType() == Material.REDSTONE) {
                            redstone += is.getAmount();
                            player.getInventory().remove(is);
                        }
                        if (is.getType() == Material.LAPIS_LAZULI) {
                            player.getInventory().remove(is);
                            lapis += is.getAmount();
                        }
                    }
                }
                player.updateInventory();
                itemsChanged = amountofEmeralds + amountofGold + amountofIron + coal + redstone + lapis + amountofKelp;
                itemsChanged2 = amountofGlowstone + amountofNetherbricks;
                int emeraldsToTransform = amountofEmeralds / 9;
                int emeraldsOverflow = amountofEmeralds % 9;
                int ironToTransform = amountofIron / 9;
                int ironOverflow = amountofIron % 9;
                int goldToTransform = amountofGold / 9;
                int goldOverflow = amountofGold % 9;
                int glowstoneToTransform = amountofGlowstone / 4;
                int glowstoneOverflow = amountofGlowstone % 4;
                int netherbrickToTransform = amountofNetherbricks / 4;
                int netherbrickOverflow = amountofNetherbricks % 4;
                int KelpToTransform = amountofKelp / 9;
                int KelpOverflow = amountofKelp % 9;
                int rT = redstone / 9;
                int rO = redstone % 9;
                int lT = lapis / 9;
                int lO = lapis % 9;
                int cT = coal / 9;
                int cO = coal % 9;
                itemsChanged -= emeraldsOverflow + ironOverflow + goldOverflow + KelpOverflow + rO + cO + lO;
                itemsChanged2 -= glowstoneOverflow + netherbrickOverflow;
                player.getInventory().addItem(new ItemStack(emeraldsToTransform > 0 ? Material.EMERALD_BLOCK : Material.AIR, emeraldsToTransform));
                player.getInventory().addItem(new ItemStack(emeraldsOverflow > 0 ? Material.EMERALD : Material.AIR, emeraldsOverflow));
                player.getInventory().addItem(new ItemStack(ironToTransform > 0 ? Material.IRON_BLOCK : Material.AIR, ironToTransform));
                player.getInventory().addItem(new ItemStack(goldToTransform > 0 ? Material.GOLD_BLOCK : Material.AIR, goldToTransform));
                player.getInventory().addItem(new ItemStack(glowstoneToTransform > 0 ? Material.GLOWSTONE : Material.AIR, glowstoneToTransform));
                player.getInventory().addItem(new ItemStack(ironOverflow > 0 ? Material.IRON_INGOT : Material.AIR, ironOverflow));
                player.getInventory().addItem(new ItemStack(goldOverflow > 0 ? Material.GOLD_INGOT : Material.AIR, goldOverflow));
                player.getInventory().addItem(new ItemStack(glowstoneOverflow > 0 ? Material.GLOWSTONE_DUST : Material.AIR, glowstoneOverflow));
                player.getInventory().addItem(new ItemStack(netherbrickToTransform > 0 ? Material.NETHER_BRICKS : Material.AIR, netherbrickToTransform));
                player.getInventory().addItem(new ItemStack(netherbrickOverflow > 0 ? Material.NETHER_BRICK : Material.AIR, netherbrickOverflow));
                player.getInventory().addItem(new ItemStack(KelpOverflow > 0 ? Material.DRIED_KELP : Material.AIR, KelpOverflow));
                player.getInventory().addItem(new ItemStack(KelpToTransform > 0 ? Material.DRIED_KELP_BLOCK : Material.AIR, KelpToTransform));
                player.getInventory().addItem(new ItemStack(rT > 0 ? Material.REDSTONE_BLOCK : Material.AIR, rT));
                player.getInventory().addItem(new ItemStack(lT > 0 ? Material.LAPIS_LAZULI : Material.AIR, lT));
                player.getInventory().addItem(new ItemStack(lO > 0 ? Material.LAPIS_BLOCK : Material.AIR, lO));
                player.getInventory().addItem(new ItemStack(cT > 0 ? Material.COAL_BLOCK : Material.AIR, cT));
                player.getInventory().addItem(new ItemStack(rO > 0 ? Material.REDSTONE : Material.AIR, rO));
                player.getInventory().addItem(new ItemStack(cO > 0 ? Material.COAL : Material.AIR, cO));
                int sum = itemsChanged / 9 + itemsChanged2 / 4;
                player.sendMessage(ChatColor.DARK_GREEN + "All possible items changed into " + sum + " blocks!");
                player.updateInventory();
            } else {
                player.sendMessage(ChatColor.DARK_RED + "No items are able to be changed.");
            }
            return false;
        }
        return false;
    }
}
