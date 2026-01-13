package finos.traderx.tradeprocessor;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import finos.traderx.messaging.Envelope;
import finos.traderx.messaging.Publisher;
import finos.traderx.messaging.Subscriber;
import finos.traderx.tradeprocessor.model.Position;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.model.TradeOrder;

/**
 * Base class for Diffblue Cover tests for PubSubConfig.
 *
 * This base class solves the Spring context loading issue where Spring Boot's @MockBean
 * cannot determine which Publisher bean to mock when there are multiple Publisher beans
 * with different generic types (Publisher<Position> and Publisher<Trade>).
 *
 * The solution is to:
 * 1. Load both PubSubConfig and a TestConfig that provides @Primary mock beans
 * 2. The @Primary beans override the real Publisher/Subscriber beans from PubSubConfig
 * 3. This prevents Spring from attempting to auto-mock with @MockBean
 *
 * Diffblue Cover will automatically use this base class for tests of PubSubConfig methods.
 */
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PubSubConfig.class, PubSubConfigDiffblueBase.TestConfig.class})
@TestPropertySource(properties = {"trade.feed.address=http://localhost:18080"})
public abstract class PubSubConfigDiffblueBase {

    @TestConfiguration
    public static class TestConfig {

        @Bean
        @Primary
        public Publisher<Position> positionPublisher() {
            return new Publisher<Position>() {
                @Override
                public void publish(Position message) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void publish(String topic, Position message) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public boolean isConnected() {
                    return false;
                }

                @Override
                public void connect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void disconnect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }
            };
        }

        @Bean
        @Primary
        public Publisher<Trade> tradePublisher() {
            return new Publisher<Trade>() {
                @Override
                public void publish(Trade message) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void publish(String topic, Trade message) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public boolean isConnected() {
                    return false;
                }

                @Override
                public void connect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void disconnect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }
            };
        }

        @Bean
        @Primary
        public Subscriber<TradeOrder> tradeFeedHandler() {
            return new Subscriber<TradeOrder>() {
                @Override
                public void subscribe(String topic) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void unsubscribe(String topic) throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void onMessage(Envelope<?> envelope, TradeOrder message) {
                    // No-op for testing
                }

                @Override
                public boolean isConnected() {
                    return false;
                }

                @Override
                public void connect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }

                @Override
                public void disconnect() throws finos.traderx.messaging.PubSubException {
                    // No-op for testing
                }
            };
        }
    }
}
