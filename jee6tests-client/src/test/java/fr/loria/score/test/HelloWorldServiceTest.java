package fr.loria.score.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Properties;

import javax.naming.InitialContext;

import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

import fr.loria.score.ejb.HelloWorldService;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 24 March 2010
 */
public class HelloWorldServiceTest {
	
	public static junit.framework.Test suite() { 
	    return new JUnit4TestAdapter(HelloWorldServiceTest.class); 
	}
	
	private static HelloWorldService getService() throws Exception {
		Properties properties = new Properties();
        properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        properties.put("java.naming.provider.url", "localhost:1099");
        InitialContext jndi = new InitialContext(properties);
        HelloWorldService service = (HelloWorldService) jndi.lookup("HelloWorldServiceBean/remote");
        return service;
	}

	@Test
	public void testSayHelloWorld() {
		try {
			getService().sayHelloWorld();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSayHello() {
		try {
			String message = getService().sayHello("misterb");
			System.out.println(message);
			assertEquals("Hello misterb !!", message);
		} catch ( Exception e ) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testSayHelloToName() {
		try {
			getService().createName("MisterB", "titi");
			String message = getService().sayHello(1);
			System.out.println(message);
			assertEquals("Hello MisterB !!", message);
		} catch ( Exception e ) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testListNames() {
		try {
			getService().listNames();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFindNames() {
		try {
			getService().createName("MisterBB", "toto");
			getService().findNamesWithMetadata("toto");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
