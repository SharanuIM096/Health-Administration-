package healthAdministration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

public class DoctorDaoImpl implements DoctorDao {
	
	private static String url="jdbc:mysql://localhost:3306/health_db";
	private static String username="root";
	private static String password="root";
	
	public void addDoctor(Doctor doctor) {
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String query="Insert into Doctors(name,specialty,contact_info) values (?,?,?)";
			try(PreparedStatement stmt=conn.prepareStatement(query)){
					stmt.setString(1, doctor.getName());
					stmt.setString(2, doctor.getSpecialty());
					stmt.setString(3, doctor.getContact_info());
					stmt.executeUpdate();
				
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  List<Doctor> getAllDoctors(){
		List<Doctor> doctors=new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String query="select * from Doctors";
			try(PreparedStatement stmt=conn.prepareStatement(query)){
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					Doctor doctor=new Doctor(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("specialty"),
							rs.getString("contact_info"));
					doctors.add(doctor);
				}
				
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return doctors;
	}
	
	public  Doctor getByDocId(int id) {
		Doctor doctor=null;
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String query="select * from Doctors where id=?";
			try(PreparedStatement stmt=conn.prepareStatement(query)){
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					doctor=new Doctor(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("specialty"),
							rs.getString("contact_info"));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
	public void updateDoctor( Doctor existingDoctor) {
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String query="Update doctors set name=?,specialty=?,contact_info=? where id=?";
			try(PreparedStatement stmt=conn.prepareStatement(query)){
				stmt.setString(1,existingDoctor.getName());
				stmt.setString(2, existingDoctor.getSpecialty());
				stmt.setString(3, existingDoctor.getContact_info());
				stmt.setInt(4, existingDoctor.getId());;
				stmt.executeUpdate();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDoc(int id) {
		try(Connection conn=DriverManager.getConnection(url, username, password)){
			String query="Delete from Doctors where id=?";
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
