package Map;

import Vehicles.Vehicle;

import java.util.Queue;

public class TrafficElement {
    private Coordinates coords;
    public TrafficElementType type;
    public Queue<Vehicle> vehiclesOnRoad;

    TrafficElement(Coordinates pos, TrafficElementType t){coords = pos;}

    public Coordinates getCoords(){return coords;}
}
