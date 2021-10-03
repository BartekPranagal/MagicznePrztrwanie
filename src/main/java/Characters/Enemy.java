package Characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends Character {
    private EnemyType enemyType;
    private BufferedImage enemyImage;

    public Enemy(EnemyType enemyType) {
        this.enemyType = enemyType;
        setWidth(enemyType.getWidth());
        setHeight(enemyType.getHeight());
        setArmor(enemyType.getArmor());
        setBaseDmg(enemyType.getBaseDmg());
        setMaxHp(enemyType.getMaxHp());
        setSpeed(enemyType.getSpeed());
        setCurrentHp(enemyType.getMaxHp());

        try {
            this.enemyImage = ImageIO.read(new File(enemyType.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public BufferedImage getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(BufferedImage enemyImage) {
        this.enemyImage = enemyImage;
    }

    public Enemy() {

    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void drawEnemy(Graphics g,EnemyType eT, int x, int y,int width,int height) {
        if (eT == EnemyType.FAT) {
            g.drawImage(enemyImage,x,y,width,height,null);
        }
        if (eT == EnemyType.NORMAL) {
            g.drawImage(enemyImage,x,y,width,height,null);
        }
        if (eT == EnemyType.DIVIDER) {
            g.drawImage(enemyImage,x,y,width,height,null);        }
        if (eT == EnemyType.KABOOM) {
            g.drawImage(enemyImage,x,y,width,height,null);        }
        if (eT == EnemyType.SPEEDY) {
            g.drawImage(enemyImage,x,y,width,height,null);
        }
        if(eT == EnemyType.SMALL) {
            g.drawImage(enemyImage,x,y,width,height,null);        }


    }
}
