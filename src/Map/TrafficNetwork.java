package Map;

import Game.GameEngine;
import Vehicles.Vehicle;

import java.util.ArrayList;

public class TrafficNetwork {
    public static ArrayList<RoadSegment> roads;
    public static ArrayList<Intersection> intersections;

    /**Finds and returns the number of vehicles in a road segment
     *
     * @param roadSegment
     * @return
     */
    Integer checkNumberOfVehiclesInSegment(RoadSegment roadSegment){
        ArrayList<Lane> lanes = roadSegment.getLanes();
        int counter = 0;
        for(int i = 0; i < lanes.size(); i++){
            counter += checkNumberOfVehiclesInLane(lanes.get(i));
        }
        return counter;
    }


    Integer checkNumberOfVehiclesInLane(Lane lane){
        ArrayList<Vehicle> v = Game.GameEngine.getVehicles();
        Coordinates c = lane.getCoords();
        int counter = 0;
        for(int i = 0; i < v.size(); i++){
            if(v.get(i).getMovementStatus().getPosition().coords.isEqual(c)){
                counter++;
            }
        }
        return counter;
    }


    Integer checkNumberOfVehiclesAtIntersection(Intersection intersection){return null;}


    Integer checkNumberOfVehiclesInIntersection(Intersection intersection){
        ArrayList<Vehicle> v = Game.GameEngine.getVehicles();
        Coordinates c = intersection.getCoords();
        int counter = 0;

        for(int i = 0; i < v.size(); i++){
            if(v.get(i).getMovementStatus().getPosition().coords.isEqual(c)){
                counter++;
            }
        }
        return counter;
    }


}
