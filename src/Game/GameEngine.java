package Game;

import Map.*;
import Vehicles.Player;
import Vehicles.Vehicle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import Map.TrafficElement;

public class GameEngine implements MovementController{
    private TrafficNetwork trafficNetwork;
    private static ArrayList<Vehicle> vehicles;
    private Player player;
    private MovementController movementController;
    private ChallengeHandler challengeHandler;
    private int turnCount;

    public ArrayList<Vehicle> addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
        return vehicles;
    }

    public static ArrayList<Vehicle> getVehicles(){return vehicles;}


    private void updateSimulationTurn(){

    }

    private void promptPlayer(Vehicle vehicle){
        if(player.getVehicle().getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.LANE){
            System.out.print("You are currently at Lane ");
        }
        if(player.getVehicle().getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.INTERSECTION){
            System.out.print("You are currently at Intersection ");
        }
        System.out.print(player.getVehicle().getMovementStatus().getPosition().getCoords().x);
        System.out.print(", ");
        System.out.print(player.getVehicle().getMovementStatus().getPosition().getCoords().y);
        //gets array of all directions the player can go next turn
        ArrayList<TrafficElement> trafficElements = probeMapSurroundings(vehicle);
        ArrayList<Direction> directions = new ArrayList<Direction>();
        if(player.getVehicle().getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.INTERSECTION){
            for(int i = 0; i < trafficElements.size(); i++){
                Lane temp = (Lane) trafficElements.get(i);
                directions.add(temp.getDirection());
            }
            System.out.print("Which direction would you like to turn?");
            for(int i = 0; i < directions.size(); i++){

            }
        }
        if(player.getVehicle().getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.LANE){

        }
    }

    @Override
    public ArrayList<Vehicle> UpdateVehiclePosition(TrafficNetwork trafficNetwork, ArrayList<Vehicle> vehicles) {
        ArrayList<Intersection> x = trafficNetwork.intersections;
        ArrayList<RoadSegment> r = trafficNetwork.roads;
        for(int i = 0; i < x.size(); i++){
            //dequeue vehicle from intersection
            Vehicle v = x.get(i).vehiclesOnRoad.remove();
            //select a road for the vehicle to be moved to based on its current direction
            ArrayList<Lane> connectedLanes = x.get(i).getConnectingTo();
            Lane temp = null;
            for(int j = 0; j < connectedLanes.size(); j++) {
                //selects lane in the same direction as the vehicle with the fewest number of vehicles on it
                if (connectedLanes.get(j).getDirection().equals(v.getMovementStatus().getDirection()) &&
                        (connectedLanes.get(j).vehiclesOnRoad.size() < temp.vehiclesOnRoad.size() || (temp == null))) {
                    temp = connectedLanes.get(j);
                }
            }
            //get new coords and assign them to vehicle
            Coordinates c = temp.getCoords();
            v.getMovementStatus().getPosition().setCoords(c);
            //enqueue vehicle to new position
            temp.vehiclesOnRoad.add(v);
        }
        for(int i = 0; i < r.size(); i++){
            int size = r.get(i).getLanes().size();
            for(int j = 0; j < size; j++){
                //dequeue vehicles from lanes
                Vehicle v = r.get(i).getLanes().get(j).vehiclesOnRoad.remove();
                //select the connecting traffic element
                TrafficElement temp = r.get(i).getLanes().get(j).getConnectingTo();
                //get new coords and assign them to vehicle
                Coordinates c = temp.getCoords();
                v.getMovementStatus().getPosition().setCoords(c);
                //enqueue vehicle to new position
                temp.vehiclesOnRoad.add(v);
            }
        }
        return vehicles;
    }

    @Override
    public ArrayList<Vehicle> checkRegion(Vehicle vehicle, ArrayList<Vehicle> vehicles) {
        ArrayList<Vehicle> surroundingVehicles = new ArrayList<Vehicle>();
        Coordinates coords = vehicle.getMovementStatus().getPosition().getCoords();
        //returns all othervehicles at the same coordinates as vehicle passed
        for(int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i).getMovementStatus().getPosition().getCoords().equals(coords)){
                surroundingVehicles.add(vehicles.get(i));
            }
        }
        return surroundingVehicles;
    }

    @Override
    public Position validateMoveChoice(Vehicle vehicle, Position newPosition) {
        return newPosition;
    } //only relevant for multiplayer

    @Override
    public ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle) {
        ArrayList<TrafficElement> trafficElements = new ArrayList<TrafficElement>();
        //returns all adjacent lanes with the same direction
        if(vehicle.getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.LANE){
            Lane ln = (Lane) vehicle.getMovementStatus().getPosition().getTrafficElement();
            Direction dir = vehicle.getMovementStatus().getDirection();
            for(int i = 0; i < trafficNetwork.roads.size(); i++){
                for(int j = 0; j < trafficNetwork.roads.get(i).getLanes().size(); j++){
                    if(trafficNetwork.roads.get(i).getLanes().get(j).equals(ln)){
                        for(int k = 0; k < trafficNetwork.roads.get(i).getLanes().size(); k++){
                            if(trafficNetwork.roads.get(i).getLanes().get(k).getDirection().equals(dir)){
                                trafficElements.add(trafficNetwork.roads.get(i).getLanes().get(k));
                            }
                        }
                    }
                }
            }
        }
        //returns all connecting roads
        if(vehicle.getMovementStatus().getPosition().getTrafficElement().type == TrafficElementType.INTERSECTION){
            Intersection intsec = (Intersection) vehicle.getMovementStatus().getPosition().getTrafficElement();
            for(int i = 0; i < intsec.getConnectingTo().size(); i++){
                trafficElements.add(intsec.getConnectingTo().get(i));
            }
        }
        return trafficElements;
    }
}
