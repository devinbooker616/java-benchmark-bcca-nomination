package app;

import java.util.*;
import java.io.*;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<NominationForm> form = load();
        NominationForm nomination = signUp();
        form.add(nomination);
        save(form);
        System.out.println("Thank your for your submission");

    }

    public static NominationForm signUp() {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Tell us about yourself as a teacher!");
        System.out.print("What is you name: ");
        String name = sc.nextLine();
        System.out.print("What is your contact: ");
        String emailAddress = validEmail();
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
        String studentContact = validEmail();
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
        sc2.close();
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

    public static String validEmail() {
        while (true) {
            String emailAddress = sc.nextLine();
            if (emailAddress.contains("@")) {
                return emailAddress;
            } else {
                System.out.println("That's not a valid email");
            }
        }
    }
}