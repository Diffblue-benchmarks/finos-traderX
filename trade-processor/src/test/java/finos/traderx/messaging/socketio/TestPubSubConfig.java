package finos.traderx.messaging.socketio;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;

import finos.traderx.messaging.Publisher;
import finos.traderx.messaging.Subscriber;
import finos.traderx.tradeprocessor.model.Position;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.model.TradeOrder;

/**
 * Test configuration that provides mock beans for PubSub components.
 * This prevents the real beans from being created and attempting to
 * connect to external SocketIO servers during test context initialization.
 */
@TestConfiguration
@Profile("test")
public class TestPubSubConfig {

    @MockBean
    public Publisher<Position> positionPublisher;

    @MockBean
    public Publisher<Trade> tradePublisher;

    @MockBean
    public Subscriber<TradeOrder> tradeFeedHandler;
}
