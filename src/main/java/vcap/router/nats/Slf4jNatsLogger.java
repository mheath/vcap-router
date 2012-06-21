package vcap.router.nats;

import nats.NatsLogger;
import nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mike Heath <heathma@ldschurch.org>
 */
public class Slf4jNatsLogger implements NatsLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(Nats.class);

	@Override
	public void log(Level level, String message) {
		switch (level) {
			case DEBUG:
				LOGGER.debug(message);
				break;
			case ERROR:
				LOGGER.error(message);
				break;
			case WARNING:
				LOGGER.warn(message);
				break;
		}
	}

	@Override
	public void log(Level level, Throwable t) {
		switch (level) {
			case DEBUG:
				LOGGER.debug(t.getMessage(), t);
				break;
			case ERROR:
				LOGGER.error(t.getMessage(), t);
				break;
			case WARNING:
				LOGGER.warn(t.getMessage(), t);
				break;
		}
	}
}
