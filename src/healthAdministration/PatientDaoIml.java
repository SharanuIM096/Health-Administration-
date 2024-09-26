package healthAdministration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoIml implements PatientDao {
		private static String url="jdbc:mysql://localhost:3306/health_db";
		private static String username="root";
		private static String password="root";
		
		
		public  void addPatient(Patient patient) {
			try(Connection conn=DriverManager.getConnection(url, username,password)){
				String query="Insert into Patients(name, date_of_birth, contact_info, medical_history) values (?,?,?,?)";
			
				try(PreparedStatement stmt=conn.prepareStatement(query)) {
					stmt.setString(1, patient.getName());
					stmt.setDate(2, patient.getDateOfBirth());
					stmt.setString(3,patient.getContactInfo());
					stmt.setString(4,patient.getMedicalHistory());
					
					stmt.executeUpdate();
					
				}
			
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		public List<Patient> getAllPatients(){
			
			List<Patient>  patients=new ArrayList<>();
			try(Connection conn=DriverManager.getConnection(url,username,password)) {
				String query="select * from Patients";
				try(PreparedStatement smt=conn.prepareStatement(query)){
					ResultSet rs=smt.executeQuery();
					while(rs.next()) {
						Patient patient=new Patient(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getDate("date_of_birth"),
								rs.getString("contact_info"),
								rs.getString("medical_history")
								);
						patients.add(patient);
								
					}				
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return patients;
		}
		
		public Patient getPatientById(int id) {
			Patient patient=null;
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String query="select * from Patients where id=?";
				try(PreparedStatement p=conn.prepareStatement(query)){
					p.setInt(1, id);
					
					ResultSet rs=p.executeQuery();
							while(rs.next()) {
								 patient=new Patient(
										 rs.getInt("id"),
											rs.getString("name"),
											rs.getDate("date_of_birth"),
											rs.getString("contact_info"),
											rs.getString("medical_history")
										 
										 );
								 
							}
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return patient;
		}
		
		public void updateObject(Patient patient) {
			
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String query="Update Patients set name=?, date_of_birth=?,contact_info=?,medical_history=? where id=?";
				try(PreparedStatement p=conn.prepareStatement(query)){
					p.setString(1, patient.getName());
					p.setDate(2, patient.getDateOfBirth());
					p.setString(3, patient.getContactInfo());
					p.setString(4, patient.getMedicalHistory());
					p.setInt(5,patient.getId());
					p.executeUpdate();
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		public void deletepatient(int id) {
			try(Connection conn=DriverManager.getConnection(url, username, password)){
				String query="Delete from Patients where id=?";
				try(PreparedStatement stmt=conn.prepareStatement(query)){
					stmt.setInt(1, id);
					stmt.executeUpdate();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

}
