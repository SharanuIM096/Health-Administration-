package healthAdministration;

import java.util.List;

public interface PatientDao {
	
	void addPatient(Patient patient);
	
	List<Patient> getAllPatients();
	
	Patient  getPatientById(int id);
	
    void updateObject(Patient patient);
	
	void deletepatient(int id);

}
