package fr.loria.score.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldService {
	
	public void sayHelloWorld();

	public String sayHello(String name);
	
	public void createName(String name, String metadata);
	
	public String sayHello(int id);
	
	public void listNames();
	
	public void findNamesWithMetadata(String metadata);
	
}
