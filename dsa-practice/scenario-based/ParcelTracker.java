public class ParcelTracker {
    // Node representing each delivery stage
    static class StageNode {
        String stage;
        StageNode next;
        StageNode(String stage) {
            this.stage = stage;
            this.next = null;
        }
    }
    private StageNode head;
    // Add stage at end
    public void addStage(String stage) {
        StageNode newNode = new StageNode(stage);
        if (head == null) {
            head = newNode;
            return;
        }
        StageNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // Add intermediate checkpoint after a given stage
    public void addCheckpoint(String afterStage, String newStage) {
        StageNode temp = head;
        while (temp != null) {
            if (temp.stage.equalsIgnoreCase(afterStage)) {
                StageNode node = new StageNode(newStage);
                node.next = temp.next;
                temp.next = node;
                System.out.println("Checkpoint added: " + newStage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not found: " + afterStage);
    }
    // Track parcel stages
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel lost or not registered.");
            return;
        }
        StageNode temp = head;
        System.out.print("Parcel Tracking: ");
        while (temp != null) {
            System.out.print(temp.stage);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Main method
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");
        tracker.addCheckpoint("Shipped", "Customs Check");
        tracker.trackParcel();
    }
}
