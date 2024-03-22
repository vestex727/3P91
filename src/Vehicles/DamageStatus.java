package Vehicles;

import java.util.ArrayList;
import java.util.Random;

public class DamageStatus extends Vehicle{

    private Double currentStatus;
    private ArrayList<Double> sufferedDamageHistory;
    private ArrayList<Double> generatedDamageHistory;

    public Double getCurrentDamageStatus(){
        return currentStatus;
    }

    public Double updateDamageStatus(Double damage){
        currentStatus += damage;
        return currentStatus;
    }

    public void calculateSufferedDamage(Vehicle otherVehicle){
        Random rand = new Random();
        Double speed = otherVehicle.getMovementStatus().getSpeed();
        Double weight = otherVehicle.getWeight();
        int diceRoll = rand.nextInt(6) + 1;
        int c = 5;
        Double sufferedDamage = speed*weight*((currentStatus+0.1)/c)*(1+(diceRoll/6));
        updateDamageStatus(sufferedDamage);
    }

    public void calculateGeneratedDamage(Vehicle otherVehicle) {
        Random rand = new Random();
        Double speed = this.getMovementStatus().getSpeed();
        Double weight = this.getWeight();
        int diceRoll = rand.nextInt(6) + 1;
        int c = 5;
        Double sufferedDamage = speed*weight*((currentStatus+0.1)/c)*(1+(diceRoll/6));
        otherVehicle.getDamageStatus().updateDamageStatus(sufferedDamage);
    }

    public ArrayList<Double> addSufferedDamage(Double damage){
        sufferedDamageHistory.add(damage);
        return sufferedDamageHistory;
    }

    public ArrayList<Double> addGeneratedDamage(Double damage){
        generatedDamageHistory.add(damage);
        return generatedDamageHistory;
    }
}
