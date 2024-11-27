package finos.traderx.positionservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import finos.traderx.positionservice.model.Trade;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TradeRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.positionservice.model"})
@DataJpaTest
class TradeRepositoryDiffblueTest {
  @Autowired
  private TradeRepository tradeRepository;

  /**
   * Test {@link TradeRepository#findByAccountId(Integer)}.
   * <p>
   * Method under test: {@link TradeRepository#findByAccountId(Integer)}
   */
  @Test
  @DisplayName("Test findByAccountId(Integer)")
  void testFindByAccountId() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindByAccountIdResult = tradeRepository.findByAccountId(1);

    // Assert
    assertEquals(1, actualFindByAccountIdResult.size());
    Trade getResult = actualFindByAccountIdResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link CrudRepository#count()}.
   * <p>
   * Method under test: {@link TradeRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  void testCount() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act and Assert
    assertEquals(2L, tradeRepository.count());
  }

  /**
   * Test {@link QueryByExampleExecutor#count(Example)} with {@code Example}.
   * <p>
   * Method under test: {@link TradeRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  void testCountWithExample() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertEquals(1L, tradeRepository.count(example));
  }

  /**
   * Test {@link CrudRepository#delete(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  void testDelete() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    tradeRepository.delete(trade3);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#deleteAll()}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  void testDeleteAll() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.deleteAll();

    // Assert
    assertTrue(tradeRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteAllById(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  void testDeleteAllById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide("Side");
    trade4.setState("MD");
    trade4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide("Side");
    trade5.setState("MD");
    trade5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);
    Integer accountId = trade3.getAccountId();
    Integer accountId2 = trade4.getAccountId();
    List<Integer> ids = Arrays.asList(accountId, accountId2, trade5.getAccountId());

    // Act
    tradeRepository.deleteAllById(ids);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#deleteAllByIdInBatch(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  void testDeleteAllByIdInBatch() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult2.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals("State", getResult2.getState());
    assertEquals("UNSET", getResult2.getSecurity());
    assertEquals("UNSET", getResult2.getSide());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#deleteAllInBatch()}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAllInBatch()}
   */
  @Test
  @DisplayName("Test deleteAllInBatch()")
  void testDeleteAllInBatch() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    tradeRepository.deleteAllInBatch();

