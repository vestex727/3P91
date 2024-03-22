package Map;

/**Coordinate object
 * Stores an x and y value as integers
 */
public class Coordinates implements Comparable<Coordinates>{
    public int x;
    public int y;

    @Override
    public int compareTo(Coordinates o) {
        if(this.x == o.x && this.y == o.y) return 1;
        return 0;
    }

    public boolean isEqual(Coordinates o){
        if(this.x == o.x && this.y == o.y) return true;
        return false;
    }

}
