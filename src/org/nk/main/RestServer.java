package org.nk.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.nk.resource.PeerNodeResource;

public class RestServer {

	public static void main(String[] args) {
		RestServer restServer = new RestServer();
		restServer.startServer();

	}

	public void startServer(){
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		jerseyServlet.setInitParameter(
				"jersey.config.server.provider.classnames",
				PeerNodeResource.class.getCanonicalName());

		try {
			jettyServer.start();
			jettyServer.join();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			jettyServer.destroy();
		}
	}		

}
