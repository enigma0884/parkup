package Core;

import java.util.ArrayList;

public class ParkingLot {

    private static ParkingLot classInstance;
    private final ArrayList<ParkingBay> bays;
    private final int baySize;

    public static ParkingLot getInstance(int baySize) {
        if (ParkingLot.classInstance.equals(null)) {
            ParkingLot.classInstance = new ParkingLot(baySize);
            return ParkingLot.classInstance;

        } else {
            return ParkingLot.classInstance;
        }
    }

    private ParkingLot(int baySize) {
        this.baySize = baySize;
        this.bays = new ArrayList<>(this.baySize);
    }

    public ArrayList<ParkingBay> getBays() {
        return this.bays;
    }

    public int getBaySize() {
        return this.baySize;
    }
}
