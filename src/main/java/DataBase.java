import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DataBase {
    private static DataBase playerDataBase;

    private List<Player> players = new ArrayList<Player>();
    private Map<String, Integer> scoreBoard = new HashMap<>();
    private SessionFactory session = new Configuration().configure().buildSessionFactory();
    Player activePlayer;
    private DataBase() {
        sampleDataBase();

    }

    public static DataBase getPlayerDataBase() {
        if (playerDataBase == null) {
            synchronized (DataBase.class) {
                if (playerDataBase == null) {
                    playerDataBase = new DataBase();
                }

            }

        }
        return playerDataBase;
    }

    public List<Player> getPlayers() {
        ArrayList<Player> players1 = new ArrayList<>();
        players1.addAll(players);
        System.out.println(players1.isEmpty());
        System.out.println(players.isEmpty());
        return players1;
    }

    public Map<String, Integer> getScoreBoard() {
        return scoreBoard;
    }

    public void sampleDataBase() {

        try {

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

    public void loadScoreBoard() {
        try {
            Session s = session.openSession();

            s.beginTransaction();

            Query query = s.createQuery("FROM Player");

            for (Iterator iterator = query.list().iterator(); iterator.hasNext(); ) {
                Object o = iterator.next();
                players.add((Player) o);
                scoreBoard.put(((Player) o).getNickName(), ((Player) o).getMaxRecord());
            }
            s.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPlayer(Player player) {

        try {
            Session s = session.openSession();

            s.beginTransaction();

            s.persist(player);

            s.getTransaction().commit();

        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
    public Player loginAllowed(String login, String password) {
        boolean isAllowed = false;
        try {
            Session s = session.openSession();
            s.beginTransaction();
            Criteria cr = null;
            cr = s.createCriteria(Player.class);
            cr.add(Restrictions.eq("login",login));
            cr.add(Restrictions.eq("password",password));

            Object o= cr.setProjection(Projections.rowCount()).uniqueResult();
            activePlayer = (Player)o;
            System.out.println(activePlayer.toString());
//            Query<Player> query = s.createQuery("FROM Player WHERE login = " + login + " , password = " + password);
//            activePlayer = query.getSingleResult();
            if(!activePlayer.equals(null)){
                isAllowed = true;

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return activePlayer;

    }

    public Player findPlayer(String login, String password) {
        Player temp = null;
        Session s = session.openSession();
        Transaction tx = s.beginTransaction();
        Query query = s.createQuery("from Player where login=:login and password=:password");
        query.setParameter("login",login);
        query.setParameter("password", password);

        temp = (Player) query.uniqueResult();
        activePlayer = temp;
        return temp;

    }

}



