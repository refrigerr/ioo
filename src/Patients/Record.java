package Patients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record {
    private final String title, author, description;
    private final LocalDateTime date;

    public Record(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
        date = LocalDateTime.now();
    }

    public void printRecord(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Tytul: "+title);
        System.out.println("Autor: "+author);
        System.out.println("Data: "+dtf.format(date));
        System.out.println("\nOpis:\n"+description+"\n\n");
    }
}
