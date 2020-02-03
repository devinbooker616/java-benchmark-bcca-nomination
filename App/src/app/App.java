package app;

import java.util.*;
import java.io.*;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
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
        NominationForm nomination = signUp();
        form.add(nomination);
        save(form);

    }

    public static NominationForm signUp() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Tell us about yourself as a teacher!");
        System.out.print("What is you name: ");
        String name = sc.nextLine();
        System.out.print("What is your email address: ");
        String emailAddress = sc.nextLine();
        System.out.print("what school district are you affiliated with: ");
        String school = sc.nextLine();
        System.out.print("What is your position at your place of work: ");
        String position = sc.nextLine();
        System.out.print("What is your relationship to this student: ");
        String relationship = sc.nextLine();
        System.out.println("Now tell us about the nominee");
        System.out.print("What is the nominee's name: ");
        String studentName = sc.nextLine();
        System.out.print("What is the nominee's age: ");
        Integer studentAge = sc2.nextInt();
        System.out.print("What is the student's contact information: ");
        String studentContact = sc.nextLine();
        System.out.print("When are they expected to graduate: ");
        String expectedGraduation = sc.nextLine();
        System.out.print("Has this student shown any strong ability to think logically or strategically: ");
        String aptitude = sc.nextLine();
        System.out.print("Is there any evidence of the applicant being engaged in or passionate about something: ");
        String perseverance = sc.nextLine();
        System.out.print(
                "Do you think the applicant would be able to attend the program five days a week in water valley: ");
        String dedication = sc.nextLine();
        System.out.print("Why does this student deserve a position at base camp: ");
        String workEthic = sc.nextLine();
        System.out.print("Any miscellaneous things we should know about them: ");
        String misc = sc.nextLine();
        return new NominationForm(name, emailAddress, school, position, relationship, studentName, studentAge,
                studentContact, expectedGraduation, aptitude, perseverance, dedication, workEthic, misc);
    }

    private static void save(ArrayList<NominationForm> nominated) {
        try {
            FileOutputStream fileStream = new FileOutputStream("nominated.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominated);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nominee.");
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