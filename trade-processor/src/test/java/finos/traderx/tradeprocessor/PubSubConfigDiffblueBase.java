package finos.traderx.tradeprocessor;

import finos.traderx.messaging.Publisher;
import finos.traderx.tradeprocessor.model.Position;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.service.TradeService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Custom base class for testing PubSubConfig.
 * This resolves the ambiguity when mocking Publisher beans by explicitly
 * qualifying each Publisher bean by name, and also mocks the TradeService
 * dependency needed by the TradeFeedHandler bean created in PubSubConfig.
 *
 * Diffblue Cover automatically detects this class based on the naming convention:
 * [ClassUnderTest]DiffblueBase in the same package.
 *
 * This addresses the issue where Spring cannot determine which Publisher bean
 * to mock when there are multiple Publisher beans (positionPublisher and tradePublisher),
 * and ensures the TradeFeedHandler bean can be instantiated with its required dependencies.
 */
@ContextConfiguration(classes = {PubSubConfig.class})
@ExtendWith(SpringExtension.class)
public abstract class PubSubConfigDiffblueBase {

    @MockBean(name = "positionPublisher")
    protected Publisher<Position> positionPublisher;

    @MockBean(name = "tradePublisher")
    protected Publisher<Trade> tradePublisher;

    @MockBean
    protected TradeService tradeService;
}
