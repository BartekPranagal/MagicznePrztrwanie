package Characters;

public abstract class Character { //klasa abstrakcyjna zawierająca podstawowe pola dla pozostałych

    private int x,y;
    private int width, height;

    private int maxHp;
    private int currentHp;

    private int baseDmg;
    private int speed;
    private int armor;

    public Character(int x, int y, int width, int height, int maxHp, int currentHp, int baseDmg, int speed, int armor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.baseDmg = baseDmg;
        this.speed = speed;
        this.armor = armor;
    }

    public Character() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
        return currentHp;
    }

    public int getBaseDmg() {
        return baseDmg;
    }

    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }



}
