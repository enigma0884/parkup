import Core.LotManager;
import Core.ParkingLot;
import Core.Enums.BayTypes;

// This class is just used for testing as of now and is subject to change

public class App {
    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();
        LotManager manager = LotManager.getInstance(lot);

        manager.allocate("KA02JY7179", BayTypes.REGULAR);
        System.out.println("----");
        manager.allocate("KA02JY7179", BayTypes.REGULAR);
    }
}