    // Assert
    assertTrue(tradeRepository.findAll().isEmpty());
  }

  /**
   * Test {@link JpaRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  void testDeleteAllInBatchWithIterable() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide("Side");
    trade4.setState("MD");
    trade4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide("Side");
    trade5.setState("MD");
    trade5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#deleteAll(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link TradeRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  void testDeleteAllWithIterable() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide("Side");
    trade4.setState("MD");
    trade4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide("Side");
    trade5.setState("MD");
    trade5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#deleteById(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  void testDeleteById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Integer accountId = trade3.getAccountId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    tradeRepository.deleteById(accountId);

    // Assert
    List<Trade> findAllResult = tradeRepository.findAll();
    assertEquals(1, findAllResult.size());
    Trade getResult = findAllResult.get(0);
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#deleteInBatch(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  void testDeleteInBatch() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide("Side");
    trade4.setState("MD");
    trade4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide("Side");
    trade5.setState("MD");
    trade5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult.getId());
    assertEquals("State", getResult.getState());
    assertEquals("UNSET", getResult.getSecurity());
    assertEquals("UNSET", getResult.getSide());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#existsById(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object)")
  void testExistsById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Integer accountId = trade3.getAccountId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act and Assert
    assertTrue(tradeRepository.existsById(accountId));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Given {@link Trade} (default constructor) AccountId is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradeRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); given Trade (default constructor) AccountId is one; then return 'true'")
  void testExists_givenTradeAccountIdIsOne_thenReturnTrue() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertTrue(tradeRepository.exists(example));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TradeRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  void testExists_thenReturnFalse() {
    // Arrange
    Trade trade = new Trade();
    trade.setAccountId(2);
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act and Assert
    assertFalse(tradeRepository.exists(example));
  }

  /**
   * Test {@link ListCrudRepository#findAll()}.
   * <p>
   * Method under test: {@link TradeRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  void testFindAll() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll();

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = actualFindAllResult.get(1);
    assertEquals("Id", getResult2.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals("State", getResult2.getState());
    assertEquals("UNSET", getResult2.getSecurity());
    assertEquals("UNSET", getResult2.getSide());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
  }

  /**
   * Test {@link ListCrudRepository#findAllById(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  void testFindAllById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade4 = new Trade();
    trade4.setAccountId(1);
    trade4.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade4.setId("42");
    trade4.setQuantity(1);
    trade4.setSecurity("Security");
    trade4.setSide("Side");
    trade4.setState("MD");
    trade4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade5 = new Trade();
    trade5.setAccountId(1);
    trade5.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade5.setId("42");
    trade5.setQuantity(1);
    trade5.setSecurity("Security");
    trade5.setSide("Side");
    trade5.setState("MD");
    trade5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);
    tradeRepository.save(trade4);
    tradeRepository.save(trade5);
    Integer accountId = trade3.getAccountId();
    Integer accountId2 = trade4.getAccountId();
    List<Integer> ids = Arrays.asList(accountId, accountId2, trade5.getAccountId());

    // Act
    List<Trade> actualFindAllByIdResult = tradeRepository.findAllById(ids);

    // Assert
    assertEquals(1, actualFindAllByIdResult.size());
    Trade getResult = actualFindAllByIdResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link JpaRepository#findAll(Example)} with {@code example}.
   * <p>
   * Method under test: {@link TradeRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  void testFindAllWithExample() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(example);

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link QueryByExampleExecutor#findAll(Example, Pageable)} with
   * {@code example}, {@code pageable}.
   * <p>
   * Method under test: {@link TradeRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  void testFindAllWithExamplePageable() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    Page<Trade> actualFindAllResult = tradeRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Trade> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    Trade getResult = toListResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link JpaRepository#findAll(Example, Sort)} with {@code example},
   * {@code sort}.
   * <p>
   * Method under test: {@link TradeRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName("Test findAll(Example, Sort) with 'example', 'sort'")
  void testFindAllWithExampleSort() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(example, Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link PagingAndSortingRepository#findAll(Pageable)} with
   * {@code pageable}.
   * <p>
   * Method under test: {@link TradeRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  void testFindAllWithPageable() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult2.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals("State", getResult2.getState());
    assertEquals("UNSET", getResult2.getSecurity());
    assertEquals("UNSET", getResult2.getSide());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
  }

  /**
   * Test {@link ListPagingAndSortingRepository#findAll(Sort)} with {@code sort}.
   * <p>
   * Method under test: {@link TradeRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'")
  void testFindAllWithSort() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    List<Trade> actualFindAllResult = tradeRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Trade getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getId());
    Trade getResult2 = actualFindAllResult.get(1);
    assertEquals("Id", getResult2.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals("State", getResult2.getState());
    assertEquals("UNSET", getResult2.getSecurity());
    assertEquals("UNSET", getResult2.getSide());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#findById(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  void testFindById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Integer accountId = trade3.getAccountId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Optional<Trade> actualFindByIdResult = tradeRepository.findById(accountId);

    // Assert
    Trade getResult = actualFindByIdResult.get();
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertTrue(actualFindByIdResult.isPresent());
    assertSame(accountId, getResult.getQuantity());
  }

  /**
   * Test {@link QueryByExampleExecutor#findOne(Example)}.
   * <p>
   * Method under test: {@link TradeRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  void testFindOne() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Trade> example = Example.of(trade3);

    // Act
    Optional<Trade> actualFindOneResult = tradeRepository.findOne(example);

    // Assert
    Trade getResult = actualFindOneResult.get();
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(actualFindOneResult.isPresent());
  }

  /**
   * Test {@link JpaRepository#flush()}.
   * <p>
   * Method under test: {@link TradeRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  void testFlush() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    assertEquals("Id", getResult2.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals("State", getResult2.getState());
    assertEquals("UNSET", getResult2.getSecurity());
    assertEquals("UNSET", getResult2.getSide());
    assertEquals(-1, getResult2.getQuantity().intValue());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(2, getResult2.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#getById(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#getById(Object)}
   */
  @Test
  @DisplayName("Test getById(Object)")
  void testGetById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Integer accountId = trade3.getAccountId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Trade actualById = tradeRepository.getById(accountId);

    // Assert
    assertEquals("42", actualById.getId());
    assertEquals("MD", actualById.getState());
    assertEquals("Security", actualById.getSecurity());
    assertEquals("Side", actualById.getSide());
    assertEquals(1, actualById.getAccountId().intValue());
    assertSame(accountId, actualById.getQuantity());
  }

  /**
   * Test {@link JpaRepository#getOne(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#getOne(Object)}
   */
  @Test
  @DisplayName("Test getOne(Object)")
  void testGetOne() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    tradeRepository.save(trade);
    tradeRepository.save(trade2);

    // Act
    Trade actualOne = tradeRepository.getOne(1);

    // Assert
    assertEquals("42", actualOne.getId());
    assertEquals("MD", actualOne.getState());
    assertEquals("Security", actualOne.getSecurity());
    assertEquals("Side", actualOne.getSide());
    assertEquals(1, actualOne.getAccountId().intValue());
    assertEquals(1, actualOne.getQuantity().intValue());
  }

  /**
   * Test {@link JpaRepository#getReferenceById(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#getReferenceById(Object)}
   */
  @Test
  @DisplayName("Test getReferenceById(Object)")
  void testGetReferenceById() {
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
    trade2.setQuantity(-1);
    trade2.setSecurity("UNSET");
    trade2.setSide("UNSET");
    trade2.setState("State");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Integer accountId = trade3.getAccountId();
    tradeRepository.save(trade);
    tradeRepository.save(trade2);
    tradeRepository.save(trade3);

    // Act
    Trade actualReferenceById = tradeRepository.getReferenceById(accountId);

    // Assert
    assertEquals("42", actualReferenceById.getId());
    assertEquals("MD", actualReferenceById.getState());
    assertEquals("Security", actualReferenceById.getSecurity());
    assertEquals("Side", actualReferenceById.getSide());
    assertEquals(1, actualReferenceById.getAccountId().intValue());
    assertSame(accountId, actualReferenceById.getQuantity());
  }

  /**
   * Test {@link CrudRepository#save(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  void testSave() {
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

    // Act
    Trade actualSaveResult = tradeRepository.save(trade);

    // Assert
    assertEquals("42", actualSaveResult.getId());
    assertEquals("MD", actualSaveResult.getState());
    assertEquals("Security", actualSaveResult.getSecurity());
    assertEquals("Side", actualSaveResult.getSide());
    assertEquals(1, actualSaveResult.getAccountId().intValue());
    assertEquals(1, actualSaveResult.getQuantity().intValue());
  }

  /**
   * Test {@link ListCrudRepository#saveAll(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  void testSaveAll() {
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
    trade2.setAccountId(1);
    trade2.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("42");
    trade2.setQuantity(1);
    trade2.setSecurity("Security");
    trade2.setSide("Side");
    trade2.setState("MD");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    List<Trade> entities = Arrays.asList(trade, trade2, trade3);

    // Act
    List<Trade> actualSaveAllResult = tradeRepository.saveAll(entities);

    // Assert
    assertEquals(3, actualSaveAllResult.size());
    Trade getResult = actualSaveAllResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllResult.get(1));
    assertSame(getResult, actualSaveAllResult.get(2));
  }

  /**
   * Test {@link JpaRepository#saveAllAndFlush(Iterable)}.
   * <p>
   * Method under test: {@link TradeRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  void testSaveAllAndFlush() {
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
    trade2.setAccountId(1);
    trade2.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade2.setId("42");
    trade2.setQuantity(1);
    trade2.setSecurity("Security");
    trade2.setSide("Side");
    trade2.setState("MD");
    trade2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Trade trade3 = new Trade();
    trade3.setAccountId(1);
    trade3.setCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    trade3.setId("42");
    trade3.setQuantity(1);
    trade3.setSecurity("Security");
    trade3.setSide("Side");
    trade3.setState("MD");
    trade3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    List<Trade> entities = Arrays.asList(trade, trade2, trade3);

    // Act
    List<Trade> actualSaveAllAndFlushResult = tradeRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(3, actualSaveAllAndFlushResult.size());
    Trade getResult = actualSaveAllAndFlushResult.get(0);
    assertEquals("42", getResult.getId());
    assertEquals("MD", getResult.getState());
    assertEquals("Security", getResult.getSecurity());
    assertEquals("Side", getResult.getSide());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllAndFlushResult.get(1));
    assertSame(getResult, actualSaveAllAndFlushResult.get(2));
  }

  /**
   * Test {@link JpaRepository#saveAndFlush(Object)}.
   * <p>
   * Method under test: {@link TradeRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  void testSaveAndFlush() {
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

    // Act
    Trade actualSaveAndFlushResult = tradeRepository.saveAndFlush(trade);

    // Assert
    assertEquals("42", actualSaveAndFlushResult.getId());
    assertEquals("MD", actualSaveAndFlushResult.getState());
    assertEquals("Security", actualSaveAndFlushResult.getSecurity());
    assertEquals("Side", actualSaveAndFlushResult.getSide());
    assertEquals(1, actualSaveAndFlushResult.getAccountId().intValue());
    assertEquals(1, actualSaveAndFlushResult.getQuantity().intValue());
  }
}
