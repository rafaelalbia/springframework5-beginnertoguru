package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
	
    PropertyInjectedController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		controller = new PropertyInjectedController();
		
		controller.greetingService = new GreetingServiceImpl();
	}

	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
