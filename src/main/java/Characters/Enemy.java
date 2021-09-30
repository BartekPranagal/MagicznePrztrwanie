package Characters;

import java.awt.*;

public class Enemy extends Character { // klasa wróg, nie wiem czy lepsze rozwiązanie to wypisanie wrogów,
    // czy użycie Enum
    private EnemyType enemyType;

    public Enemy(EnemyType enemyType) {
        setX((int) (Math.random() * 1000));
        setY(0);
        setWidth(enemyType.getWidth());
        setHeight(enemyType.getHeight());
        setArmor(enemyType.getArmor());
        setBaseDmg(enemyType.getBaseDmg());
        setMaxHp(enemyType.getMaxHp());
        setSpeed(enemyType.getSpeed());
        this.enemyType = enemyType;

    }

    public Enemy() {

    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void drawEnemy(Graphics g, EnemyType eT, int x, int y) {
        if (eT == EnemyType.FAT) {
            g.setColor(Color.BLACK);
            g.fillOval(x, y, EnemyType.FAT.getWidth(), EnemyType.FAT.getHeight());
        }
        if (eT == EnemyType.NORMAL) {
            g.setColor(Color.BLUE);
            g.fillOval(x, y, EnemyType.NORMAL.getWidth(), EnemyType.NORMAL.getHeight());

        }
        if (eT == EnemyType.DIVIDER) {
            g.setColor(Color.CYAN);
            g.fillOval(x, y, EnemyType.DIVIDER.getWidth(), EnemyType.DIVIDER.getHeight());
        }
        if (eT == EnemyType.KABOOM) {
            g.setColor(Color.RED);
            g.fillOval(x, y, EnemyType.KABOOM.getWidth(), EnemyType.KABOOM.getHeight());
        }
        if (eT == EnemyType.SPEEDY) {
            g.setColor(Color.pink);
            g.fillOval(x, y, EnemyType.SPEEDY.getWidth(), EnemyType.SPEEDY.getHeight());

        }


    }
}
