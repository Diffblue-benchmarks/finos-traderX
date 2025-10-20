package finos.traderx.positionservice.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.positionservice.model.Position;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class PositionRepositoryFactory {

    @InterestingTestFactory
    public static Example<Position> createPositionExample() {
        Position position = new Position();
        position.setAccountId(1);
        position.setSecurity("AAPL");
        position.setQuantity(100);
        position.setUpdated(new Date());

        return Example.of(position);
    }

    @InterestingTestFactory
    public static Function<FluentQuery.FetchableFluentQuery<Position>, List<Position>> createFluentQueryFunction() {
        return query -> query.all();
    }

    @InterestingTestFactory
    public static Function<FluentQuery.FetchableFluentQuery<Position>, Position> createFluentQueryFunctionForOne() {
        return query -> query.first().orElse(null);
    }
}
