package herencia.joined;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class TestJoined {


    private static SessionFactory sessionFactory = null;


    private static Session session = null;


    private static Transaction tx = null;


    public static void main(String[] args) {
        sessionFactory = herencia.joined.SessionFactoryUtil.getSessionFactory();

        session = sessionFactory.openSession();

        tx = session.beginTransaction();
        //addEmployees();
        mostrarEmpleados();
		deleteEmpleado(3L);

        tx.commit();

        session.close();
    }

	private static void deleteEmpleado(Long id) {
		Developer developer=session.get(Developer.class, id);
		if(developer!=null){
			session.delete(developer);
			System.out.println("borrado");
		}
	}

	private static void mostrarEmpleados() {
//		List<Employee> listaEmployee=session.createQuery("Select e.name, e.nif, e.phone, e.email, t.experienceYears " +
//				"FROM Employee e JOIN Technician t on e.id=e.t.employeeId").list();
//		for (Employee e:listaEmployee) {
//			System.out.println(e);
//		}
        List<Employee> listaEmployee = session.createQuery("Select e from Employee e order by e.id").list();
        for (Employee e : listaEmployee) {
            System.out.println(e);
        }
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
            externo.setName("Raul");
            session.save(externo);
            System.out.println("La clave del nuevo objeto es: " + externo.getId());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
