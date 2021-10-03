package Skills;

import Characters.Hero;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ElectricShock extends Skill{


    public ElectricShock(Point hero, Point enemy) {
        super(hero, enemy);
        setName("Electrick Shock");
        setWidth(80);
        setHeight(100);

        try {

            setSkillImage(ImageIO.read(new File("LIGHTING.png")));

        }catch (Exception e ) {
            e.printStackTrace();
        }
        setSpeed(4);
    }


}
