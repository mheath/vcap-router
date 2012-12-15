package vcap.router;

import nats.client.Nats;
import nats.vcap.message.RouterStart;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
@Component("router")
public class Router implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(Router.class);

	private static final String SUBJECT_ROUTER_START = "router.start";

	static public String generateId() {
		final SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[16];
		random.nextBytes(bytes);
		return new BigInteger(bytes).abs().toString(16);
	}

	private final Nats nats;
	private final String routerStartMessage;

	@Inject
	public Router(Nats nats, @Named("routerId") String routerId, @Named("version") String version) throws IOException {
		this.nats = nats;
		final ObjectMapper mapper = new ObjectMapper();
		routerStartMessage = mapper.writeValueAsString(new RouterStart(routerId, version));

	}

	public void broadcastPresence() {
		LOGGER.debug("Broadcasting presence to mbus.");
		nats.publish(SUBJECT_ROUTER_START, routerStartMessage);
	}

	@Override
	public void run() {
		LOGGER.info("Router started...");
	}
}
