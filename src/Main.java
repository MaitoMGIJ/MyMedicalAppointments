import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        Doctor myDoctor = new Doctor();
        myDoctor.name = "Anahí Salgado";
        myDoctor.showName();
        myDoctor.showId();
        System.out.println(Doctor.id);

        Doctor.id++;

        Doctor myDoctorMao = new Doctor();
        myDoctorMao.name = "Mauricio Avila";
        myDoctorMao.showName();
        myDoctorMao.showId();
        System.out.println(Doctor.id);

        showMenu();

    }
}
