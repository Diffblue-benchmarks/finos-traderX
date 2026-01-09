package finos.traderx.messaging.socketio;

import finos.traderx.messaging.Envelope;
import finos.traderx.tradeprocessor.TradeFeedHandler;
import finos.traderx.tradeprocessor.model.TradeOrder;
import finos.traderx.tradeprocessor.service.TradeService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Custom base class for testing SocketIOJSONSubscriber methods through TradeFeedHandler.
 *
 * This provides a proper Spring test configuration that creates a TradeFeedHandler bean
 * (which extends SocketIOJSONSubscriber) and mocks the required TradeService dependency,
 * allowing the ApplicationContext to load successfully.
 *
 * Diffblue Cover automatically detects this class based on the naming convention:
 * [ClassUnderTest]DiffblueBase in the same package.
 *
 * When Cover tests SocketIOJSONSubscriber methods, it needs a concrete implementation.
 * It uses TradeFeedHandler as the concrete class, so we provide a proper Spring configuration
 * for it here.
 */
@ContextConfiguration(classes = {SocketIOJSONSubscriberDiffblueBase.TestConfig.class})
@ExtendWith(SpringExtension.class)
public abstract class SocketIOJSONSubscriberDiffblueBase {

    @MockBean
    protected TradeService tradeService;

    @Configuration
    static class TestConfig {
        @Bean
        public SocketIOJSONSubscriber<TradeOrder> socketIOJSONSubscriber() {
            TradeFeedHandler handler = new TradeFeedHandler() {
                @Override
                public void afterPropertiesSet() throws Exception {
                    // Override to prevent automatic connection during bean initialization in tests
                }
            };
            return handler;
        }
    }
}
