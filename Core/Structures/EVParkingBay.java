package Core.Structures;

public class EVParkingBay extends ParkingBay {
    private boolean isCharging;

    public EVParkingBay(int bayID) {
        super(bayID);
        this.isCharging = false;
    }

    public boolean isCharging() {
        return this.isCharging;
    }

    public void activateCharger() {
        if (!this.isCharging) {
            this.isCharging = true;
        }
    }

    public void deactivateCharger() {
        if (this.isCharging) {
            this.isCharging = false;
        }
    }
}
