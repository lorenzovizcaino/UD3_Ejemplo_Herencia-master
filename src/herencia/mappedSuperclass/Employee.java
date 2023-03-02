package herencia.mappedSuperclass;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Employee{

		
	protected Long id;

	private String nif;

	private String name;

	private String phone;

	private String email;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee(String nif, String name, String phone, String email) {
		this.nif = nif;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//También sería posible usar una secuencia en lugar de IDENTIY
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	//@SequenceGenerator(name="employee_generator", sequenceName = "employee_seq")

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nif", length = 10)
	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee { id=" + id + ", nif=" + nif + ", name=" + name + ", phone=" + phone + ", email=" + email + " }";
	}
}
