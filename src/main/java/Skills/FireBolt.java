package Skills;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class FireBolt extends Skill{

//    public FireBolt(Point hero, Point enemy) {
//        super(hero, enemy);
//        setName("Fire Bolt");
//        setWidth(30);
//        setHeight(20);
//
//        try {
//
//            setSkillImage(ImageIO.read(new File("FIREBALL.png")));
//
//        }catch (Exception e ) {
//            e.printStackTrace();
//        }
//        setSpeed(1);
//    }
    public FireBolt() {

    }
    public FireBolt(int x,int y) {
        setX(x);
        setY(y);
        setName("Fire Bolt");
        setWidth(30);
        setHeight(20);
        setSpeed(2);
        try {

            setSkillImage(ImageIO.read(new File("FIREBALL.png")));

        }catch (Exception e ) {
            e.printStackTrace();
        }

    }
}
