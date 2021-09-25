import java.awt.EventQueue;

public class Main {

    public static void main(String [] args) {
        DataBase db = DataBase.getPlayerDataBase();
        System.out.println(db.getScoreBoard().isEmpty());

        for(String key : db.getScoreBoard().keySet())
            System.out.println(key + " " + db.getScoreBoard().get(key));

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrameWelcome welcomeWindow = new FrameWelcome(new PanelWelcome());

            }

        });
    }
}

//SPRAWDZAM CZY DZIALA EDYCJA - BARTEK P.