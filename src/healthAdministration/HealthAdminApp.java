package healthAdministration;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HealthAdminApp {
	
 static	Scanner sc= new Scanner(System.in);
 static HealthService healthService= new HealthService();
	
	
	public static void main(String arg[]) {
		while(true) {
		      System.out.println("Health Administration System");
	            System.out.println("1. Register Patient");
	            System.out.println("2. View All Patients");
	            System.out.println("3. Update Patient");
	            System.out.println("4. Delete Patient");
	            System.out.println("5. Register Doctor");
	            System.out.println("6. View All Doctors");
	            System.out.println("7. Update Doctor");
	            System.out.println("8. Delete Doctor");
	            System.out.println("9. Add Appointment");
	            System.out.println("10. View All Appointments");
	            System.out.println("11. Update Appointment");
	            System.out.println("12. Delete Appointment");
	            System.out.println("13. Exit");
	            System.out.println("***************************");
	           int choice=sc.nextInt();
	           sc.nextLine();
	           switch(choice) {
	           
	           case 1:
	        	   addPatient();
	        	   break;
	           case 2:
	        	   getAllPatient();
	        	   break;
	           case 3:
	        	   updatePatient();
	        	   break;
	           case 4:
	        	   deletePatient();
	        	   break;
	           case 5:
	        	  rigesterDoctor();
	        	   break;
	           case 6:
	        	   viewAllDoctors();
	        	   break;
	           case 7:
	        	   updateDoctor();
	        	   break;
	           case 8:
	        	   deleteDoc();
	        	   break;
               case 9:
                   addAppointment();
                   break;
               case 10:
                   viewAllAppointments();
                   break;
               case 11:
                   updateAppointment();
                   break;
               case 12:
                   deleteAppointment();
                   break;
               case 13:
                   System.exit(0);
	    
	           }    
	           
	           
		}
				
	}
	
	public static void addPatient() {
		System.out.println("Enter the patientName");
		String name=sc.nextLine();
		System.out.println("Enter the Date of Birth in yyyy-mm-dd");
		String dob=sc.nextLine();
	    System.out.println("Enter the contactInfo");
		String contactInfo=sc.nextLine();
		System.out.println("Enter the medicalHistory");
		String medicalHistory=sc.nextLine();
		
		Patient patient=new Patient();
		patient.setName(name);
		patient.setDateOfBirth(Date.valueOf(dob));
		patient.setContactInfo(contactInfo);
		patient.setMedicalHistory(medicalHistory);
		
		healthService.addPatient(patient);

	}
	
	public static void getAllPatient() {
		List<Patient> patient= healthService.getAllPatients();
		for(Patient p:patient ) {
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getContactInfo());
			System.out.println(p.getDateOfBirth());
			System.out.println(p.getMedicalHistory());
		}
		
	}
	public static void  updatePatient() {
		System.out.println("Enter the Id of the Ptient to Upadate");
		int id=sc.nextInt();
		sc.nextLine();
	Patient existingPatient	=healthService.getPatientById(id);
	
	if(existingPatient==null) {
		System.out.println("patient not found");
		return ;
	}
	    System.out.println("Enter new patient name (leave blank to keep current):");
	    String name=sc.nextLine();
	    System.out.println("Enter new patient date of birth (yyyy-mm-dd) (leave blank to keep current):");
        String dob = sc.nextLine();
        System.out.println("Enter new patient contact info (leave blank to keep current):");
        String contactInfo = sc.nextLine();
        System.out.println("Enter new patient medical history (leave blank to keep current):");
        String medicalHistory = sc.nextLine();
        
        
        if(!name.isEmpty()) {
        	existingPatient.setName(name);
        }
        if(!dob.isEmpty()) {
        	existingPatient.setDateOfBirth(Date.valueOf(dob));
        	
        }
        if(!contactInfo.isEmpty()) {
        	existingPatient.setContactInfo(contactInfo);
        }
        if(!medicalHistory.isEmpty()) {
        	existingPatient.setMedicalHistory(medicalHistory);
        }
	  
        
        healthService.updateObject(existingPatient);
        System.out.println("patient updated suscessfully");
        

	}
	
	public static void  deletePatient() {
		System.out.println("enter the id Of a patient to be delete");
		int id=sc.nextInt();
		sc.nextLine();
		
		healthService.deletePatient(id);
	}
	
	public static void   rigesterDoctor() {
	       System.out.println("Enter doctor name:");
	        String name = sc.nextLine();
	        System.out.println("Enter doctor specialty:");
	        String specialty = sc.nextLine();
	        System.out.println("Enter doctor contact info:");
	        String contactInfo = sc.nextLine();
	          
	        Doctor doctor=new Doctor();
	        doctor.setName(name);
	        doctor.setSpecialty(specialty);
	        doctor.setContact_info(contactInfo);
	        
	        healthService.rigesterDoctor(doctor);
	    	System.out.println("doctor rigester sucessfully");
	}
	
	public static void viewAllDoctors() {
		List<Doctor> doc=healthService.getAllDoctors();
		for(Doctor doctor:doc) {
			System.out.println(doctor.getId());
			System.out.println(doctor.getName());
			System.out.println(doctor.getSpecialty());
			System.out.println(doctor.getContact_info());
		}
	}
	
	public static void updateDoctor() {
		System.out.println("Enter the doctore id to update");
		int id=sc.nextInt();
		sc.nextLine();

	Doctor existingDoctor = healthService.getByDocId(id);
    if (existingDoctor == null) {
        System.out.println("Doctor not found.");
        return;
    }

    System.out.println("Enter new doctor name (leave blank to keep current):");
    String name = sc.nextLine();
    System.out.println("Enter new doctor specialty (leave blank to keep current):");
    String specialty = sc.nextLine();
    System.out.println("Enter new doctor contact info (leave blank to keep current):");
    String contactInfo = sc.nextLine();

    if (!name.isEmpty()) {
        existingDoctor.setName(name);
    }
    if (!specialty.isEmpty()) {
        existingDoctor.setSpecialty(specialty);;
    }
    if (!contactInfo.isEmpty()) {
        existingDoctor.setContact_info(contactInfo);
    }

    healthService.updateDoctor(existingDoctor);
    System.out.println("Doctor updated successfully.");


	}
	public static void deleteDoc() {
		System.out.println("enter the id of a doctor to delete");
		int id=sc.nextInt();
		healthService.deleteDoc(id);
		System.out.println("Doctor deleted sucessfully");
	}
	 private static void addAppointment() {
	        System.out.println("Enter patient ID:");
	        int patientId = sc.nextInt();
	        System.out.println("Enter doctor ID:");
	        int doctorId = sc.nextInt();
	        sc.nextLine();
	        System.out.println("Enter appointment date (yyyy-mm-dd):");
	        String appointmentDate = sc.next();
	        System.out.println("Enter appointment status:");
	        String status = sc.next();

	        Appointment appointment = new Appointment();
	        appointment.setPatientId(patientId);
	        appointment.setDoctorId(doctorId);
	        appointment.setAppointmentDate(Date.valueOf(appointmentDate));
	        appointment.setStatus(status);

	        healthService.addAppointment(appointment);
	        System.out.println("Appointment added successfully.");
	    }

	    private static void viewAllAppointments() {
	        List<Appointment> appointments = healthService.getAllAppointments();
	        for (Appointment appointment : appointments) {
	            System.out.println(appointment);
	        }
	    }

	    private static void updateAppointment() {
	        System.out.println("Enter appointment ID to update:");
	        int id = sc.nextInt();
	        sc.nextLine(); // consume newline

	        Appointment existingAppointment = healthService.getAppointmentById(id);
	        if (existingAppointment == null) {
	            System.out.println("Appointment not found.");
	            return;
	        }

	        System.out.println("Enter new patient ID (leave blank to keep current):");
	        String patientId = sc.nextLine();
	        System.out.println("Enter new doctor ID (leave blank to keep current):");
	        String doctorId = sc.nextLine();
	        System.out.println("Enter new appointment date (yyyy-mm-dd) (leave blank to keep current):");
	        String appointmentDate = sc.nextLine();
	        System.out.println("Enter new appointment status (leave blank to keep current):");
	        String status = sc.nextLine();

	        if (!patientId.isEmpty()) {
	            existingAppointment.setPatientId(Integer.parseInt(patientId));
	        }
	        if (!doctorId.isEmpty()) {
	            existingAppointment.setDoctorId(Integer.parseInt(doctorId));
	        }
	        if (!appointmentDate.isEmpty()) {
	            existingAppointment.setAppointmentDate(Date.valueOf(appointmentDate));
	        }
	        if (!status.isEmpty()) {
	            existingAppointment.setStatus(status);
	        }

	        healthService.updateAppointment(existingAppointment);
	        System.out.println("Appointment updated successfully.");
	    }

	    private static void deleteAppointment() {
	        System.out.println("Enter appointment ID to delete:");
	        int id = sc.nextInt();
	        sc.nextLine(); // consume newline

	        healthService.deleteAppointment(id);
	        System.out.println("Appointment deleted successfully.");
	    }
}
