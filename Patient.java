class Patient {
    int patientId;
    String name;
    int allocatedBedId;

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.allocatedBedId = -1;
    }
}