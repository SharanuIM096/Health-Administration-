package healthAdministration;

public class Doctor {
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	public Doctor() {
		super();
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specility=" + specialty + ", contectInfo=" + contact_info
				+ "]";
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

	
	public Doctor(int id, String name, String specility, String contectInfo) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specility;
		this.contact_info = contectInfo;
	}
	private int id;
	private String name;
	private String specialty;
	private String contact_info;

}
