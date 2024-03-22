package Map;

import java.util.ArrayList;

import static Map.TrafficElementType.INTERSECTION;

public class Intersection extends TrafficElement {
    ArrayList<RoadSegment> roadList;
    ArrayList<Lane> connectingTo;
    ArrayList<Lane> connectingFrom;

    Intersection(Coordinates pos, ArrayList<RoadSegment> roads){
        super(pos, INTERSECTION);
        roadList = roads;
    }

    public ArrayList<RoadSegment> getRoadList(){return roadList;}

    /**Adds a road to the list of roads in the intersection
     *
     * @param road
     * @return
     */
    public ArrayList<RoadSegment> addRoadSegment(RoadSegment road){
        roadList.add(road);
        return roadList;
    }

    public ArrayList<Lane> getConnectingTo(){return connectingTo;}
    public ArrayList<Lane> getConnectingFrom(){return connectingFrom;}


}
