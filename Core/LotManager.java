package Core;

import java.util.ArrayList;

public class LotManager {

    private static LotManager classInstance;
    private int currentCount = 0;
    private final ArrayList<ParkingBay> bays;

    public static LotManager getInstance(ParkingLot lot) {
        if (LotManager.classInstance.equals(null)) {
            LotManager.classInstance = new LotManager(lot);
            return LotManager.classInstance;

        } else {
            return LotManager.classInstance;
        }
    }

    private LotManager(ParkingLot lot) {
        this.bays = lot.getBays();

        for (int i = 0; i < lot.getBaySize(); i++) {
            this.bays.add(new ParkingBay(this.generateBayID()));
        }
    }

    public void allocate(String carNumber) {
        ParkingBay bay = this.findVacantBay();
        if (bay.equals(null)) {
            System.out.println("Sorry, we are full!");

        } else {
            bay.setAllocatedTo(carNumber);
            System.out.println("Vehicle " + carNumber + " was successfully allocated to bay " + bay.bayID);
        }

    }

    public void deAllocate(String carNumber) {
        ParkingBay bay = this.findBayByCarnumber(carNumber);
        if (bay.equals(null)) {
            System.out.println("Unknown bay! Please check the car number and try again");

        } else {
            bay.deAllocate();
            System.out.println("Vehicle " + carNumber + " was deallocated from bay " + bay.bayID);
        }
    }

    public int generateBayID() {
        return this.currentCount++;
    }

    private ParkingBay findBayByCarnumber(String carNumber) {
        ParkingBay bay = null;

        for (int i = 0; i < bays.size(); i++) {
            if (carNumber.equals(bays.get(i).getAllocatedTo())) {
                bay = bays.get(i);
                break;
            }
        }

        return bay;
    }

    private ParkingBay findVacantBay() {
        ParkingBay bay = null;

        for (int i = 0; i < bays.size(); i++) {
            if (bays.get(i).isVacant()) {
                bay = bays.get(i);
                break;
            }
        }

        return bay;
    }
}
