import java.util.*;

class Hospital {
    List<Bed> beds = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    public void addBed(int id, String type) {
        beds.add(new Bed(id, type));
    }

    public void addPatient(int id, String name) {
        patients.add(new Patient(id, name));
    }

    public void allocateBed(int patientId, String wardType) {
        for (Bed bed : beds) {
            if (!bed.isOccupied && bed.wardType.equalsIgnoreCase(wardType)) {
                for (Patient p : patients) {
                    if (p.patientId == patientId) {
                        bed.isOccupied = true;
                        p.allocatedBedId = bed.bedId;
                        System.out.println("Bed " + bed.bedId + " allocated to " + p.name);
                        return;
                    }
                }
            }
        }
        System.out.println("No available bed in " + wardType);
    }

    public void releaseBed(int patientId) {
        for (Patient p : patients) {
            if (p.patientId == patientId && p.allocatedBedId != -1) {
                for (Bed b : beds) {
                    if (b.bedId == p.allocatedBedId) {
                        b.isOccupied = false;
                        System.out.println("Bed " + b.bedId + " released from " + p.name);
                        p.allocatedBedId = -1;
                        return;
                    }
                }
            }
        }
        System.out.println("Patient not found or no bed allocated");
    }

    public void showAvailableBeds() {
        System.out.println("Available Beds:");
        for (Bed b : beds) {
            if (!b.isOccupied) {
                System.out.println("Bed ID: " + b.bedId + " | Type: " + b.wardType);
            }
        }
    }
}