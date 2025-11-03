package finos.traderx.positionservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import finos.traderx.positionservice.model.Trade;
import finos.traderx.positionservice.repository.TradeRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TradeService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TradeServiceDiffblueTest {
  @MockBean
  private TradeRepository tradeRepository;

  @Autowired
  private TradeService tradeService;

  /**
   * Method under test: {@link TradeService#getAllTrades()}
   */
  @Test
  void testGetAllTrades() {
    // Arrange
    when(tradeRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Trade> actualAllTrades = tradeService.getAllTrades();

    // Assert
    verify(tradeRepository).findAll();
    assertTrue(actualAllTrades.isEmpty());
  }

  /**
   * Method under test: {@link TradeService#getAllTrades()}
   */
  @Test
  void testGetAllTrades2() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide("Side");
    trade.setState("MD");
    trade.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Trade> tradeList = new ArrayList<>();
    tradeList.add(trade);
    when(tradeRepository.findAll()).thenReturn(tradeList);

    // Act
    List<Trade> actualAllTrades = tradeService.getAllTrades();

    // Assert
    verify(tradeRepository).findAll();
    assertEquals(tradeList, actualAllTrades);
  }

  /**
   * Method under test: {@link TradeService#getAllTrades()}
   */
  @Test
  void testGetAllTrades3() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide("Side");
    trade.setState("MD");
    trade.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(0);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Trade> tradeList = new ArrayList<>();
    tradeList.add(trade2);
    tradeList.add(trade);
    when(tradeRepository.findAll()).thenReturn(tradeList);

    // Act
    List<Trade> actualAllTrades = tradeService.getAllTrades();

    // Assert
    verify(tradeRepository).findAll();
    assertEquals(tradeList, actualAllTrades);
  }

  /**
   * Method under test: {@link TradeService#getTradesByAccountID(int)}
   */
  @Test
  void testGetTradesByAccountID() {
    // Arrange
    ArrayList<Trade> tradeList = new ArrayList<>();
    when(tradeRepository.findByAccountId(Mockito.<Integer>any())).thenReturn(tradeList);

    // Act
    List<Trade> actualTradesByAccountID = tradeService.getTradesByAccountID(1);

    // Assert
    verify(tradeRepository).findByAccountId(eq(1));
    assertTrue(actualTradesByAccountID.isEmpty());
    assertSame(tradeList, actualTradesByAccountID);
  }
}
