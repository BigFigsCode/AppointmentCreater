import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentCalendar calendar = new AppointmentCalendar();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.println("Choose an option: [1] Add Appointment [2] Remove Appointment [3] Show Specified Appointments [4] Display added appointments [5] Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1": // Add Appointment
                    System.out.println("Enter appointment details (Description, Date yyyy/MM/dd, Start Time HH:mm, End Time HH:mm):");
                    String[] details = scanner.nextLine().split(", ");
                    if (details.length == 4) {
                        try {
                            Appointment appointment = new Appointment(
                                LocalDate.parse(details[1].trim(), dateFormatter),
                                LocalTime.parse(details[2].trim(), timeFormatter),
                                LocalTime.parse(details[3].trim(), timeFormatter),
                                details[0].trim()
                            );
                            calendar.addAppointment(appointment);
                            System.out.println("Appointment added successfully.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please check the format and try again.");
                        }
                    } else {
                        System.out.println("Invalid input format.");
                    }
                    break;

                case "2": // Remove Appointment
                    System.out.println("Enter the date of the appointment you want to remove (yyyy/MM/dd):");
                    String dateToRemove = scanner.nextLine();
                    List<Appointment> appointmentsToRemove = calendar.getAppointmentsOn(LocalDate.parse(dateToRemove, dateFormatter));
                    if (!appointmentsToRemove.isEmpty()) {
                        appointmentsToRemove.forEach(appointment -> {
                            calendar.removeAppointment(appointment);
                            System.out.println("Removed: " + appointment);
                        });
                    } else {
                        System.out.println("No appointments found on this date.");
                    }
                    break;

                case "3": // Show Appointments on a specific date
                    System.out.println("Enter the date to view appointments (yyyy/MM/dd):");
                    String dateToShow = scanner.nextLine();
                    List<Appointment> appointmentsToShow = calendar.getAppointmentsOn(LocalDate.parse(dateToShow, dateFormatter));
                    if (!appointmentsToShow.isEmpty()) {
                        appointmentsToShow.forEach(System.out::println);
                    } else {
                        System.out.println("No appointments found on this date.");
                    }
                    break;
                case "4": //will display all appointments 
                System.out.println("Appointments List:");
                    for (Appointment appointment : calendar.getAllAppointments()) {
                        System.out.println(appointment);
                    }
                    break;
                case "5": // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }
}
