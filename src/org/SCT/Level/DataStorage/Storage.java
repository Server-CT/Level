package org.SCT.Level.DataStorage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class Storage {

    public static class LevelMob {
        private EntityType type;
        private int exp;
        private String name;
        public LevelMob(EntityType type, int exp, String name){
            this.type = type;
            this.exp = exp;
            this.name = name;
        }

        public EntityType getType(){
            return this.type;
        }

        public int getExp(){
            return this.exp;
        }

        public String getName(){
            return this.name;
        }

    }

    public static class LevelItem {
        private double health;
        private String name;
        public LevelItem(double health, String name) {
            this.health = health;
            this.name = name;
        }

        public double getHealth () {
            return this.health;
        }

        public String getName() {
            return this.name;
        }

    }

    public static class LevelUpItem {
        private String name;
        private int exp;
        private int level;
        public LevelUpItem(String name,int exp,int level){
            this.name = name;
            this.exp = exp;
            this.level = level;
        }

        public String getName(){
            return this.name;
        }

        public int getExp(){
            return this.exp;
        }

        public int getLevel(){
            return this.level;
        }

    }
}
