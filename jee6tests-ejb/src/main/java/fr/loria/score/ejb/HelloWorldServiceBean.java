package fr.loria.score.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class HelloWorldServiceBean implements HelloWorldService {

	@PersistenceContext
	private EntityManager manager;

	public HelloWorldServiceBean() {
	}

	@Override
	public String sayHello(String name) {
		String message = "Hello " + name + " !!";
		System.out.println(message);
		return message;
	}

	@Override
	public void sayHelloWorld() {
		System.out.println("Hello World !!");
	}

	@Override
	public void createName(String name, String metadata) {
		Name n = new Name();
		n.setName(name);
		n.addMetadata(metadata);
		manager.persist(n);
	}

	@Override
	public String sayHello(int id) {
		try {
			Name name= manager.find(Name.class, new Long(id));
			String message = "Hello " + name.getName() + " !!";
			System.out.println(message);
			return message;
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public void listNames() {
		try {
			List<Name> names = manager.createNamedQuery("findAllNames").getResultList();
			for(Name name : names) {
				System.out.println("Name[" + name.getId() + "] " + name.getName());
			}
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void findNamesWithMetadata(String metadata) {
		try {
			List<Name> names = manager.createNamedQuery("findNameByMetadata").setParameter("metadata", metadata).getResultList();
			for(Name name : names) {
				System.out.println("Name[" + name.getId() + "] " + name.getName());
			}
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}

}
