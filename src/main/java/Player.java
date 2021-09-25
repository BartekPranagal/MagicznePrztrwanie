import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Players")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String nickName;
    @Column
    private int score;
    @Column
    private int maxRecord;

    public Player () {

    }

    public Player(String firstName, String lastName, String login, String password, String nickName, int score, int maxRecord) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.nickName = nickName;
        this.score = score;
        this.maxRecord = maxRecord;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getMaxRecord() {
        return maxRecord;
    }
    public void setMaxRecord(int maxRecord) {
        this.maxRecord = maxRecord;
    }
    @Override
    public String toString() {
        return "Player [nickName=" + nickName + ", maxRecord=" + maxRecord + "]";
    }





}


