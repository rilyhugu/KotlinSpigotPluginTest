package com.github.rilyhugu.testplugin

import org.bukkit.plugin.java.JavaPlugin

class TestPlugin: JavaPlugin() {
    override fun onEnable() {
        logger.info("plugin loaded!")
        server.pluginManager.registerEvents(CheckClickedBlock(), this)

    }

    override fun onDisable() {
        logger.info("plugin unloaded!")
    }
}