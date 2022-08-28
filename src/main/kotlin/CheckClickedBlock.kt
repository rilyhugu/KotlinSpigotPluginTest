package com.github.rilyhugu.testplugin

import org.bukkit.Material
import org.bukkit.Material.STICK
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class CheckClickedBlock : Listener {
    @EventHandler
    fun playerClickEvent(event : PlayerInteractEvent) {
        if(event.item != ItemStack(STICK)) {
            return
        }
        var block : Block? = event.clickedBlock

        if(block != null) {
            event.player.sendMessage("クリックしたブロック: ${block.type}")
        }
    }
}