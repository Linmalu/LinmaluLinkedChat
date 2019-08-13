package com.linmalu.linkedchat;

import com.linmalu.library.api.LinmaluServer;
import com.linmalu.library.api.LinmaluTellraw;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Main_Event implements Listener
{
	@EventHandler
	public void event(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(player.isOp())
		{
			LinmaluServer.version(Main.getInstance(), player);
		}
	}
	@EventHandler(priority = EventPriority.MONITOR)
	public void event(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();
		LinmaluTellraw msg = new LinmaluTellraw(event.getFormat().replace("%1$s", player.getDisplayName()).replace("%2$s", event.getMessage()));
		if(player.isOp() || player.hasPermission("linkedchat.item"))
		{
			msg.changeItem(player);
		}
		if(player.isOp() || player.hasPermission("linkedchat.text"))
		{
			msg.changeText();
		}
		if(player.isOp() || player.hasPermission("linkedchat.cmd"))
		{
			msg.changeCmd();
		}
		if(player.isOp() || player.hasPermission("linkedchat.cmditem"))
		{
			msg.changeCmdItem(player);
		}
		if(player.isOp() || player.hasPermission("linkedchat.cmdtext"))
		{
			msg.changeCmdText();
		}
		if(msg.isChange())
		{
			msg.sendMessage(event.getRecipients());
			Bukkit.getConsoleSender().sendMessage(event.getFormat().replace("%1$s", player.getDisplayName()).replace("%2$s", event.getMessage()));
			event.setCancelled(true);
		}
	}
}
