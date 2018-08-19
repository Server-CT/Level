package org.SCT.Level;

import org.bukkit.ChatColor;

public class Language {
	public static String Prefix = "&7[&9SCT Level&7] ".replace("&", "§");
	public static String Error_Link = "&c&l> ".replace("&", "§");
	public static String Warn_Link = "&e&l> ".replace("&", "§");
	public static String Common_Link = "&a&l> ".replace("&", "§");
	
	public static String[] ErrorFormat = {
    		"&c插件出错 ################################################################################",
    		"",
    		"&6SCT Level &9>",
    		"",
    		"  &7插件遇到错误,请将以下信息提供给开发者.",
    		"  &7版本: &c" + Level.PLUGIN_VERSION,
    		"",
    		"  &7错误类型: &c%e%",
    		"",
    		"&c堆栈追踪 ################################################################################"
    	};
	public static String ErrorOver = "&c报错结束 ################################################################################".replace("&", "§");
	
	public static String[] HelpMessage = {
		"&c&m   &6&m   &e&m   &a&m   &b&m   &e&l&n[SCT Level] 指令&b&m   &a&m   &e&m   &6&m   &c&m   "	,
		"&d/level addlevel &7[&c数值&7] &7[&c玩家&7] &9- &7增加某玩家的等级.",
		"&d/level takelevel &7[&c数值&7] &7[&c玩家&7] &9- &7降低某玩家的等级.",
		"&d/level setlevel &7[&c数值&7] &7[&c玩家&7] &9- &7设置某玩家的等级为指定数值.",
		"",
		"&d/level addexp &7[&c数值&7] &7[&c玩家&7] &9- &7增加某玩家的经验值.",
		"&d/level takeexp &7[&c数值&7] &7[&c玩家&7] &9- &7降低某玩家的经验值.",
		"&d/level setexp &7[&c数值&7] &7[&c玩家&7] &9- &7设置某玩家的经验值为指定数值.",
		"",
		"&d/level reload &9- &7重载插件."
	};
	
	public static String DisableMessage = Prefix + Common_Link + ChatColor.GRAY + "插件已卸载.";
	public static String MyPetEnable = Prefix + Common_Link + ChatColor.GRAY + "MyPet连接已启用.";
	
	public static String UnknownCommand = Prefix + Error_Link + ChatColor.GRAY + "未知指令, 输入/level help来查看帮助.";
	public static String ErrorParam = Prefix + Error_Link + ChatColor.GRAY + "参数错误, 输入/level help来查看帮助.";
	public static String PermDenied = Prefix + Error_Link + ChatColor.GRAY + "你没有权限这么做.";
	public static String AddLevel = Prefix + Common_Link + ChatColor.GRAY + "成功给 %Player% 添加 %Level% 级.";
	public static String AddExp = Prefix + Common_Link + ChatColor.GRAY + "成功给 %Player% 添加 %Exp% 点经验值.";
	public static String ReloadSuccess = Prefix + Common_Link + ChatColor.GRAY + "配置文件重载成功.";
	public static String getExp = Prefix + Common_Link + ChatColor.translateAlternateColorCodes('&', "&7获得 &a%newE% &7经验值! 当前等级 &a%lvl% &7| &a%exp% &7经验值.");
	
	public static void sendError(Exception e) {
		for(String Temp : ErrorFormat) {
			Level.getInstance().getServer().getConsoleSender().sendMessage(Temp.replace("&", "§").replace("%e%", e.toString()));
		}
		e.printStackTrace();
		Level.getInstance().getServer().getConsoleSender().sendMessage(ErrorOver);
	}
	
}
