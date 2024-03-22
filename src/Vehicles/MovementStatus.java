package Vehicles;
import Map.Position;
import Map.Direction;

public class MovementStatus {

    private Position position;
    private Double speed;
    private Direction direction;

    public Double getSpeed(){
        return speed;
    }

    public Position getPosition(){ return position; }

    public Direction getDirection(){ return direction; }
}
