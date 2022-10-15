//Name: Syeda Thamina Tonni
//ID: 04190301430
//Semester: 7
package VaccinationSystem;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VaccinationSystem {
    String patient_name,gender,vaccine_name,selected_hospital;
    int age, nid;
    static int patient_number;

    public static void main(String[] args) throws InputMismatchException {
        Scanner inp = new Scanner(System.in);
        int op;
        String ch, v, h;
        VaccinationSystem[] obj = new VaccinationSystem[100];

        do {
                System.out.println("Select 1 to enter new patient information");
                System.out.println("Select 2 to take Vaccination");
                System.out.println("Select 3 to get Vaccination Information from File");
                System.out.println("Select 4 to get eligible patients for Vaccination & File Output.\n");
                System.out.print("Enter your choice: ");
                op = inp.nextInt();
            try {
                switch (op) {
                    case 1:
                        System.out.print("Enter the total number of new patient: ");
                        patient_number = inp.nextInt();
                        for (int i = 0; i < patient_number; i++) {
                            try {
                                System.out.print("Enter your name: ");
                                inp.nextLine();
                                String patient_name = inp.nextLine();
                                System.out.print("Enter your age: ");
                                int age = inp.nextInt();
                                System.out.print("Enter your gender: ");
                                inp.nextLine();
                                String gender = inp.nextLine();
                                System.out.print("Enter your NID number: ");
                                int nid = inp.nextInt();
                                System.out.println("Data saved for patient no: " + (i + 1));
                                System.out.println();

                                obj[i] = new VaccinationSystem();
                                obj[i].patient_name = patient_name;
                                obj[i].age = age;
                                obj[i].gender = gender;
                                obj[i].nid = nid;
                            } catch (InputMismatchException e) {
                                System.out.println(e);
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter NID number to check eligibilty: ");
                        int id = inp.nextInt();
                        for (int i = 0; i < patient_number; i++) {
                            if (id == obj[i].nid) {
                                if (obj[i].gender.equalsIgnoreCase("Female") == true) {
                                    System.out.println("Are you pregnant? (Y/N)");
                                    inp.nextLine();
                                    ch = inp.nextLine();
                                    if (ch.equalsIgnoreCase("Y") == true) {
                                        System.out.println("You are NOT Eligible for vaccination as it can be harmful for the baby.\n");
                                        break;
                                    } else if (ch.equalsIgnoreCase("N") == true) {
                                        System.out.println("Are you covid positive? (Y/N)");
                                        ch = inp.nextLine();
                                        if (ch.equalsIgnoreCase("Y") == true) {
                                            System.out.println("You are NOT Eligible for vaccination due to covid positive.\n");
                                            break;
                                        } else if (ch.equalsIgnoreCase("N") == true) {
                                            System.out.println("Choose the type of vaccine (Moderna/Pfizer/AstraZeneca).");
                                            v = inp.nextLine();
                                            obj[i].vaccine_name = v;
                                            System.out.println("Choose the hospital for vaccination (Square/Popular/DMC).");
                                            h = inp.nextLine();
                                            obj[i].selected_hospital = h;
                                            System.out.println("Thank you! We will let you know the date of vaccination.\n");
                                        }
                                    } else {
                                        System.out.println("Invalid choice");
                                    }

                                } else if (obj[i].gender.equalsIgnoreCase("Male") == true) {
                                    System.out.println("Are you covid positive? (Y/N)");
                                    inp.nextLine();
                                    ch = inp.nextLine();
                                    if (ch.equalsIgnoreCase("Y") == true) {
                                        System.out.println("You are NOT Eligible for vaccination due to covid positive.\n");
                                        break;
                                    } else if (ch.equalsIgnoreCase("N") == true) {
                                        System.out.println("Choose the type of vaccine (Moderna/Pfizer/AstraZeneca).");
                                        v = inp.nextLine();
                                        obj[i].vaccine_name = v;
                                        System.out.println("Choose the hospital for vaccination (Square/Popular/DMC).");
                                        h = inp.nextLine();
                                        obj[i].selected_hospital = h;
                                        System.out.println("Thank you! We will let you know the date of vaccination.\n");
                                        break;
                                    } else {
                                        System.out.println("Invalid choice.");
                                    }
                                } else {
                                    System.out.println("Invalid input.");
                                }
                            }
                        }
                        break;
                    case 3:
                        File myObj = new File("D:\\textFile\\vaccine information.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        break;
                    case 4:
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\textFile\\writeInfo.txt"));

                            for (int i = 0; i < patient_number; i++) {
                                if (obj[i].vaccine_name != null && obj[i].selected_hospital != null) {
                                    writer.write("Name: " + obj[i].patient_name + " | Age: " + obj[i].age
                                            + " | Gender: " + obj[i].gender + " | NID: " + obj[i].nid
                                            + " | Vaccine Name: " + obj[i].vaccine_name
                                            + " | Selected Hospital: " + obj[i].selected_hospital + "\n");

                                } else {
                                    writer.write(" ");
                                }

                            }
                            writer.flush();
                            writer.close();
                        } catch (FileNotFoundException e) {
                            System.out.println(e);
                        } catch (IOException e) {
                            System.out.println(e);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        File object = new File("D:\\textFile\\writeInfo.txt");
                        Scanner reader = new Scanner(object);
                        while (reader.hasNextLine()) {
                            String data = reader.nextLine();
                            System.out.println(data);
                        }
                        break;
                    case 5:
                        System.out.println("You have exited the program");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (op < 5);
    }
}
