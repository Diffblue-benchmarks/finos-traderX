package finos.traderx.tradeprocessor.repository;

import com.diffblue.cover.annotations.InterestingTestFactory;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.model.TradeSide;
import finos.traderx.tradeprocessor.model.TradeState;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class TradeRepositoryFactory {

    @InterestingTestFactory
    public static Example<Trade> createTradeExample() {
        Trade trade = new Trade();
        trade.setId("TRADE123");
        trade.setAccountId(1);
        trade.setSecurity("AAPL");
        trade.setSide(TradeSide.Buy);
        trade.setState(TradeState.New);
        trade.setQuantity(100);
        trade.setCreated(new Date());
        trade.setUpdated(new Date());

        return Example.of(trade);
    }

    @InterestingTestFactory
    public static Function<FluentQuery.FetchableFluentQuery<Trade>, List<Trade>> createFluentQueryFunction() {
        return query -> query.all();
    }

    @InterestingTestFactory
    public static Function<FluentQuery.FetchableFluentQuery<Trade>, Trade> createFluentQueryFunctionForOne() {
        return query -> query.first().orElse(null);
    }
}
