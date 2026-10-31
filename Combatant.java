public class Combatant{
    int HP;
    boolean isAlive=true;
    Combatant prev=null;
    Combatant next=null;
    String name;
    double[] position = {0,0};
    static boolean orderTied = false;
    static Combatant head;
    static Combatant tail;

    void setPrev(Combatant prev){
        this.prev = prev;
    }

    void setNext(Combatant next){
        this.next = next;
    }

    Combatant getNext(){
        return this.next;
    }

    void remove(){
        prev.next = this.next;
        next.prev = this.prev;
    }

    static void addToOrder(Combatant addition){
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

    static void tieOrder(){
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

    void takeTurn(){
        // Will be overridden in subclasses
    }

    void die(){
        // Will be overriden in subclasses
    }
}