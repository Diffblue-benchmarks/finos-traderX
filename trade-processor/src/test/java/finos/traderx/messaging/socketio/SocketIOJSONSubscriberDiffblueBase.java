package finos.traderx.messaging.socketio;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import finos.traderx.tradeprocessor.TradeProcessorApplication;
import finos.traderx.tradeprocessor.service.TradeService;

/**
 * Custom base class for testing SocketIOJSONSubscriber and its subclasses.
 * This ensures proper Spring Boot context initialization for Diffblue Cover tests.
 *
 * This base class uses TestPubSubConfig to provide mock beans that override
 * the real PubSubConfig beans, preventing the InitializingBean.afterPropertiesSet()
 * from attempting to connect to external SocketIO servers during application
 * context initialization.
 */
@SpringBootTest(classes = TradeProcessorApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Import(TestPubSubConfig.class)
public abstract class SocketIOJSONSubscriberDiffblueBase {

    @MockBean
    protected TradeService tradeService;

    // Base class for SocketIOJSONSubscriber tests
    // This provides proper Spring Boot application context with mocked dependencies
    // The TestPubSubConfig provides the necessary mock beans for publishers and subscribers
}
