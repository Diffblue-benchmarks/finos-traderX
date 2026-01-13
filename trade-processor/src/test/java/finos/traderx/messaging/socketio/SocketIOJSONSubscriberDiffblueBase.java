package finos.traderx.messaging.socketio;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import finos.traderx.tradeprocessor.TradeFeedHandler;
import finos.traderx.tradeprocessor.model.TradeOrder;
import finos.traderx.tradeprocessor.service.TradeService;

import static org.mockito.Mockito.mock;

/**
 * Custom base class for SocketIOJSONSubscriber tests to avoid Spring context loading issues.
 *
 * This base class is intentionally minimal to avoid Spring context initialization.
 * Diffblue Cover will automatically extend this base class when generating tests for
 * SocketIOJSONSubscriber and its subclasses.
 *
 * The test configuration provides a properly configured TradeFeedHandler bean that:
 * 1. Won't attempt socket connections during test initialization
 * 2. Has all required dependencies mocked
 * 3. Can be used for unit testing individual methods
 */
public abstract class SocketIOJSONSubscriberDiffblueBase {

    @TestConfiguration
    public static class TestConfig {

        /**
         * Provides a mocked TradeService to avoid real service dependencies
         */
        @Bean
        @Primary
        public TradeService tradeService() {
            return mock(TradeService.class);
        }

        /**
         * Provides a TradeFeedHandler instance that won't try to connect during initialization.
         * This is crucial because SocketIOJSONSubscriber implements InitializingBean and
         * normally tries to connect to a socket in afterPropertiesSet().
         */
        @Bean
        @Primary
        public SocketIOJSONSubscriber<TradeOrder> socketIOJSONSubscriber(TradeService tradeService) {
            // Create a TradeFeedHandler that won't try to connect during initialization
            TradeFeedHandler handler = new TradeFeedHandler() {
                @Override
                public void afterPropertiesSet() throws Exception {
                    // Override to prevent socket connection during test context initialization
                    // Individual tests can manually call connect() if needed
                }
            };
            // Manually inject dependencies using reflection since the override
            // prevents normal Spring autowiring
            try {
                java.lang.reflect.Field field = TradeFeedHandler.class.getDeclaredField("tradeService");
                field.setAccessible(true);
                field.set(handler, tradeService);
            } catch (Exception e) {
                throw new RuntimeException("Failed to inject TradeService into TradeFeedHandler", e);
            }
            return handler;
        }
    }
}
