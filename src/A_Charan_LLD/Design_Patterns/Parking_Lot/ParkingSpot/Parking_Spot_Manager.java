package A_Charan_LLD.Design_Patterns.Parking_Lot.ParkingSpot;

public interface Parking_Spot_Manager <T extends Parking_Spot>{

    void add(T parkingSpot);
    void remove(T parkingSpot);
    int find();
    void park(int spotNumber);
    void removePark(int spotNumber);
}
