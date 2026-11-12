import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Combatant{
    private static Input input = new Input();
    private static int playersRemaining = 0;
    private static ArrayList<Player> players = new ArrayList<Player>();

    public static void setInput(Input reader){
        input = reader;
    }

    Player(String name){
        playersRemaining += 1;
        super(10,name);
        players.add(this);
        spawnPosition();
    }

    public void takeTurn(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("Attack someone");
        int optionChosen = input.getOption(options);
        switch(optionChosen) {
            case 0 ->{
            System.out.println("Who do you want to attack?");
            ArrayList<Enemy> enemies = Enemy.getEnemies();
            int victimNo = input.getOption(enemies);
            Enemy victim = enemies.get(victimNo);
            attack(victim);}
        }

        
    }

    private void attack(Enemy enemy){
        int damage = 3;
        enemy.takeDamage(damage);
    }

    public void die(){
        playersRemaining -= 1;
        this.remove();
        players.remove(this);
    }

    public static ArrayList<Player> getPlayers(){
        return players;
    }

    public static int playersRemaining(){
        return playersRemaining;
    }
}