package Map;

import Vehicles.Vehicle;

import java.util.Queue;

public class TrafficElement {
    private Coordinates coords;
    public TrafficElementType type;
    public Queue<Vehicle> vehiclesOnRoad;
    private String id;

    TrafficElement(Coordinates pos, TrafficElementType t){coords = pos;}

    public Coordinates getCoords(){return coords;}

    public String getId(){return id;}
}
