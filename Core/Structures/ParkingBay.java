package Core.Structures;

public class ParkingBay {

    public final int bayID;
    private Long checkedInAt;
    private String allocatedTo;
    private boolean isVacant;

    public ParkingBay(int bayID) {
        this.bayID = bayID;
        this.checkedInAt = null;
        this.allocatedTo = null;
        this.isVacant = true;
    }

    public String getAllocatedTo() {
        return this.allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
        this.isVacant = false;
        this.checkedInAt = System.currentTimeMillis();
    }

    public void deAllocate() {
        this.allocatedTo = null;
        this.isVacant = true;
        this.checkedInAt = null;
    }

    public boolean isVacant() {
        return this.isVacant;
    }

    public long getCheckedInAt() {
        return this.checkedInAt;
    }

    @Override
    public String toString() {
        return "bayID: " + this.bayID + "\ncheckedInAt: " + this.checkedInAt +
                "\nallocatedTo: " + this.allocatedTo + "\nisVacant: " + this.isVacant;
    }
}
