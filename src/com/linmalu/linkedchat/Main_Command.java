package com.linmalu.linkedchat;

import com.linmalu.library.api.LinmaluCommand;
import com.linmalu.library.api.LinmaluMain;
import com.linmalu.library.api.LinmaluPlayer;
import com.linmalu.library.api.LinmaluTellraw;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Main_Command extends LinmaluCommand
{
	public Main_Command(LinmaluMain main)
	{
		super(main);
	}

	@Override
	protected List<String> TabCompleter(CommandSender sender, Command command, String alias, String[] args)
	{
		return null;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if(!sender.isOp())
		{
			sender.sendMessage(ChatColor.RED + "권한이 없습니다.");
			return true;
		}
		if(args.length > 1)
		{
			LinmaluTellraw lt = new LinmaluTellraw(joinString(args, 1)).changeText().changeCmd().changeCmdText();
			if(sender instanceof Player)
			{
				Player player = (Player)sender;
				lt.changeItem(player).changeCmdItem(player);
			}
			lt.sendMessage(LinmaluPlayer.getPlayers(args[0]));
		}
		else
		{
			sender.sendMessage(ChatColor.GREEN + " = = = = = [ Linmalu LinkedChat ] = = = = =");
			LinmaluTellraw.sendChat(sender, "/" + label + " ", ChatColor.GOLD + "/" + label + " <내용> (내용)..." + ChatColor.GRAY + " : 전체에게 메세지 보내기");
			sender.sendMessage(ChatColor.GREEN + "채팅창 아이템 : " + ChatColor.GOLD + "$ITEM$ , $I$, $아이템$");
			sender.sendMessage(ChatColor.GREEN + "채팅창 텍스트 : " + ChatColor.GOLD + "$TEXT$ , $T$, $텍스트$");
			sender.sendMessage(ChatColor.GREEN + "채팅창 명령어 : " + ChatColor.GOLD + "$CMD$ , $C$, $명령어$");
			sender.sendMessage(ChatColor.GREEN + "채팅창 명령어아이템 : " + ChatColor.GOLD + "$CMDITEM$ , $CI$, $명령어아이템$");
			sender.sendMessage(ChatColor.GREEN + "채팅창 명령어텍스트 : " + ChatColor.GOLD + "$CMDTEXT$ , $CT$, $명령어텍스트$");
			sender.sendMessage(ChatColor.YELLOW + "제작자 : " + ChatColor.AQUA + "린마루(Linmalu)" + ChatColor.WHITE + " - http://blog.linmalu.com");
		}
		return true;
	}
}
