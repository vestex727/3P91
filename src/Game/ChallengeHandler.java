package Game;

import Map.Coordinates;
import Map.Intersection;
import Map.TrafficNetwork;
import Vehicles.Vehicle;

import java.util.ArrayList;

public class ChallengeHandler {

    public void runChallenge(Vehicle vehicle, TrafficNetwork trafficNetwork){
        ArrayList<Intersection> i = trafficNetwork.intersections;
    }

    private Vehicle findNeighbours(Vehicle vehicle){
        ArrayList<Vehicle> v = Game.GameEngine.getVehicles();
        Coordinates c = vehicle.getMovementStatus().getPosition().coords;
        for(int i = 0; i < v.size(); i++){
            if(v.get(i).getMovementStatus().getPosition().coords.isEqual(c) && v.get(i) != vehicle){
                return v.get(i);
            }
        }
        return null;
    }
}
