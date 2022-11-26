package Core;

import java.util.ArrayList;

import Core.Enums.BayTypes;
import Core.Structures.EVParkingBay;
import Core.Structures.ParkingBay;

public class LotManager {

    private static LotManager classInstance;
    private final ParkingLot lot;

    public static LotManager getInstance(ParkingLot lot) {
        if (LotManager.classInstance == null) {
            LotManager.classInstance = new LotManager(lot);
        }

        return LotManager.classInstance;
    }

    private LotManager(ParkingLot lot) {
        this.lot = lot;
    }

    public void allocate(String vehicleNumber, BayTypes type) {
        ParkingBay existingBay = this.findBayByVehicleNumber(vehicleNumber);

        if (existingBay != null) {
            System.out.println("Vechile " + vehicleNumber + " has already been allocated to bay " + existingBay.bayID);
            return;
        }

        ParkingBay emptyBay = this.findVacantBay(type);
        if (emptyBay == null) {
            System.out.println("Sorry, we are full!");
            return;
        }

        this.lot.allocate(vehicleNumber, emptyBay.bayID);
    }

    public void deAllocate(String vehicleNumber) {
        ParkingBay bay = this.findBayByVehicleNumber(vehicleNumber);
        if (bay == null) {
            System.out.println("Vehicle " + vehicleNumber + " has not been allocated to any bay");
            return;
        }

        this.lot.deAllocate(bay.bayID);
    }

    private ParkingBay findBayByVehicleNumber(String vehicleNumber) {
        ParkingBay bay = null;
        ArrayList<ParkingBay> bays = this.lot.getBays();

        for (int i = 0; i < bays.size(); i++) {
            if (vehicleNumber == bays.get(i).getAllocatedTo()) {
                bay = bays.get(i);
                break;
            }
        }

        return bay;
    }

    private ParkingBay findVacantBay(BayTypes type) {
        ParkingBay bay = null;
        ArrayList<ParkingBay> bays = this.lot.getBays();

        switch (type) {
            case REGULAR: {
                bays.removeIf(b -> (b instanceof EVParkingBay));
                break;
            }

            case EV: {
                bays.removeIf(b -> (b instanceof ParkingBay));
                break;
            }
        }

        for (int i = 0; i < bays.size(); i++) {
            if (bays.get(i).isVacant()) {
                bay = bays.get(i);
                break;
            }
        }

        return bay;
    }
}
