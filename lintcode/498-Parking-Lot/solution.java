// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
}

class Motorcycle extends Vehicle {
    // Write your code here
}

class Car extends Vehicle {
    // Write your code here
}

class Bus extends Vehicle {
    // Write your code here
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
}

public class ParkingLot {
    
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
    }
}