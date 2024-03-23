package Game;

import Map.*;
import Vehicles.Reputation;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class ChallengeHandler {

    public void runChallenge(Vehicle vehicle, TrafficNetwork trafficNetwork){
        ArrayList<Vehicle> neighbours = findNeighbours(vehicle);
        //generates random value between zero and one
        double random = Math.random();
        //challenges become more likely the more vehicles are on a traffic element, but never guaranteed
        if(random <= (1-(1/((float)(neighbours.size()+1))))){
            Random rand = new Random();
            int otherV = rand.nextInt(neighbours.size());
            Vehicle otherVehicle = neighbours.get(otherV);
            //rep1 is always the larger number
            double rep1 = 0;
            double rep2 = 0;
            Vehicle winner;
            Vehicle loser;
            if(vehicle.getReputation().getReputation() >= otherVehicle.getReputation().getReputation()){
                rep1 = vehicle.getReputation().getReputation();
                rep2 = otherVehicle.getReputation().getReputation();
                double repDifference = rep1 - rep2;
                double random2 = Math.random();
                if(random <= (1-(1/((float)(repDifference+2))))){
                    winner = vehicle;
                    loser = otherVehicle;
                } else{
                    loser = vehicle;
                    winner = otherVehicle;
                }
            } else {
                rep2 = vehicle.getReputation().getReputation();
                rep1 = otherVehicle.getReputation().getReputation();
                double repDifference = rep1 - rep2;
                double random2 = Math.random();
                if(random <= (1-(1/((float)(repDifference+2))))){
                    loser = vehicle;
                    winner = otherVehicle;
                } else{
                    winner = vehicle;
                    loser = otherVehicle;
                }
            }
            //adds rep to winner and penalizes loser
            winner.getReputation().updateReputation(winner.getReputation().getReputation()+0.1);
            loser.getReputation().updateReputation(loser.getReputation().getReputation()-0.1);
            loser.getDamageStatus().calculateSufferedDamage(winner);
            winner.getDamageStatus().calculateGeneratedDamage(loser);
        }
    }

    private ArrayList<Vehicle> findNeighbours(Vehicle vehicle){
        ArrayList<Vehicle> allVehicles = Game.GameEngine.getVehicles();
        ArrayList<Vehicle> v = new ArrayList<>();
        Coordinates c = vehicle.getMovementStatus().getPosition().coords;
        //returns all other vehicles on the same element
        for(int i = 0; i < allVehicles.size(); i++){
            if(allVehicles.get(i).getMovementStatus().getPosition().coords.isEqual(c) && allVehicles.get(i) != vehicle){
                v.add(allVehicles.get(i));
            }
        }
        return v;
    }
}
