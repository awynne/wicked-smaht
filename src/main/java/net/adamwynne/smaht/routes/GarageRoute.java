package net.adamwynne.smaht.routes;

import org.apache.camel.builder.RouteBuilder;

public class GarageRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// Access us using http://localhost:8080/camel/hello
		from("servlet:///hello").transform().constant("Hello from Camel!");

        from("activemq:topic:garagedoor.event").log("GOT AN EVENT");

		// Trigger run right after startup. No Servlet request required.
		//from("timer://foo?fixedRate=true&period=10s").log("Camel timer triggered.");
	}
}
