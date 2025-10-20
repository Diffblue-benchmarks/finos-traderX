package finos.traderx.messaging.socketio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Verification test to ensure the base class can successfully load the Spring context.
 * This test confirms that Diffblue Cover can use this base class for generating tests.
 */
public class SocketIOJSONSubscriberTestBaseVerificationTest extends SocketIOJSONSubscriberTestBase {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testContextLoads() {
        assertNotNull(applicationContext, "Spring context should load successfully");
    }
}
