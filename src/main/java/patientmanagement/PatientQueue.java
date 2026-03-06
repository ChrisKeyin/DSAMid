package patientmanagement;

import java.util.LinkedList;
import java.util.List;

public class PatientQueue {
    private LinkedList<Patient> queue;

    public PatientQueue() {
        queue = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
        queue.addLast(patient);
    }

    public Patient serveNextPatient() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    public void insertPatientAtPosition(Patient patient, int position) {
        if (queue.isEmpty()) {
            queue.add(patient);
            return;
        }

        if (position <= 1) {
            queue.addFirst(patient);
        } else if (position > queue.size()) {
            queue.addLast(patient);
        } else {
            queue.add(position - 1, patient);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public List<Patient> getAllPatients() {
        return new LinkedList<>(queue);
    }

    public void printPatients() {
        if (queue.isEmpty()) {
            System.out.println("The waiting queue is currently empty.");
            return;
        }

        System.out.println("\nCurrent Waiting Queue:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println((i + 1) + ". " + queue.get(i));
        }
    }
}