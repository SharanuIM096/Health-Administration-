package healthAdministration;

import java.sql.Date;



public class Patient {
	public Patient() {
		super();
	}

	private int id;
	private String name;
	private Date dateOfBirth;
	private String contactInfo;
	private String medicalHistory;
	
	
	public Patient(int id, String name, Date dateOfBirth, String contactInfo, String medicalHistory) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.contactInfo = contactInfo;
		this.medicalHistory = medicalHistory;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", contactInfo=" + contactInfo
				+ ", medicalHistory=" + medicalHistory + "]";
	}
}
