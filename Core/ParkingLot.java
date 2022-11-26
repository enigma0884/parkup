package Core;

import java.util.ArrayList;

import Core.Structures.ParkingBay;
import Core.Structures.EVParkingBay;

public class ParkingLot {

    private final ArrayList<ParkingBay> bays;
    private int currentCount = 0;

    private static final int normalBays = 10;
    private static final int EVBays = 10;
    private static ParkingLot classInstance;

    public static ParkingLot getInstance() {
        if (ParkingLot.classInstance == null) {
            ParkingLot.classInstance = new ParkingLot();
        }
        return ParkingLot.classInstance;
    }

    private ParkingLot() {
        this.bays = new ArrayList<>(ParkingLot.normalBays + ParkingLot.EVBays);

        for (int i = 0; i < ParkingLot.normalBays; i++) {
            this.bays.add(new ParkingBay(this.generateBayID()));
        }

        for (int i = 0; i < ParkingLot.EVBays; i++) {
            this.bays.add(new EVParkingBay(this.generateBayID()));
        }
    }

    public ArrayList<ParkingBay> getBays() {
        // We do not want to allow external classes to modify the bays in the ParkingLot
        return new ArrayList<>(this.bays);
    }

    public void allocate(String vehicleNumber, int bayID) {
        ParkingBay bay = null;
        // TODO Use a hashmap to avoid this
        // P.S - haven't played around with it yet

        for (int i = 0; i < this.bays.size(); i++) {
            if (this.bays.get(i).bayID == bayID) {
                bay = this.bays.get(i);
            }
        }

        bay.setAllocatedTo(vehicleNumber);
        System.out.println("Vehicle " + vehicleNumber + " was allocated to bay " + bay.bayID);
    }

    public void deAllocate(int bayID) {
        ParkingBay bay = null;
        // TODO Use a hashmap to avoid this
        // P.S - haven't played around with it yet

        for (int i = 0; i < this.bays.size(); i++) {
            if (this.bays.get(i).bayID == bayID) {
                bay = this.bays.get(i);
            }
        }

        bay.deAllocate();
        System.out.println("Bay " + bay.bayID + " was deallocated");
    }

    private int generateBayID() {
        return this.currentCount++;
    }
}
