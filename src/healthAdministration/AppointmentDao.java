package healthAdministration;

import java.util.List;

public interface AppointmentDao {
	void addAppointment(Appointment appointment);
	  
    void updateAppointment(Appointment appointment);
    
    void deleteAppointment(int id);
    
    Appointment getAppointmentById(int id);
    
    List<Appointment> getAllAppointments();

}
