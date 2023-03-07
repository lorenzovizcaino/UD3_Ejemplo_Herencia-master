package herencia.perClass;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TestPerClass {

	
	
	private static SessionFactory sessionFactory = null;
	
	
	private static Session session = null;

	
	private static Transaction tx = null;
	
	
    public static void main(String[] args) {
      sessionFactory = SessionFactoryUtil.getSessionFactory();
    	
session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
    	addEmployees();
		mostrarEmpleados();
    	
	tx.commit();
		
		session.close();
    }

	private static void mostrarEmpleados() {
		//	¿¿Requiere lanzar consultas sobre cada tabla??.
		List<Employee> listaEmployee=session.createQuery("Select e from Employee e").list();
		for (Employee e:listaEmployee) {
			System.out.println(e);
		}

//		List<Technician> listaTecnician=session.createQuery("Select t from Technician t").list();
//		for (Technician e:listaTecnician) {
//			System.out.println(e);
//		}
//
//		List<Externo> listaExterno=session.createQuery("Select x from Externo x").list();
//		for (Externo e:listaExterno) {
//			System.out.println(e);
//		}

	}


	public static void addEmployees() {
		
		System.out.println("\n\n*** addEmployee ***\n");
		
		try {
			Employee employee = new Employee("yo mismo");
			
			try {
				session.save(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			System.out.println("La clave del nuevo objeto es: " + employee.getId());
			
			Technician technician = new Technician();
			technician.setName("Yo soy el tecnico!!!");
			technician.setExperienceYears(24);
			session.save(technician);
			System.out.println("La clave del nuevo objeto es: " + technician.getId());
			
			Developer developer = new Developer();
			developer.setName("Yo soy el desarrollador!!!");
			developer.setExperienceYears(14);
			developer.setExpertLanguajes("Java");
			session.save(developer);
			System.out.println("La clave del nuevo objeto es: " + developer.getId());

			Externo externo = new Externo();
			externo.setName("Yo soy Externo");
			externo.setEmpresa("IBM");
			session.save(externo);
			System.out.println("La clave del nuevo objeto es: " + externo.getId());
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
