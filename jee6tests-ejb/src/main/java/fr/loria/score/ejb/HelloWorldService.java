package fr.loria.score.ejb;

import javax.ejb.Remote;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 24 March 2010
 */
@Remote
public interface HelloWorldService {
	
	public void sayHelloWorld();

	public String sayHello(String name);
	
	public void createName(String name, String metadata);
	
	public String sayHello(int id);
	
	public void listNames();
	
	public void findNamesWithMetadata(String metadata);
	
}
