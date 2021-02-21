package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name, String email){
        super(name, email);
    }

    @Override
    public String toString() {
        return super.toString() + "\nmodel.Doctor{" +
                "speciality='" + speciality + '\'' +
                "\n Available \n" + availableAppointments.toString() +
                '}';
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital Cruz Roja");
        System.out.println("Departamento: Oncologia");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \n Date: " + date + "\n Time: " + time;
        }
    }
}
