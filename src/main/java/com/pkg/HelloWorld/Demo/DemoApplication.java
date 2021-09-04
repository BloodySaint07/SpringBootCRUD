package com.pkg.HelloWorld.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication  implements CommandLineRunner {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("Hello world from Command Line Runner");
		// PlayerInfo info=new PlayerInfo("Ruben Dias","DEF","MCITY");
//			
//			try {
//				repo1.save(info);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("Exception in Command Line Runner");
//			}
//		 
	}
	
	
	
	

}
