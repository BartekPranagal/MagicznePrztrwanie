package Characters;

public enum EnemyType {//przykładowi wrogowie w enum
    NORMAL("Normal",40,40,100,10,2,0,20),
    SPEEDY("Fast",30,30,50,6,3,0,15),
    FAT("Fat",80,80,200,15,1,0,30),
    KABOOM("Kaboom",40,40,75,25,2,0,25),
    DIVIDER("Divider",100,100,250,20,1,0,50);

    private String name;
    private int width,height,maxHp,baseDmg,speed,armor,expValue;

    private EnemyType(String name,int width, int height, int maxHp, int baseDmg, int speed, int armor,int expValue) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.maxHp = maxHp;
        this.baseDmg = baseDmg;
        this.speed = speed;
        this.armor = armor;
        this.expValue = expValue;
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

}
