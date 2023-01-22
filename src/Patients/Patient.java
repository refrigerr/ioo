package Patients;

import Hospital.Department;
import Main.ApplicationInstance;

import java.util.Objects;

public class Patient {

    private static int counter = 1;
    private String name, surname, pesel, address, bloodType;
    private int age;
    private final int id;
    private int departmentID;
    public int roomID;
    private boolean sex;



    public Patient (String name, String surname, int departmentID, String pesel, String address, String bloodType, int age, boolean sex){
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address= address;
        this.bloodType = bloodType;
        this.age = age;
        this.sex = sex;
        this.id = counter;
        Department department = ApplicationInstance.getDepartmentByID(departmentID);
        this.departmentID = assignDepartmentID(department);


        counter++;
    }
    private int assignDepartmentID(Department department){
        if(department==null || !department.checkBedAvailability()){
            department = ApplicationInstance.getFirstFreeDepartment();
            if (department==null){
                System.out.println("Brak miejsca w szpitalu!");
                return -1;
            }
        }
        return department.getId();
    }
    public void showInfo(){
        System.out.println("Imie: "+ name);
        System.out.println("Nazwisko: "+ surname);
        System.out.print("Plec: ");
        System.out.println(sex?"Kobieta":"Mezczyzna");
        System.out.println("Wiek: "+ age);
        System.out.println("Pesel: "+ pesel);
        System.out.println("Grupa krwi: "+ bloodType);
        System.out.println("Adres: "+ address);
        System.out.println("Departament: "+ Objects.requireNonNull(ApplicationInstance.getDepartmentByID(departmentID)).getName());

    }


    public int getId() {
        return id;
    }

    public String getPesel() {
        return this.pesel;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
