package finos.traderx.tradeprocessor;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import finos.traderx.messaging.Subscriber;
import finos.traderx.tradeprocessor.model.TradeOrder;

/**
 * Test configuration for TradeFeedHandler to support Diffblue Cover test generation.
 * This provides proper Spring configuration when testing requires Spring context.
 */
@TestConfiguration
public class TradeFeedHandlerTestConfig {

    @Bean
    @Primary
    public Subscriber<TradeOrder> tradeFeedHandler() {
        TradeFeedHandler handler = new TradeFeedHandler();
        // Don't set socket address to avoid connection attempts during testing
        return handler;
    }
}
