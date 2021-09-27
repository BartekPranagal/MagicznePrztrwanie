import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Hero {
    private int x;
    private int y;

    private final int sx = 50, sy = 50;

    public int getSx() {
        return sx;
    }

    public int getSy() {
        return sy;
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
    BufferedImage hero;
    public Hero(){
        try{
            hero = ImageIO.read(new File("postac.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
