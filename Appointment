
import java.time.LocalDate;
import java.time.LocalTime;
public class Appointment
{
    // instance variables - replace the example below with your own
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    
    public Appointment(LocalDate date, LocalTime startTime, LocalTime endTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    
    public LocalDate getDate(){
        return this.date;
    }
    
    public LocalTime getStartTime(){
        return this.startTime;
    }
    
    public LocalTime getEndTime(){
        return this.endTime;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %s - %s", description, date, startTime, endTime);
    }
}
