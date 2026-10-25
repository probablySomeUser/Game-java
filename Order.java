public class Order{
    Node head=null;
    Node tail=null;
    boolean isTied = False;

    class Node{
        Node next;
        Node prev;
        Combatant content;

        Node(Node next,Node prev, Combatant content){
            this.next = next;
            this.prev = prev;
            this.content = content;
        }
    }
    void addCombatant(Combatant addition){
        if(this.tail == null){
            Node add = new Node(null, null, addition);
            this.head = add;
            this.tail = add;
        } else{ 
            if(!isTied){
                Node add = new Node(null,this.tail,addition);
                this.tail = add;
            } else{
                //Do this
            }

        }

    }

    void tieOrder(){
        if(this.head==null){
            return;
        } else{
            Node head = this.head;
            Node tail = this.tail;
            head.prev = tail;
            tail.next = next;
            isTied = True;
        }

    }

    Combatant getHead(){
        Combatant output = new Combatant(10,"Test");
        return output;
    }

    void remove(Node element){
        Node prev = element.prev;
        Node next = element.next;
        prev.next = next;
        next.prev = prev;
    }
}