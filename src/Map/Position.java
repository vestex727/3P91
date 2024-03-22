package Map;

public class Position {
    public Coordinates coords;
    TrafficElement trafficElement;

    Position(Coordinates pos, TrafficElement element){
        coords = pos;
        trafficElement = element;
    }

    public Coordinates getCoords(){return coords;}
    public void setCoords(Coordinates newCoords){
        this.coords = newCoords;
    }
    public TrafficElement getTrafficElement(){return trafficElement;}
}
