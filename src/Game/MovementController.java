package Game;

//Movement Controller for all vehicles in the game.

/*@Version 1.0 (Date: March 3rd, 2024)
@Author Steve Mastrokalos */

        import Map.Position;
        import Map.TrafficElement;
        import Map.TrafficNetwork;
        import Vehicles.Vehicle;

        import java.util.ArrayList;

public interface MovementController {

    /*Updates the positions of all vehicles in the traffic network

    @param trafficNetwork The network that all vehicles are in
    @param vehicles  The vehicles that will get updated
    @return  Updated Vehicle states*/
    ArrayList<Vehicle> UpdateVehiclePosition(TrafficNetwork trafficNetwork, ArrayList<Vehicle> vehicles);

    /*Checks region a given vehicle is in

    @param vehicle   Vehicle the region is being checked for
    @param vehicles  List of all vehicles
    @return*/
    ArrayList<Vehicle> checkRegion(Vehicle vehicle, ArrayList<Vehicle> vehicles);

    /* Validates a vehicle can move into a new location before it's position is updated

    @param vehicle   Vehicle to verify the movements of
    @param newPosition   Position it is trying to move to
    @return  Position after check     */
    Position validateMoveChoice(Vehicle vehicle, Position newPosition);

    /** Probes the area surrounding a vehicle and returns all traffic elements "in sight"
     *

     @param vehicle   Vehicle to probe for
     @return List of traffic elements in the vehicles surroundings*/
    ArrayList<TrafficElement> probeMapSurroundings(Vehicle vehicle);

}
