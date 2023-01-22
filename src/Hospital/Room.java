package Hospital;

import Patients.Patient;

import java.util.ArrayList;

public class Room {

    private static int counter = 1;
    private final int id;
    private final ArrayList<Bed> beds = new ArrayList<>();

    public Room (int beds){
        this.id = counter;
        counter++;
        for (int i=0;i<beds;i++){
            addBed(new Bed());
        }
    }

    public void addBed(Bed bed){
        beds.add(bed);
    }

    public int getId() {
        return id;
    }

    public Bed getBedByPatient(Patient patient){
        for (Bed bed: beds){
            if(bed.getPatient().equals(patient))
                return bed;
        }
        return null;
    }

    public boolean addPatient(Patient patient){
        for (Bed bed: beds){
            if(bed.getPatient()==null){
                bed.assignPatient(patient);
                return true;
            }

        }
        return false;
    }

    public boolean removePatient(Patient patient){
        for(Bed bed: beds) {
            if (bed.getPatient().equals(patient)) {
                bed.freeBed();
                return true;
            }
        }
        return false;
    }
    public ArrayList<Bed> getBeds(){
        return beds;
    }

    public int CountFreeBeds(){
        int counter = 0;
        for(Bed bed: beds){
            if(bed.getPatient()==null){
                counter++;
            }
        }
        return counter;
    }

    public void showRoomInfo(){
        System.out.println("Pokoj nr "+id+", wolnych miejsc: "+CountFreeBeds());
        System.out.println("Pacjenci: ");
        for (Bed bed: beds){
            bed.showPatientInfo();
        }
    }
}
