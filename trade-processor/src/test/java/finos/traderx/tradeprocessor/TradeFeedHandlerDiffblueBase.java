package finos.traderx.tradeprocessor;

import finos.traderx.tradeprocessor.service.TradeService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Custom base class for testing TradeFeedHandler with Spring.
 *
 * This provides a proper Spring test configuration that creates a TradeFeedHandler bean
 * and mocks the required TradeService dependency, allowing the ApplicationContext to load successfully.
 *
 * Diffblue Cover automatically detects this class based on the naming convention:
 * [ClassUnderTest]DiffblueBase in the same package.
 *
 * This resolves the ApplicationContext loading failure by providing a valid Spring configuration
 * instead of using TradeFeedHandler.class directly in @ContextConfiguration.
 */
@ContextConfiguration(classes = {TradeFeedHandlerDiffblueBase.TestConfig.class})
@ExtendWith(SpringExtension.class)
public abstract class TradeFeedHandlerDiffblueBase {

    @MockBean
    protected TradeService tradeService;

    @Configuration
    static class TestConfig {
        @Bean
        public TradeFeedHandler tradeFeedHandler() {
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
