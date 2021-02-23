package ui;

import model.Doctor;

import javax.print.Doc;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() throws ParseException {
        int response = 0;
        do{
            System.out.println();
            System.out.println();
            System.out.println("Patient");
            System.out.println("Welcome: "+UIMenu.patientLogged.getName());

            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
            }
        }while(response != 0);
    }

    private static void showBookAppointmentMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date");
            //Numeración de la lista de fechas
            //Indice de la fecha que seleccione el paciente
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for(int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++){
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for(int j = 0; j < availableAppointments.size(); j++){
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate("dd/mm/YYYY"));
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);

                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");
            for(Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() + ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate("dd/mm/yyyy") + ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n1.Yes \n2. Change Data");

            response = Integer.valueOf(sc.nextLine());

            if(response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                        );
                UIMenu.showPatientMenu();
            }

        }while(response!=0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do{
            System.out.println("::My Appointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j + ". "
                        + "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() + "\n"
                        + "Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() + "\n"
                        + "Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName() + "\n"
                );
            }

            System.out.println("0. Return");
        }while(response != 0);
    }
}
