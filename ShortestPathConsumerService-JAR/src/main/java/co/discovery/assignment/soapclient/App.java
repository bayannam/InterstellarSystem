/*package co.discovery.assignment.soapclient;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import za.co.discovery.asignment.shortPathStubs.FindShortestPathRequest;
import za.co.discovery.asignment.shortPathStubs.FindShortestPathResponse;
import za.co.discovery.asignment.shortPathStubs.ObjectFactory;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// @SuppressWarnings("resource")
		
		 * AnnotationConfigApplicationContext context = new
		 * AnnotationConfigApplicationContext( ServiceConfig.class);
		 
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "springbeans.xml" });
			System.out.println(context.getBeanDefinitionCount());
			WebServiceTemplate template = (WebServiceTemplate) context
					.getBean("shortestPathTemplate");
			ObjectFactory factory = new ObjectFactory();
			FindShortestPathRequest request = factory
					.createFindShortestPathRequest();
			request.setOriginPlanetName("A");
			request.setDestPlanetName("Z");
			FindShortestPathResponse resp = (FindShortestPathResponse) template
					.marshalSendAndReceive(request);
			System.out.println(resp.getPath());

			
			 * ShortestPathClient wsclient = (ShortestPathClient) context
			 * .getBean(ShortestPathClient.class); FindShortestPathResponse resp
			 * = wsclient.getShortestPath("A","Z"); System.out.println(resp);
			 * wsclient.printResp(resp);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/