package telran.ashkelon2018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SensorGeneratorApplication {

	private static long timeout = 10000;

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SensorGeneratorApplication.class, args);
		try {
			Thread.sleep(timeout);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally{
			context.close();
		}
		
	}

}

