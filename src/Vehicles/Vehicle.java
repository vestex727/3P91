package Vehicles;

import Map.TrafficElement;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Vehicle {

    private MovementStatus movementStatus;
    private String color;
    private Double size;
    private Double weight;
    private Double maxSpeed;
    private Reputation reputation;
    private DamageStatus damageStatus;
    private VehicleType type;
    private Stack<TrafficElement> history;

    public void move(){

    }

    public Double getWeight(){
        return weight;
    }

    public DamageStatus getDamageStatus(){
        return damageStatus;
    }

    public MovementStatus getMovementStatus(){
        return movementStatus;
    }

    public Stack<TrafficElement> getHistory(){return history;}
}
