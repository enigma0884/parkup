package Core;

// TODO
// DisabledPeopleParkingBay, VIPParkingBay, EVParkingBay

public class ParkingBay {

    public final int bayID;
    private String allocatedTo;
    private BayStatus status;

    public ParkingBay(int bayID) {
        this.bayID = bayID;
        this.allocatedTo = null;
        this.status = BayStatus.VACANT;
    }

    public String getAllocatedTo() {
        return this.allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
        this.status = BayStatus.OCCUPIED;
    }

    public void deAllocate() {
        this.allocatedTo = null;
        this.status = BayStatus.VACANT;
    }

    public boolean isVacant() {
        return this.status.equals(BayStatus.VACANT);
    }
}
