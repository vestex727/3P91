package Map;

import java.util.ArrayList;

public class RoadSegment {
    private ArrayList<Lane> lanes;
    //private ArrayList<Intersection> intersections;


    RoadSegment(ArrayList<Lane> laneList, ArrayList<Intersection> intersectionList){
        lanes = laneList;
        //intersections = intersectionList;
    }

    public ArrayList<Lane> getLanes(){return lanes;}
    //public ArrayList<Intersection> getIntersections(){return intersections;}
}
