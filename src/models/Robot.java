package models;

public class Robot {
    private String robotId;
    private String status; // "Available", "Picking", "Delivering"

    public Robot(String robotId) {
        this.robotId = robotId;
        this.status = "Available";
    }

    public String getRobotId() { return robotId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Robot " + robotId + " [Status: " + status + "]";
    }
}
