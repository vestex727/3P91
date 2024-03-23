package Vehicles;

public class VehicleType {
    public VehicleName name; //Type of vehicle (car, bus, truck)
    public float length;    //Length of Vehicle

    /**Constructor for vehicle type
     *

     @param vn
     @param l*/
    VehicleType(VehicleName vn, float l){
        name = vn;
        length = l;}

    public void setName(VehicleName vn){this.name = vn;}
    public void setLength(float l){this.length = l;}
}
