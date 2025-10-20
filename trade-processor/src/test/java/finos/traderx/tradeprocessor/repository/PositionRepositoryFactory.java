package finos.traderx.tradeprocessor.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.tradeprocessor.model.Position;
import org.springframework.data.domain.Example;

public class PositionRepositoryFactory {

    @InterestingTestFactory
    public static Example<Position> createPositionExample() {
        Position position = new Position();
        position.setAccountId(1);
        position.setSecurity("AAPL");
        position.setQuantity(100);

        return Example.of(position);
    }
}
