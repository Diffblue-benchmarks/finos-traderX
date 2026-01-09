package finos.traderx.tradeprocessor.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.tradeprocessor.model.Position;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.data.domain.Example;

/**
 * Factory class for creating test objects for PositionRepository tests.
 * This factory provides methods to create valid Example instances for testing.
 */
public class PositionRepositoryTestFactory {

  /**
   * Creates a valid Example&lt;Position&gt; instance for testing the findBy method.
   * The Example is created with a Position object that has all required fields set.
   *
   * @return a non-null Example&lt;Position&gt; instance suitable for repository testing
   */
  @InterestingTestFactory
  public static Example<Position> createPositionExample() {
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    return Example.of(position);
  }
}
