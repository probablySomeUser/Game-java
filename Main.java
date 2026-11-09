public class Main{
    public static void runGame(){
        // set up game
        Combatant starter = setUpGame();

        //Main gameplay loop
        String winner = mainLoop(starter);

        //end game
        endGame(winner);

    }

    static Combatant setUpGame(){
        Board board = new Board();
        Combatant.setBoard(board);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();
        Combatant.addToOrder(player1);
        Combatant.addToOrder(enemy1);
        Combatant.addToOrder(player2);
        Combatant.addToOrder(enemy2);
        Combatant.tieOrder();
        return Combatant.head;
    }

    static String mainLoop(Combatant starter){
        Combatant currentCombatant = starter;
        while (Player.playersRemaining() != 0 && Enemy.enemiesRemaining() != 0) {
            currentCombatant.takeTurn();
            currentCombatant = currentCombatant.getNext();
        }
        if(Enemy.enemiesRemaining == 0){
            return "The players";
        } else{
            return "The enemies";
        }
    }

    static void endGame(String winner){
        System.out.println(winner + " wins");
    }

    void addToOrder(Combatant latest){
        
    }
    public static void main(){
        runGame();
    }
}