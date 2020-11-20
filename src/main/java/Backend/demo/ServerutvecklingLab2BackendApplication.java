package Backend.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class ServerutvecklingLab2BackendApplication {

	public static void main(String[] args) {
		Timestamp x = new Timestamp(System.currentTimeMillis());
		System.out.println(x);
		SpringApplication.run(ServerutvecklingLab2BackendApplication.class, args);
	}

}
