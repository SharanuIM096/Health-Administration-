package healthAdministration;

import java.util.List;

import javax.print.Doc;

public class HealthService {
	 
	 private PatientDao patientDao=new PatientDaoIml();
	 private DoctorDao doctorDao=new DoctorDaoImpl() ;
     private AppointmentDao appointmentDao = new AppointmentDaoImpl();
		
		
	
	
	public  void addPatient(Patient patient) {
		patientDao.addPatient(patient);
		
	}
  public  List<Patient> getAllPatients(){
	 return  patientDao.getAllPatients();
  }
  
  public Patient getPatientById(int id) {
	  return patientDao.getPatientById(id);
	  
  }
  public void updateObject(Patient patient) {
	  patientDao.updateObject(patient);
  }
  public void deletePatient(int id) {
	  patientDao.deletepatient(id);
	  
  }
  public void rigesterDoctor(Doctor doctor) {
	  doctorDao.addDoctor(doctor);
	  
  }
  
  public   List<Doctor> getAllDoctors(){
	  return doctorDao.getAllDoctors();
  }
   public  Doctor getByDocId(int id) {
	  return  doctorDao.getByDocId(id);
   }
   public void  updateDoctor( Doctor existingDoctor) {
	   doctorDao.updateDoctor(existingDoctor);
	   
   }
   public void deleteDoc(int id) {
	   doctorDao.deleteDoc(id);
   }
   public void addAppointment(Appointment appointment) {
	   appointmentDao.addAppointment(appointment);
   }

   public void updateAppointment(Appointment appointment) {
       appointmentDao.updateAppointment(appointment);
   }

   public void deleteAppointment(int id) {
       appointmentDao.deleteAppointment(id);
   }

   public Appointment getAppointmentById(int id) {
       return appointmentDao.getAppointmentById(id);
   }

   public List<Appointment> getAllAppointments() {
       return appointmentDao.getAllAppointments();
   }
}
