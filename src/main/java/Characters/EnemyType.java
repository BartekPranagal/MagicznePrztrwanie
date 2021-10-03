package Characters;

import java.awt.image.BufferedImage;
import java.io.File;

public enum EnemyType {//przykładowi wrogowie w enum
    NORMAL("Normal",50,50,100,10,2,0,20,"NORMAL_LEFT.png"),
    SPEEDY("Fast",40,40,50,6,3,0,15,"SPEEDY_LEFT.png"),
    FAT("Fat",80,80,200,15,1,0,30,"FAT_LEFT.png"),
    KABOOM("Kaboom",50,50,75,25,2,0,25,"KABOOM_LEFT.png"),
    DIVIDER("Divider",100,100,250,20,1,0,50,"DIVIDER_LEFT.png"),
    SMALL("Small",30,30,60,3,2,0,15,"SMALL_LEFT.png");

    private String name,path;
    private int width,height,maxHp,baseDmg,speed,armor,expValue;

     private EnemyType(String name, int width, int height, int maxHp, int baseDmg, int speed, int armor, int expValue,String path) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.maxHp = maxHp;
        this.baseDmg = baseDmg;
        this.speed = speed;
        this.armor = armor;
        this.expValue = expValue;
        this.path = path;

    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public int getSpeed() {
        return speed;
    }

    public int getArmor() {
        return armor;
    }

    public int getExpValue() {
        return expValue;
    }

    public String getPath() {
        return path;
    }
}