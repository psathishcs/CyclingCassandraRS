package org.cycling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/**
 * 
 * @author SathishParthasarathy
 * Jul 29, 20176:54:38 PM
 */
@SpringBootApplication
@ImportResource("classpath:cassandra-config.xml")
public class CyclingApplication {
	public static void main(String[] args){
		SpringApplication.run(CyclingApplication.class, args);
	}
}
