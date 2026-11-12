public class Combatant{
    private int HP;
    protected  boolean isAlive=true;
    protected  Combatant prev=null;
    protected Combatant next=null;
    private String name;
    private double[] position;
    protected static Board board;

    static boolean orderTied = false;
    static Combatant head;
    static Combatant tail;

    public static void setBoard(Board newBoard){
        board = newBoard;
    }

    public void setPrev(Combatant prev){
        this.prev = prev;
    }

    public void setNext(Combatant next){
        this.next = next;
    }

    public Combatant getNext(){
        return this.next;
    }

    public void remove(){
        prev.next = this.next;
        next.prev = this.prev;
    }

    public static void addToOrder(Combatant addition){
        if(head==null){
            head = addition;
            tail = addition;
        } else{
            if(!orderTied){
                Combatant oldTail = tail;
                addition.prev = oldTail;
                oldTail.next = addition;
                tail = addition;
            }

        }
    }

    public static void tieOrder(){
        if(tail==null || orderTied){
            return;
        } else{
            head.prev = tail;
            tail.next = head;
            orderTied = true;
        }

    }

    public static Combatant getHead(){
        return head;
    }


    Combatant(int HP,String name){
        this.HP = HP;
        this.name = name;
        this.isAlive = true;
    }

    public void setPosition(double[] newPosition){
        this.position = newPosition;
    }

    public double[] getPosition(){
        return this.position;
    }

    protected void spawnPosition(int xStart,int yStart){
        int x = xStart;
        int y = xStart;
        boolean lever = false;
        int[] start = {x,y};
        while(board.isOccupied(start)){
            if (!lever) {
                x++;
                if(x % 21 == 0){
                    lever = true;
                    x %= 21;
                }
            } else{
                y++;
                if(y % 21 == 0){
                    lever = false;
                    y %= 21;
                }
            }
        }
        int[] integerPosition = {Utils.moduloRepresentative(x, -10, 10),Utils.moduloRepresentative(y,-10, 10)};
        this.board.addCombatant(this, integerPosition);
        double xPos = Utils.moduloRepresentative(x, -10, 10);
        double yPos = Utils.moduloRepresentative(y, -10, 10);
        double[] temp = {xPos,yPos};
        this.position = temp;
        
    }

    protected void spawnPosition(){
        spawnPosition(0, 0);
    }

    public void takeDamage(int amount){
        this.HP -= amount;
        if(this.HP<=0){
            die();
        }
    }


    public int getHP(){
        return this.HP;
    }

    public String toString(){
        return this.name;
    }

    public void takeTurn(){
        // Will be overridden in subclasses
    }

    public void die(){
        // Will be overriden in subclasses
    }
}