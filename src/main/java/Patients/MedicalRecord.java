package Patients;

import java.util.ArrayList;

public class MedicalRecord {
    ArrayList<Record> records = new ArrayList<>();

    public MedicalRecord(){
        records.add(new Record("Zarejestrowanie w szpitalu","System","Pacjent poraz pierwszy został przyjęty do szpitala"));
    }

    public void addRecord(Record record){
        records.add(record);
    }
    public void print(){
        for (int i =0;i<records.size();i++){
            System.out.println("Wpis nr " + (i + 1));
            records.get(i).printRecord();
        }
    }
    public ArrayList<Record> getRecords() {
        return records;
    }
}
