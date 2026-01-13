package finos.traderx.positionservice.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.positionservice.model.Position;
import finos.traderx.positionservice.model.PositionID;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Factory class for creating test data for PositionRepository tests.
 * This class provides factory methods to create valid objects required by Diffblue Cover
 * for testing PositionRepository.
 */
public class PositionRepositoryFactory {

    /**
     * Creates a valid Example<Position> object for testing the findBy method.
     * This factory method ensures that the Example parameter is not null, which would
     * otherwise cause an InvalidDataAccessApiUsageException.
     *
     * @return a non-null Example<Position> with a probe Position object
     */
    @InterestingTestFactory
    public static Example<Position> createPositionExample() {
        Position position = new Position();
        position.setAccountId(1);
        position.setSecurity("TEST_SECURITY");
        position.setQuantity(100);
        position.setUpdated(Date.from(LocalDate.of(2024, 1, 1)
                .atStartOfDay()
                .atZone(ZoneOffset.UTC)
                .toInstant()));

        return Example.of(position);
    }

    /**
     * Creates an alternative Example<Position> with different values for varied test scenarios.
     *
     * @return a non-null Example<Position> with different probe values
     */
    @InterestingTestFactory
    public static Example<Position> createPositionExampleVariant() {
        Position position = new Position();
        position.setAccountId(42);
        position.setSecurity("AAPL");
        position.setQuantity(50);
        position.setUpdated(Date.from(LocalDate.of(2023, 6, 15)
                .atStartOfDay()
                .atZone(ZoneOffset.UTC)
                .toInstant()));

        return Example.of(position);
    }

    /**
     * Creates an Example<Position> with minimal required fields set.
     *
     * @return a non-null Example<Position> with only ID fields populated
     */
    @InterestingTestFactory
    public static Example<Position> createMinimalPositionExample() {
        Position position = new Position();
        position.setAccountId(1);
        position.setSecurity("SEC");

        return Example.of(position);
    }
}
