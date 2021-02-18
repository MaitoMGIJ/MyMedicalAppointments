import ui.UIMenu;

public class Main {
    public static void main(String[] args) {

        //UIMenu.showMenu();

        Doctor myDoctor = new Doctor("Mauricio Avila","Neurologo");

        System.out.println(myDoctor.name);
        System.out.println(myDoctor.speciality);

    }

}
