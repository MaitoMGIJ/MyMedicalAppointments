import ui.UIMenu;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //UIMenu.showMenu();

        Doctor myDoctor = new Doctor("Mauricio Avila","Neurologo");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate()+" "+aA.getTime());
        }
        Patient patient = new Patient("Alejandra", "alejandra@mail.com");

    }

}
