package Skills;

import Characters.Hero;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ElectricShock extends Skill{

    public ElectricShock(int x,int y) {
        setX(x);
        setY(y);
        setName("Electrick Shock");
        setWidth(20);
        setHeight(60);

        try {

            setSkillImage(ImageIO.read(new File("LIGHTING.png")));

        }catch (Exception e ) {
            e.printStackTrace();
        }
        setSpeed(4);
    }

//    public ElectricShock(Point hero, Point enemy) {
//        super(hero, enemy);
//        setName("Electrick Shock");
//        setWidth(20);
//        setHeight(60);
//
//        try {
//
//            setSkillImage(ImageIO.read(new File("LIGHTING.png")));
//
//        }catch (Exception e ) {
//            e.printStackTrace();
//        }
//        setSpeed(4);
//    }


}
