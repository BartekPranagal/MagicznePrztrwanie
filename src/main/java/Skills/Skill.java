package Skills;

import Characters.Hero;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skill {


    Hero hero;

    private String name;

    private int x,y;
    private int width, height;

    private int dmg;
    private int level;
    private int cooldown;
    private int speed;

    private double deltaX;
    private double deltaY;
    private double degree;

    private boolean isVisible = false;

    private BufferedImage skillImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BufferedImage getSkillImage() {
        return skillImage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSkillImage(BufferedImage skillImage) {
        this.skillImage = skillImage;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,width,height);
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public Skill() {

    }
//    public Skill (Point hero, Point enemy) {
//        int startX = hero.x;
//        int startY = hero.y;
//
//        double deltaX = enemy.x - hero.x;
//        double deltaY = enemy.y-hero.y;
//
//        this.degree = Math.sqrt(deltaX*deltaX + deltaY+deltaY);
//
//        this.deltaX = deltaX/degree*getSpeed();
//        this.deltaY = deltaY/degree*getSpeed();
//
//    }
    public void drawSkill(Graphics g,int x,int y, int width,int height) {
        g.drawImage(skillImage,(int)x,(int)y,width,height,null);

    }


}
