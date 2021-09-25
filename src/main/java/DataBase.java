import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DataBase {
    private static DataBase playerDataBase;

    private List<Player> players = new ArrayList<Player>();
    private Map<String,Integer> scoreBoard = new HashMap<>();

    private DataBase () {
        sampleDataBase();
        loadScoreBoard();

    }


    public static DataBase getPlayerDataBase() {
        if(playerDataBase == null) {
            synchronized (DataBase.class) {
                if(playerDataBase == null) {
                    playerDataBase = new DataBase();
                }

            }

        }
        return playerDataBase;
    }




    public List<Player> getPlayers() {
        return players;
    }

    public Map<String, Integer> getScoreBoard() {
        return scoreBoard;
    }

    private void sampleDataBase() {
        try {
            SessionFactory session = new Configuration().configure().buildSessionFactory();
            Session s = session.openSession();


            s.beginTransaction();

            Player p1 = new Player();
            p1.setFirstName("Marek");
            p1.setLastName("Borkowski");
            p1.setLogin("MaBo");
            p1.setMaxRecord(0);
            p1.setNickName("Borek");
            p1.setPassword("Qwer1234");

            Player p2 = new Player();
            p2.setFirstName("Darek");
            p2.setLastName("Grudzień");
            p2.setLogin("Darek123");
            p2.setMaxRecord(0);
            p2.setNickName("Gruda");
            p2.setPassword("Zaq12wsx");

            Player p3 = new Player();
            p3.setFirstName("Ania");
            p3.setLastName("Kwiecień");
            p3.setLogin("AKA");
            p3.setMaxRecord(0);
            p3.setNickName("AKA");
            p3.setPassword("Kwiatek666");

            s.save(p1);
            s.save(p2);
            s.save(p3);


            s.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadScoreBoard() {
        try {
            SessionFactory session = new Configuration().configure().buildSessionFactory();
            Session s = session.openSession();


            s.beginTransaction();

            Query query = s.createQuery("FROM Player");


            for (Iterator iterator = query.list().iterator(); iterator.hasNext();) {
                Object o = iterator.next();
                players.add((Player) o);
                scoreBoard.put(((Player) o).getNickName(), ((Player) o).getMaxRecord());
            }
            s.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}



