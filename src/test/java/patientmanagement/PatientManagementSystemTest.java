package patientmanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientManagementSystemTest {

    @Test
    public void testServeNextPatientFromEmptyQueueReturnsNull() {
        PatientQueue queue = new PatientQueue();

        Patient servedPatient = queue.serveNextPatient();

        assertNull(servedPatient);
    }

    @Test
    public void testEmergencyInsertPlacesPatientAtCorrectPosition() {
        PatientQueue queue = new PatientQueue();

        Patient patient1 = new Patient(1, "Alice", "Checkup");
        Patient patient2 = new Patient(2, "Bob", "Headache");
        Patient emergencyPatient = new Patient(3, "Charlie", "Chest Pain");

        queue.addPatient(patient1);
        queue.addPatient(patient2);
        queue.insertPatientAtPosition(emergencyPatient, 2);

        assertEquals("Alice", queue.getAllPatients().get(0).getName());
        assertEquals("Charlie", queue.getAllPatients().get(1).getName());
        assertEquals("Bob", queue.getAllPatients().get(2).getName());
    }

    @Test
    public void testPatientHistoryPreventsMovingPastOldestRecord() {
        PatientHistory history = new PatientHistory();

        history.addRecord(new PatientRecord("2025-01-01", "Cold", "Rest"));
        history.addRecord(new PatientRecord("2025-01-02", "Flu", "Medication"));

        history.moveToOldestRecord();

        boolean moved = history.moveToPreviousRecord();

        assertFalse(moved);
        assertEquals("2025-01-01", history.getCurrentRecord().getVisitDate());
    }

    @Test
    public void testNewestAndOldestRecordsAreCorrect() {
        PatientHistory history = new PatientHistory();

        history.addRecord(new PatientRecord("2025-01-01", "Cold", "Rest"));
        history.addRecord(new PatientRecord("2025-01-02", "Flu", "Medication"));
        history.addRecord(new PatientRecord("2025-01-03", "Injury", "Bandage"));

        assertEquals("2025-01-01", history.getOldestRecord().getVisitDate());
        assertEquals("2025-01-03", history.getNewestRecord().getVisitDate());
    }
}