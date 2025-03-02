package com.m0wn1la.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class App2Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
	//context(done),filter for security(done),threads,global exception handler,versioning in controllers(done)
//filter will check authheader and try to get user and set in context
	//in all contollers this check needed at put,delete requests check the context user is trying to update or not
	//so one filter to set the user context
	//another filter which would check put,delete requests  and throws err


	//so user need to have password or hash the password
}
