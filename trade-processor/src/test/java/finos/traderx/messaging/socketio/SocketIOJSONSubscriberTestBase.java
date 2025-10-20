package finos.traderx.messaging.socketio;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import finos.traderx.messaging.Publisher;
import finos.traderx.messaging.Subscriber;
import finos.traderx.tradeprocessor.TradeProcessorApplication;
import finos.traderx.tradeprocessor.model.Position;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.model.TradeOrder;
import finos.traderx.tradeprocessor.service.TradeService;

/**
 * Custom base class for testing SocketIOJSONSubscriber and its subclasses.
 * This ensures proper Spring Boot context initialization for Diffblue Cover tests.
 *
 * This base class mocks the beans that would normally try to connect to external
 * SocketIO servers during application context initialization, preventing connection
 * failures during testing.
 */
@SpringBootTest(classes = TradeProcessorApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public abstract class SocketIOJSONSubscriberTestBase {

    @MockBean
    protected TradeService tradeService;

    // Mock the subscriber bean to prevent auto-connection during context initialization
    @MockBean
    protected Subscriber<TradeOrder> tradeFeedHandler;

    // Mock the publisher beans to prevent auto-connection during context initialization
    @MockBean
    protected Publisher<Trade> tradePublisher;

    @MockBean
    protected Publisher<Position> positionPublisher;

    // Base class for SocketIOJSONSubscriber tests
    // This provides proper Spring Boot application context with mocked dependencies
}
