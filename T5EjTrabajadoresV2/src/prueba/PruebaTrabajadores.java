package prueba;
import trabajadores.*;
public class PruebaTrabajadores {
		
	public static void main(String[] args) {
		Person[] listaPersonas = new Person[4];
		Manager manager = new Manager("Juan",25,"234",5,6);
		Employee employee = new Employee("Pepe",22,"233",5);
		Employee employee1 = new Employee("David",21,"214",7);
		OutsideConsultant outsideConsultant = new OutsideConsultant("Carla",29,"111",5,1,"Upm");
		
		listaPersonas[0] = manager;
		listaPersonas[1] = employee;
		listaPersonas[2] = employee1;
		listaPersonas[3] = outsideConsultant;
		
		for(Person p : listaPersonas) {
			System.out.println(p);
		}
		
	}

}
