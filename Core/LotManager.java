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
        return this.lot.getBays()
                .stream()
                .filter(b -> b.getAllocatedTo() == vehicleNumber)
                .findFirst()
                .orElse(null);
    }

    private ParkingBay findVacantBay(BayTypes type) {
        ArrayList<ParkingBay> bays = this.lot.getBays();
        ParkingBay bay = null;

        switch (type) {
            case REGULAR: {
                bay = bays.stream()
                        .filter(b -> b instanceof ParkingBay && b.isVacant())
                        .findFirst()
                        .orElse(null);

            }

            case EV: {
                bay = bays.stream()
                        .filter(b -> b instanceof EVParkingBay && b.isVacant())
                        .findFirst()
                        .orElse(null);
            }
        }
        return bay;
    }
}
