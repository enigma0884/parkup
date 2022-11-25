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

    public void allocate(String vehicleNumber) {
        ParkingBay existingBay = this.findBayByVehicleNumber(vehicleNumber);

        if (!existingBay.equals(null)) {
            System.out.println("Vechile " + vehicleNumber + " has already been allocated to bay " + existingBay.bayID);
            return;
        }

        ParkingBay emptyBay = this.findVacantBay();
        if (emptyBay.equals(null)) {
            System.out.println("Sorry, we are full!");

        } else {
            emptyBay.setAllocatedTo(vehicleNumber);
            System.out.println("Vehicle " + vehicleNumber + " was successfully allocated to bay " + emptyBay.bayID);
        }
    }

    public void deAllocate(String vehicleNumber) {
        ParkingBay bay = this.findBayByVehicleNumber(vehicleNumber);
        if (bay.equals(null)) {
            System.out.println("Vehicle " + vehicleNumber + " has not been allocated to any bay");

        } else {
            bay.deAllocate();
            System.out.println("Vehicle " + vehicleNumber + " was deallocated from bay " + bay.bayID);
        }
    }

    public int generateBayID() {
        return this.currentCount++;
    }

    private ParkingBay findBayByVehicleNumber(String vehicleNumber) {
        ParkingBay bay = null;

        for (int i = 0; i < bays.size(); i++) {
            if (vehicleNumber.equals(bays.get(i).getAllocatedTo())) {
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
