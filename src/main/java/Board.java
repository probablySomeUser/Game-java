import java.util.ArrayList;
public class Board{
    public Tile[][] board = new Tile[21][21];
    
    private class Tile{
        private boolean occupied;
        private ArrayList<Combatant> occupants;

        Tile(){
            this.occupied = false;
            this.occupants = new ArrayList<Combatant>();
        }

        public boolean getOccupied(){
            return this.occupied;

        }
        
        public void addOccupant(Combatant occupant){
            occupants.add(occupant);
            occupied = true;
        }

        public void removeOccupant(Combatant occupant){
            occupants.remove(occupant);
            if(occupants.size()==0){
                occupied = false;
            }
        }
    }

    public Board(){
        
    }

    private void createTile(int[] coordinate){
        int[] newCoordinate = new int[2];
        newCoordinate[0] = coordinate[0]+10;
        newCoordinate[1] = coordinate[1]+10;
        if(board[newCoordinate[0]][newCoordinate[1]]==null){
            board[newCoordinate[0]][newCoordinate[1]] = new Tile();
        }

    }

    private Tile getTile(int[] coordinate){
        return board[coordinate[0]+10][coordinate[1]+10];
    }

    public void addCombatant(Combatant combatant, int[] coordinate){
        createTile(coordinate);
        Tile tile = getTile(coordinate);
        tile.addOccupant(combatant);
    }

    public void removeOccupant(Combatant combatant, int[] coordinate){
        Tile tile = getTile(coordinate);
        tile.removeOccupant(combatant);
    }

    public boolean isOccupied(int[] coordinate){
        createTile(coordinate);
        return getTile(coordinate).getOccupied();
    }
}