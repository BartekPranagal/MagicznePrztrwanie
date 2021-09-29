package Characters;

import Skills.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Hero extends Character{ // klasa bohater

    //private int level;

    private int currentExp;
    private Level level;

    private BufferedImage heroImage;

    private Map<String, Skill> magicBook = new HashMap<String, Skill>();


    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public BufferedImage getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(BufferedImage heroImage) {
        this.heroImage = heroImage;
    }

    public Map<String, Skill> getMagicBook() {
        return magicBook;
    }

    public void setMagicBook(Map<String, Skill> magicBook) {
        this.magicBook = magicBook;
    }

    public Hero() {
        try {
            heroImage = ImageIO.read(new File("postac.png"));
        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}
