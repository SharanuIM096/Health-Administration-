package healthAdministration;

import java.util.List;

public interface DoctorDao {
	
	void addDoctor(Doctor doctor);
	
    List<Doctor> getAllDoctors();
    
    Doctor getByDocId(int id);
    
    void   updateDoctor( Doctor existingDoctor);
    
    void deleteDoc(int id);
    

}
