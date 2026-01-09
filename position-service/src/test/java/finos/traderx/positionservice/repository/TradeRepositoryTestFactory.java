package finos.traderx.positionservice.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.positionservice.model.Trade;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.data.domain.Example;

/**
 * Factory class for creating test objects for TradeRepository tests.
 * This factory provides methods to create valid Example instances for testing.
 */
public class TradeRepositoryTestFactory {

  /**
   * Creates a valid Example&lt;Trade&gt; instance for testing the findBy method.
   * The Example is created with a Trade object that has all required fields set.
   *
   * @return a non-null Example&lt;Trade&gt; instance suitable for repository testing
   */
  @InterestingTestFactory
  public static Example<Trade> createTradeExample() {
    Trade trade = new Trade();
    trade.setId("test-trade-id");
    trade.setAccountId(1);
    trade.setSecurity("Security");
    trade.setSide("BUY");
    trade.setState("SETTLED");
    trade.setQuantity(100);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    return Example.of(trade);
  }
}
