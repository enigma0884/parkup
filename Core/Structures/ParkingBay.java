package Core.Structures;

public class ParkingBay {

    public final int bayID;
    private String allocatedTo;
    private boolean isVacant;

    public ParkingBay(int bayID) {
        this.bayID = bayID;
        this.allocatedTo = null;
        this.isVacant = true;
    }

    public String getAllocatedTo() {
        return this.allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
        this.isVacant = false;
    }

    public void deAllocate() {
        this.allocatedTo = null;
        this.isVacant = true;
    }

    public boolean isVacant() {
        return this.isVacant;
    }
}
