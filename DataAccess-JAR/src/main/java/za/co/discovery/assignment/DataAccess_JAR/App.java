package za.co.discovery.assignment.DataAccess_JAR;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import za.co.discovery.assignment.dao.PlanetDao;
import za.co.discovery.assignment.entity.Planet;

/**
 * <h1>App</h1> The App program provides testing
 * 
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
public class App {
	public static void main(String[] args) {
		// System.out.println("Hello World!");
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(
				"za.co.discovery.assignment");
		PlanetDao dao = (PlanetDao) context.getBean("nodeDao");
		List<Planet> nodes = dao.findAllNodes();
		for (Planet node : nodes) {
			System.out.println(node.getId());
			System.out.println(node.getPlanetNode());
			System.out.println(node.getPlanetNode());

		}
	}
}
