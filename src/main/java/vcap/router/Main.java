package vcap.router;

import nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;

import javax.inject.Inject;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
public class Main implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private final TaskScheduler scheduler;

	@Inject
	public Main(TaskScheduler scheduler, Nats nats) {
		this.scheduler = scheduler;
		nats.publish("test", "NATS rules!");
	}

	public static void main(String[] args) {
		LOGGER.info("Starting router...");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		context.getBean(Main.class).run();
	}

	@Override
	public void run() {
	}

	public void test() {
		LOGGER.info("Hello there");
	}
}
