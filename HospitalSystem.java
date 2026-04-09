public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        hospital.addBed(1, "ICU");
        hospital.addBed(2, "General");
        hospital.addBed(3, "Private");
        hospital.addBed(4, "ICU");

        hospital.addPatient(101, "Vetri");
        hospital.addPatient(102, "Alvin");

        hospital.allocateBed(101, "ICU");
        hospital.allocateBed(102, "General");

        hospital.showAvailableBeds();

        hospital.releaseBed(101);

        hospital.showAvailableBeds();
    }
}