package app;

import java.io.*;

public class NominationForm implements java.io.Serializable {
    String name;
    String emailAddress;
    String school;
    String position;
    String relationship;
    String studentName;
    Integer studentAge;
    String studentContact;
    String expectedGraduation;
    String aptitude;
    String perseverance;
    String dedication;
    String workEthic;
    String misc;

    public NominationForm(String name, String emailAddress, String school, String position, String relationship,
            String studentName, Integer studentAge, String studentContact, String expectedGraduation, String aptitude,
            String perseverance, String dedication, String workEthic, String misc) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.school = school;
        this.position = position;
        this.relationship = relationship;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentContact = studentContact;
        this.expectedGraduation = expectedGraduation;
        this.aptitude = aptitude;
        this.perseverance = perseverance;
        this.dedication = dedication;
        this.workEthic = workEthic;
        this.misc = misc;

    }

}