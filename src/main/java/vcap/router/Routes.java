package vcap.router;

import nats.client.Message;
import org.springframework.stereotype.Component;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
@Component("routes")
public class Routes {

	public void test(Message message) {
		System.out.println(message);
	}

}
