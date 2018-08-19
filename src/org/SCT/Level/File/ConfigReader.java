package org.SCT.Level.File;

import org.SCT.Core.File.FileTool;
import org.SCT.Level.DataStorage.Storage;
import org.SCT.Level.Level;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.inventivetalent.itembuilder.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ConfigReader extends FileUtil{

    public static ConfigReader config;

    public static List<Storage.LevelMob> levelmob = new ArrayList<>();
    public static List<Storage.LevelItem> levelitem = new ArrayList<>();
    public static List<Storage.LevelUpItem> levelupitem = new ArrayList<>();
    public static List<Integer> IntegerList = new ArrayList<>();
    public static Map<Integer, Integer> levelMap = new HashMap<>();
    public static double healthAdd;


    private ConfigReader() { super(Level.getInstance(), "config.yml"); }
    public static void reload() { config = new ConfigReader(); }

    public void check() {

        File file = new File(Level.INSTANCE.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection mobSection = config.getConfigurationSection("Mob");
        ConfigurationSection healthSection = config.getConfigurationSection("HealthItems");
        ConfigurationSection levelSection = config.getConfigurationSection("LevelItems");


        //遍历Mob
        for(String key : mobSection.getKeys(false)) {
            levelmob.add(new Storage.LevelMob(EntityType.fromName(
                    mobSection.getString(key + ".Type")),
                    mobSection.getInt(key + ".Exp"),
                    mobSection.getString(key + ".Name")

            ));
        }

        //遍历Item
        for(String key : levelSection.getKeys(false)) {
            levelupitem.add(new Storage.LevelUpItem(
                    levelSection.getString(key + ".Name"),
                    levelSection.getInt(key + ".Exp"),
                    levelSection.getInt(key + ".Level")
            ));
        }

        //遍历血量道具
        for (String key : healthSection.getKeys(false)) {
            levelitem.add(new Storage.LevelItem(
                    healthSection.getDouble(key + ".Health"),
                    healthSection.getString(key + ".Name")
            ));
        }

        healthAdd = config.getDouble("HealthAdd");

        //按照行来遍历等级对应的经 验点，第一行就是等级1：xxx经验点
        int Lv = 0;
        IntegerList = config.getIntegerList("Level");
        Iterator iterator = IntegerList.iterator();
        while (iterator.hasNext()) { levelMap.put(Lv++, (Integer)iterator.next()); }
    }

    /**
     * 获取等级对应的经验点，用来判断是否达到等级
     * @param level 等级
     * @return 对应的经验点(累计)
     */
    public static int getLevelMapExp(int level) {
        int exp = 0;
        exp = levelMap.get(level);
        return exp;
    }

    /**
     * 返回怪物掉落的经验，不存在则返回0
     * @param type
     * @param name
     * @return Mob掉落的exp
     */
    public static int getMobExp(EntityType type, String name) {
        for(Storage.LevelMob mob : ConfigReader.levelmob) {
            if(mob.getName().equalsIgnoreCase(name) && mob.getType().equals(type)) {
                return mob.getExp();
            }
        }
        return 0;
    }

    /**
     * 获取指定道具的可升级血量
     * @param item 目标道具的血量
     * @return 升级的血量
     */
    public static double getItemHealth(String item) {
        double health = 0.0;
        for(Storage.LevelItem items : ConfigReader.levelitem) {
            if(items.getName().equals(item)) {
                health = items.getHealth();
            }
        }
        return health;
    }

    /**
     * 返回道具的经验
     * @param item 目标道具
     * @return 经验点
     */
    public static int getItemExp(ItemStack item) {
        int exp = 0;
        for(Storage.LevelUpItem items : ConfigReader.levelupitem) {
            if(items.getName().equals(item)) {
                exp = items.getExp();
            }
        }
        return exp;
    }

    /**
     * 获得一个回复血量的物品
     * @param useItem 血量物品
     * @return 血量道具，有问题返回null
     */
    public static ItemStack getLevelItem(ItemStack useItem) {
        for(Storage.LevelItem item : ConfigReader.levelitem) {
            if(useItem.isSimilar(FileTool.getItem(item.getName()))) {
                return useItem;
            }
        }
        return null;
    }

    /**
     * 返回升级增加的血量
     * @return
     */
    public static double getHealthAdd() {
        return healthAdd;
    }

    /**
     * 判断怪物名字是否包含在Cofnig里面
     * @param name
     * @return
     */
    public static boolean isContainString(String name) {
        if (name == null) return false;
        for(Storage.LevelMob level : levelmob) {
            if(level.getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

}
