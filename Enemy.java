import java.util.ArrayList;

public class Enemy extends Combatant{
    static int enemiesRemaining = 0;
    static ArrayList<Enemy> enemies = new ArrayList<>();

    Enemy(){
        enemiesRemaining += 1;
        String name = "Enemy " +enemiesRemaining;
        super(8, name);
        enemies.add(this);
    }

    void takeTurn(){
        Combatant current = this.next;
        System.out.println("It is " + this + " turn");
        Player target = Player.getPlayers().get(0);
        attack(target);
    }

    void attack(Player player){
        System.out.println(this + " attacks " + player);
        player.takeDamage(3);
        int playerHP = player.getHP();
        if(playerHP>0){
            System.out.println(player + " took 3 damage and has " + player.getHP() + "HP left");
        } 
    }

    void die(){
        enemiesRemaining -= 1;
        System.out.println(this + " died");
        this.remove();
        enemies.remove(this);
    }

    public static ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public static int enemiesRemaining(){
        return enemiesRemaining;
    }
}