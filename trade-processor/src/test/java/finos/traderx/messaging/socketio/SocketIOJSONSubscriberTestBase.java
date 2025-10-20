package finos.traderx.messaging.socketio;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import finos.traderx.tradeprocessor.TradeProcessorApplication;
import finos.traderx.tradeprocessor.service.TradeService;

/**
 * Custom base class for testing SocketIOJSONSubscriber and its subclasses.
 * This ensures proper Spring Boot context initialization for Diffblue Cover tests.
 */
@SpringBootTest(classes = TradeProcessorApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public abstract class SocketIOJSONSubscriberTestBase {

    @MockBean
    protected TradeService tradeService;

    // Base class for SocketIOJSONSubscriber tests
    // This provides proper Spring Boot application context with mocked dependencies
}
