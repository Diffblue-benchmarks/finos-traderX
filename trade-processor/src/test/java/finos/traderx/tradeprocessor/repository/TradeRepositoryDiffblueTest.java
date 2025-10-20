package finos.traderx.tradeprocessor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import finos.traderx.tradeprocessor.model.Trade;
import finos.traderx.tradeprocessor.model.TradeSide;
import finos.traderx.tradeprocessor.model.TradeState;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TradeRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.tradeprocessor.model"})
class TradeRepositoryDiffblueTest {
  @Autowired private TradeRepository tradeRepository;

  /**
   * Test {@link TradeRepository#findByAccountId(Integer)}.
   *
   * <p>Method under test: {@link TradeRepository#findByAccountId(Integer)}
   */
  @Test
  @DisplayName("Test findByAccountId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findByAccountId(Integer)"})
  void testFindByAccountId() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindByAccountIdResult = tradeRepository.findByAccountId(1);

    // Assert
    assertEquals(1, actualFindByAccountIdResult.size());
    Trade getResult = actualFindByAccountIdResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#count()}.
   *
   * <p>Method under test: {@link TradeRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TradeRepository.count()"})
  void testCount() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act and Assert
    assertEquals(2L, tradeRepository.count());
  }

  /**
   * Test {@link TradeRepository#count(Example)} with {@code Example}.
   *
   * <p>Method under test: {@link TradeRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TradeRepository.count(Example)"})
  void testCountWithExample() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertEquals(1L, tradeRepository.count(example));
  }

  /**
   * Test {@link TradeRepository#delete(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.delete(Object)"})
  void testDelete() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    tradeRepository.delete(trade3);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#deleteAll()}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAll()"})
  void testDeleteAll() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.deleteAll();

    // Assert
    assertTrue(tradeRepository.findAll().isEmpty());
  }

  /**
   * Test {@link TradeRepository#deleteAllById(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAllById(Iterable)"})
  void testDeleteAllById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide(TradeSide.Buy);
    trade4.setState(TradeState.New);
    trade4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide(TradeSide.Buy);
    trade5.setState(TradeState.New);
    trade5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);
    List<String> ids = Arrays.asList(trade3.getId(), trade4.getId(), trade5.getId());

    // Act
    tradeRepository.deleteAllById(ids);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#deleteAllByIdInBatch(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAllByIdInBatch(Iterable)"})
  void testDeleteAllByIdInBatch() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.deleteAllByIdInBatch(new ArrayList<>());

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(2, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = findAllResult.get(1);
    assertEquals("42", getResult2.getSecurity());
    assertEquals("Id", getResult2.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeSide.Sell, getResult2.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertEquals(TradeState.Processing, getResult2.getState());
  }

  /**
   * Test {@link TradeRepository#deleteAllInBatch()}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAllInBatch()}
   */
  @Test
  @DisplayName("Test deleteAllInBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAllInBatch()"})
  void testDeleteAllInBatch() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.deleteAllInBatch();

    // Assert
    assertTrue(tradeRepository.findAll().isEmpty());
  }

  /**
   * Test {@link TradeRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAllInBatch(Iterable)"})
  void testDeleteAllInBatchWithIterable() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide(TradeSide.Buy);
    trade4.setState(TradeState.New);
    trade4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide(TradeSide.Buy);
    trade5.setState(TradeState.New);
    trade5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);

    List<Trade> entities = Arrays.asList(trade3, trade4, trade5);

    // Act
    tradeRepository.deleteAllInBatch(entities);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#deleteAll(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link TradeRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteAll(Iterable)"})
  void testDeleteAllWithIterable() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide(TradeSide.Buy);
    trade4.setState(TradeState.New);
    trade4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide(TradeSide.Buy);
    trade5.setState(TradeState.New);
    trade5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);

    List<Trade> entities = Arrays.asList(trade3, trade4, trade5);

    // Act
    tradeRepository.deleteAll(entities);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#deleteById(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteById(Object)"})
  void testDeleteById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String id = trade3.getId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    tradeRepository.deleteById(id);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#deleteInBatch(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.deleteInBatch(Iterable)"})
  void testDeleteInBatch() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide(TradeSide.Buy);
    trade4.setState(TradeState.New);
    trade4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide(TradeSide.Buy);
    trade5.setState(TradeState.New);
    trade5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);

    List<Trade> entities = Arrays.asList(trade3, trade4, trade5);

    // Act
    tradeRepository.deleteInBatch(entities);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals("Id", getResult.getId());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
    assertEquals(TradeSide.Sell, getResult.getSide());
    assertEquals(TradeState.Processing, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#existsById(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TradeRepository.existsById(Object)"})
  void testExistsById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String id = trade3.getId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act and Assert
    assertTrue(tradeRepository.existsById(id));
  }

  /**
   * Test {@link TradeRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Given {@link Trade} (default constructor) AccountId is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TradeRepository#exists(Example)}
   */
  @Test
  @DisplayName(
      "Test exists(Example); given Trade (default constructor) AccountId is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TradeRepository.exists(Example)"})
  void testExists_givenTradeAccountIdIsOne_thenReturnTrue() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertTrue(tradeRepository.exists(example));
  }

  /**
   * Test {@link TradeRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TradeRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TradeRepository.exists(Example)"})
  void testExists_thenReturnFalse() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(2);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertFalse(tradeRepository.exists(example));
  }

  /**
   * Test {@link TradeRepository#findAll()}.
   *
   * <p>Method under test: {@link TradeRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findAll()"})
  void testFindAll() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll();

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = actualFindAllResult.get(1);
    assertEquals("42", getResult2.getSecurity());
    assertEquals("Id", getResult2.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeSide.Sell, getResult2.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertEquals(TradeState.Processing, getResult2.getState());
  }

  /**
   * Test {@link TradeRepository#findAllById(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findAllById(Iterable)"})
  void testFindAllById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide(TradeSide.Buy);
    trade4.setState(TradeState.New);
    trade4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide(TradeSide.Buy);
    trade5.setState(TradeState.New);
    trade5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);
    List<String> ids = Arrays.asList(trade3.getId(), trade4.getId(), trade5.getId());

    // Act
    List<Trade> actualFindAllByIdResult = tradeRepository.findAllById(ids);

    // Assert
    assertEquals(1, actualFindAllByIdResult.size());
    Trade getResult = actualFindAllByIdResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#findAll(Example)} with {@code example}.
   *
   * <p>Method under test: {@link TradeRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findAll(Example)"})
  void testFindAllWithExample() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(example);

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#findAll(Example, Pageable)} with {@code example}, {@code pageable}.
   *
   * <p>Method under test: {@link TradeRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page TradeRepository.findAll(Example, Pageable)"})
  void testFindAllWithExamplePageable() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    Page<Trade> actualFindAllResult = tradeRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Trade> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    Trade getResult = toListResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#findAll(Example, Sort)} with {@code example}, {@code sort}.
   *
   * <ul>
   *   <li>When unsorted.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TradeRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName(
      "Test findAll(Example, Sort) with 'example', 'sort'; when unsorted; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findAll(Example, Sort)"})
  void testFindAllWithExampleSort_whenUnsorted_thenReturnSizeIsOne() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(example, Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
  }

  /**
   * Test {@link TradeRepository#findAll(Pageable)} with {@code pageable}.
   *
   * <p>Method under test: {@link TradeRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page TradeRepository.findAll(Pageable)"})
  void testFindAllWithPageable() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    Page<Trade> actualFindAllResult = tradeRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Trade> toListResult = actualFindAllResult.toList();
    assertEquals(2, toListResult.size());
    Trade getResult = toListResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = toListResult.get(1);
    assertEquals("42", getResult2.getSecurity());
    assertEquals("Id", getResult2.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeSide.Sell, getResult2.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertEquals(TradeState.Processing, getResult2.getState());
  }

  /**
   * Test {@link TradeRepository#findAll(Sort)} with {@code sort}.
   *
   * <ul>
   *   <li>When unsorted.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TradeRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'; when unsorted; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.findAll(Sort)"})
  void testFindAllWithSort_whenUnsorted_thenReturnSizeIsTwo() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = actualFindAllResult.get(1);
    assertEquals("42", getResult2.getSecurity());
    assertEquals("Id", getResult2.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeSide.Sell, getResult2.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertEquals(TradeState.Processing, getResult2.getState());
  }

  /**
   * Test {@link TradeRepository#findById(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TradeRepository.findById(Object)"})
  void testFindById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String id = trade3.getId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Optional<Trade> actualFindByIdResult = tradeRepository.findById(id);

    // Assert
    Trade getResult = actualFindByIdResult.get();
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertTrue(actualFindByIdResult.isPresent());
  }

  /**
   * Test {@link TradeRepository#findOne(Example)}.
   *
   * <p>Method under test: {@link TradeRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TradeRepository.findOne(Example)"})
  void testFindOne() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    Optional<Trade> actualFindOneResult = tradeRepository.findOne(example);

    // Assert
    Trade getResult = actualFindOneResult.get();
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertTrue(actualFindOneResult.isPresent());
  }

  /**
   * Test {@link TradeRepository#flush()}.
   *
   * <p>Method under test: {@link TradeRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TradeRepository.flush()"})
  void testFlush() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.flush();

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(2, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = findAllResult.get(1);
    assertEquals("42", getResult2.getSecurity());
    assertEquals("Id", getResult2.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeSide.Sell, getResult2.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertEquals(TradeState.Processing, getResult2.getState());
  }

  /**
   * Test {@link TradeRepository#getById(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#getById(Object)}
   */
  @Test
  @DisplayName("Test getById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TradeRepository.getById(Object)"})
  void testGetById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String id = trade3.getId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Trade actualById = tradeRepository.getById(id);

    // Assert
    assertEquals("42", actualById.getId());
    assertEquals("Security", actualById.getSecurity());
    assertEquals(1, actualById.getAccountId().intValue());
    assertEquals(1, actualById.getQuantity().intValue());
    assertEquals(TradeSide.Buy, actualById.getSide());
    assertEquals(TradeState.New, actualById.getState());
  }

  /**
   * Test {@link TradeRepository#getOne(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#getOne(Object)}
   */
  @Test
  @DisplayName("Test getOne(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TradeRepository.getOne(Object)"})
  void testGetOne() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    Trade actualOne = tradeRepository.getOne("42");

    // Assert
    assertEquals("42", actualOne.getId());
    assertEquals("Security", actualOne.getSecurity());
    assertEquals(1, actualOne.getAccountId().intValue());
    assertEquals(1, actualOne.getQuantity().intValue());
    assertEquals(TradeSide.Buy, actualOne.getSide());
    assertEquals(TradeState.New, actualOne.getState());
  }

  /**
   * Test {@link TradeRepository#getReferenceById(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#getReferenceById(Object)}
   */
  @Test
  @DisplayName("Test getReferenceById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TradeRepository.getReferenceById(Object)"})
  void testGetReferenceById() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(2);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("Id");
    trade2.setQuantity(-1);
    trade2.setSecurity("42");
    trade2.setSide(TradeSide.Sell);
    trade2.setState(TradeState.Processing);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    String id = trade3.getId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Trade actualReferenceById = tradeRepository.getReferenceById(id);

    // Assert
    assertEquals("42", actualReferenceById.getId());
    assertEquals("Security", actualReferenceById.getSecurity());
    assertEquals(1, actualReferenceById.getAccountId().intValue());
    assertEquals(1, actualReferenceById.getQuantity().intValue());
    assertEquals(TradeSide.Buy, actualReferenceById.getSide());
    assertEquals(TradeState.New, actualReferenceById.getState());
  }

  /**
   * Test {@link TradeRepository#save(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TradeRepository.save(Object)"})
  void testSave() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Trade actualSaveResult = tradeRepository.save(trade);

    // Assert
    assertEquals("42", actualSaveResult.getId());
    assertEquals("Security", actualSaveResult.getSecurity());
    assertEquals(1, actualSaveResult.getAccountId().intValue());
    assertEquals(1, actualSaveResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, actualSaveResult.getSide());
    assertEquals(TradeState.New, actualSaveResult.getState());
  }

  /**
   * Test {@link TradeRepository#saveAll(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.saveAll(Iterable)"})
  void testSaveAll() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(1);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("42");
    trade2.setQuantity(1);
    trade2.setSecurity("Security");
    trade2.setSide(TradeSide.Buy);
    trade2.setState(TradeState.New);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    List<Trade> entities = Arrays.asList(trade, trade2, trade3);

    // Act
    List<Trade> actualSaveAllResult = tradeRepository.saveAll(entities);

    // Assert
    assertEquals(3, actualSaveAllResult.size());
    Trade getResult = actualSaveAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertSame(getResult, actualSaveAllResult.get(1));
    assertSame(getResult, actualSaveAllResult.get(2));
  }

  /**
   * Test {@link TradeRepository#saveAllAndFlush(Iterable)}.
   *
   * <p>Method under test: {@link TradeRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TradeRepository.saveAllAndFlush(Iterable)"})
  void testSaveAllAndFlush() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade2 = new Trade();
    trade2.setAccountId(1);
    trade2.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("42");
    trade2.setQuantity(1);
    trade2.setSecurity("Security");
    trade2.setSide(TradeSide.Buy);
    trade2.setState(TradeState.New);
    trade2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide(TradeSide.Buy);
    trade3.setState(TradeState.New);
    trade3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    List<Trade> entities = Arrays.asList(trade, trade2, trade3);

    // Act
    List<Trade> actualSaveAllAndFlushResult = tradeRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(3, actualSaveAllAndFlushResult.size());
    Trade getResult = actualSaveAllAndFlushResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, getResult.getSide());
    assertEquals(TradeState.New, getResult.getState());
    assertSame(getResult, actualSaveAllAndFlushResult.get(1));
    assertSame(getResult, actualSaveAllAndFlushResult.get(2));
  }

  /**
   * Test {@link TradeRepository#saveAndFlush(Object)}.
   *
   * <p>Method under test: {@link TradeRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TradeRepository.saveAndFlush(Object)"})
  void testSaveAndFlush() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(1);
    trade.setCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade.setId("42");
    trade.setQuantity(1);
    trade.setSecurity("Security");
    trade.setSide(TradeSide.Buy);
    trade.setState(TradeState.New);
    trade.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Trade actualSaveAndFlushResult = tradeRepository.saveAndFlush(trade);

    // Assert
    assertEquals("42", actualSaveAndFlushResult.getId());
    assertEquals("Security", actualSaveAndFlushResult.getSecurity());
    assertEquals(1, actualSaveAndFlushResult.getAccountId().intValue());
    assertEquals(1, actualSaveAndFlushResult.getQuantity().intValue());
    assertEquals(TradeSide.Buy, actualSaveAndFlushResult.getSide());
    assertEquals(TradeState.New, actualSaveAndFlushResult.getState());
  }
}
