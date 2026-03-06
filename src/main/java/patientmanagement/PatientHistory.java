package patientmanagement;

public class PatientHistory {

    private class Node {
        PatientRecord record;
        Node next;
        Node previous;

        Node(PatientRecord record) {
            this.record = record;
        }
    }

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public PatientHistory() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    public void addRecord(PatientRecord record) {
        Node newNode = new Node(record);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            current = tail;
        }

        size++;
    }

    public PatientRecord getCurrentRecord() {
        if (current == null) {
            return null;
        }
        return current.record;
    }

    public PatientRecord getNewestRecord() {
        if (tail == null) {
            return null;
        }
        return tail.record;
    }

    public PatientRecord getOldestRecord() {
        if (head == null) {
            return null;
        }
        return head.record;
    }

    public boolean moveToNextRecord() {
        if (current == null || current.next == null) {
            return false;
        }
        current = current.next;
        return true;
    }

    public boolean moveToPreviousRecord() {
        if (current == null || current.previous == null) {
            return false;
        }
        current = current.previous;
        return true;
    }

    public void moveToNewestRecord() {
        current = tail;
    }

    public void moveToOldestRecord() {
        current = head;
    }

    public int size() {
        return size;
    }

    public void loadSampleHistory() {
        addRecord(new PatientRecord("2025-01-01", "Flu", "Fever medication prescribed."));
        addRecord(new PatientRecord("2025-01-16", "Sprained Ankle", "Compression wrap applied."));
        addRecord(new PatientRecord("2025-02-02", "Migraine", "Pain relief medication prescribed."));
        addRecord(new PatientRecord("2025-02-11", "Seasonal Allergies", "Anti-acid prescribed."));
        addRecord(new PatientRecord("2025-02-24", "Back Pain", "Recommended stretching, heat, and follow-up."));
        addRecord(new PatientRecord("2025-03-09", "Ear Infection", "Antibiotics prescribed for 7 days."));
        addRecord(new PatientRecord("2025-04-04", "Stomach Virus", "Hydration and rest recommended."));
        addRecord(new PatientRecord("2025-04-25", "Routine Checkup", "Vitals normal, no major concerns."));
        addRecord(new PatientRecord("2025-05-06", "Bronchitis", "Cough medication recommended."));
        addRecord(new PatientRecord("2025-05-20", "Skin Rash", "Topical cream prescribed."));
    }
}