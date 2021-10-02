package Skills;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skill {

    private String name;

    private int x,y;
    private int width, height;

    private int dmg;
    private int skillLevel;

    private BufferedImage skillImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public BufferedImage getSkillImage() {
        return skillImage;
    }

    public void setSkillImage(BufferedImage skillImage) {
        this.skillImage = skillImage;
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
