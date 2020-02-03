package app;

import java.util.*;
import java.io.*;

public class Forms {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Hello staff of Base Camp coding academy! Here all the forms!");
        ArrayList<NominationForm> form = load();
        for (var nominee : form) {
            System.out.println("Teacher: " + nominee.name);
            System.out.println("Email address: " + nominee.emailAddress);
            System.out.println("School: " + nominee.school);
            System.out.println("Position: " + nominee.position);
            System.out.println("Relationship: " + nominee.relationship);
            System.out.println("Student Name: " + nominee.studentName);
            System.out.println("Student Age: " + nominee.studentAge);
            System.out.println("Student Contact: " + nominee.studentContact);
            System.out.println("Expected Graduation: " + nominee.expectedGraduation);
            System.out.println("Aptitude: " + nominee.aptitude);
            System.out.println("Perseverance: " + nominee.perseverance);
            System.out.println("Dedication: " + nominee.dedication);
            System.out.println("Work Ethic: " + nominee.workEthic);
            System.out.println("Misc: " + nominee.misc);
            System.out.println(" --------- ");
        }
    }

    public static ArrayList<NominationForm> load() {
        try {
            FileInputStream fileStream = new FileInputStream("nominated.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<NominationForm> nominated = (ArrayList<NominationForm>) os.readObject();
            os.close();
            return nominated;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<NominationForm>();
        }
    }
}