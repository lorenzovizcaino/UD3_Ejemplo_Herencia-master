package herencia.perClass;



import javax.persistence.Entity;

@Entity
public class Externo extends Employee {

	private String empresa;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Externo { externoId=" + id+", empresa="+empresa+"} ";
	}
}
