package finos.traderx.positionservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import finos.traderx.positionservice.model.Position;
import finos.traderx.positionservice.model.PositionID;
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

@ContextConfiguration(classes = {PositionRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.positionservice.model"})
@DataJpaTest
class PositionRepositoryDiffblueTest {
  @Autowired
  private PositionRepository positionRepository;

  /**
   * Test {@link PositionRepository#findByAccountId(Integer)}.
   * <p>
   * Method under test: {@link PositionRepository#findByAccountId(Integer)}
   */
  @Test
  @DisplayName("Test findByAccountId(Integer)")
  void testFindByAccountId() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertTrue(positionRepository.findByAccountId(1).isEmpty());
  }

  /**
   * Test {@link CrudRepository#count()}.
   * <p>
   * Method under test: {@link PositionRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  void testCount() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertEquals(1L, positionRepository.count());
  }

  /**
   * Test {@link QueryByExampleExecutor#count(Example)} with {@code Example}.
   * <p>
   * Method under test: {@link PositionRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  void testCountWithExample() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertEquals(0L, positionRepository.count(example));
  }

  /**
   * Test {@link CrudRepository#delete(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  void testDelete() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    positionRepository.delete(position3);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteAll()}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  void testDeleteAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAll();

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteAllById(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  void testDeleteAllById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setPositionID(new PositionID());
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setPositionID(new PositionID());
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);
    PositionID positionID = position3.getPositionID();
    PositionID positionID2 = position4.getPositionID();
    List<PositionID> ids = Arrays.asList(positionID, positionID2, position5.getPositionID());

    // Act
    positionRepository.deleteAllById(ids);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link JpaRepository#deleteAllByIdInBatch(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  void testDeleteAllByIdInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAllByIdInBatch(new ArrayList<>());

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#deleteAllInBatch()}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAllInBatch()}
   */
  @Test
  @DisplayName("Test deleteAllInBatch()")
  void testDeleteAllInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAllInBatch();

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link JpaRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  void testDeleteAllInBatchWithIterable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setPositionID(new PositionID());
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setPositionID(new PositionID());
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);
    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteAllInBatch(entities);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteAll(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link PositionRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  void testDeleteAllWithIterable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setPositionID(new PositionID());
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setPositionID(new PositionID());
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);
    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteAll(entities);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#deleteById(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  void testDeleteById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    PositionID positionID = position3.getPositionID();
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    positionRepository.deleteById(positionID);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link JpaRepository#deleteInBatch(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  void testDeleteInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setPositionID(new PositionID());
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setPositionID(new PositionID());
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);
    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteInBatch(entities);

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link CrudRepository#existsById(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object)")
  void testExistsById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    PositionID positionID = position3.getPositionID();
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act and Assert
    assertTrue(positionRepository.existsById(positionID));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PositionRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  void testExists_thenReturnFalse() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertFalse(positionRepository.exists(example));
  }

  /**
   * Test {@link QueryByExampleExecutor#exists(Example)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PositionRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'true'")
  void testExists_thenReturnTrue() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID(1, "Security"));
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertTrue(positionRepository.exists(example));
  }

  /**
   * Test {@link ListCrudRepository#findAll()}.
   * <p>
   * Method under test: {@link PositionRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  void testFindAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll();

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link ListCrudRepository#findAllById(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  void testFindAllById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setPositionID(new PositionID());
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setPositionID(new PositionID());
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);
    PositionID positionID = position3.getPositionID();
    PositionID positionID2 = position4.getPositionID();
    List<PositionID> ids = Arrays.asList(positionID, positionID2, position5.getPositionID());

    // Act
    List<Position> actualFindAllByIdResult = positionRepository.findAllById(ids);

    // Assert
    assertEquals(1, actualFindAllByIdResult.size());
    Position getResult = actualFindAllByIdResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    PositionID positionID3 = getResult.getPositionID();
    assertNull(positionID3.getAccountId());
    assertNull(positionID3.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link JpaRepository#findAll(Example)} with {@code example}.
   * <p>
   * Method under test: {@link PositionRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  void testFindAllWithExample() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertTrue(positionRepository.findAll(example).isEmpty());
  }

  /**
   * Test {@link QueryByExampleExecutor#findAll(Example, Pageable)} with
   * {@code example}, {@code pageable}.
   * <p>
   * Method under test: {@link PositionRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  void testFindAllWithExamplePageable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act
    Page<Position> actualFindAllResult = positionRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    assertTrue(actualFindAllResult.toList().isEmpty());
  }

  /**
   * Test {@link JpaRepository#findAll(Example, Sort)} with {@code example},
   * {@code sort}.
   * <p>
   * Method under test: {@link PositionRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName("Test findAll(Example, Sort) with 'example', 'sort'")
  void testFindAllWithExampleSort() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertTrue(positionRepository.findAll(example, Sort.unsorted()).isEmpty());
  }

  /**
   * Test {@link PagingAndSortingRepository#findAll(Pageable)} with
   * {@code pageable}.
   * <p>
   * Method under test: {@link PositionRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  void testFindAllWithPageable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    Page<Position> actualFindAllResult = positionRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Position> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    Position getResult = toListResult.get(0);
    assertEquals("42", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link ListPagingAndSortingRepository#findAll(Sort)} with {@code sort}.
   * <p>
   * Method under test: {@link PositionRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'")
  void testFindAllWithSort() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link CrudRepository#findById(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  void testFindById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    PositionID positionID = position3.getPositionID();
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    Optional<Position> actualFindByIdResult = positionRepository.findById(positionID);

    // Assert
    Position getResult = actualFindByIdResult.get();
    assertEquals("Security", getResult.getSecurity());
    PositionID positionID2 = getResult.getPositionID();
    assertNull(positionID2.getAccountId());
    assertNull(positionID2.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(actualFindByIdResult.isPresent());
  }

  /**
   * Test {@link QueryByExampleExecutor#findOne(Example)}.
   * <p>
   * Method under test: {@link PositionRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  void testFindOne() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertFalse(positionRepository.findOne(example).isPresent());
  }

  /**
   * Test {@link JpaRepository#flush()}.
   * <p>
   * Method under test: {@link PositionRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  void testFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.flush();

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#getById(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#getById(Object)}
   */
  @Test
  @DisplayName("Test getById(Object)")
  void testGetById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    PositionID positionID = position3.getPositionID();
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    Position actualById = positionRepository.getById(positionID);

    // Assert
    assertEquals("Security", actualById.getSecurity());
    PositionID positionID2 = actualById.getPositionID();
    assertNull(positionID2.getAccountId());
    assertNull(positionID2.getSecurity());
    assertEquals(1, actualById.getAccountId().intValue());
    assertEquals(1, actualById.getQuantity().intValue());
  }

  /**
   * Test {@link JpaRepository#getOne(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#getOne(Object)}
   */
  @Test
  @DisplayName("Test getOne(Object)")
  void testGetOne() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    Position actualOne = positionRepository.getOne(new PositionID());

    // Assert
    assertEquals("42", actualOne.getSecurity());
    PositionID positionID = actualOne.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(-1, actualOne.getQuantity().intValue());
    assertEquals(2, actualOne.getAccountId().intValue());
  }

  /**
   * Test {@link JpaRepository#getReferenceById(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#getReferenceById(Object)}
   */
  @Test
  @DisplayName("Test getReferenceById(Object)")
  void testGetReferenceById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setPositionID(new PositionID());
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    PositionID positionID = position3.getPositionID();
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    Position actualReferenceById = positionRepository.getReferenceById(positionID);

    // Assert
    assertEquals("Security", actualReferenceById.getSecurity());
    PositionID positionID2 = actualReferenceById.getPositionID();
    assertNull(positionID2.getAccountId());
    assertNull(positionID2.getSecurity());
    assertEquals(1, actualReferenceById.getAccountId().intValue());
    assertEquals(1, actualReferenceById.getQuantity().intValue());
  }

  /**
   * Test {@link CrudRepository#save(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  void testSave() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Position actualSaveResult = positionRepository.save(position);

    // Assert
    assertEquals("Security", actualSaveResult.getSecurity());
    PositionID positionID = actualSaveResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(1, actualSaveResult.getAccountId().intValue());
    assertEquals(1, actualSaveResult.getQuantity().intValue());
  }

  /**
   * Test {@link ListCrudRepository#saveAll(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  void testSaveAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(1);
    position2.setPositionID(new PositionID());
    position2.setQuantity(1);
    position2.setSecurity("Security");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    List<Position> entities = Arrays.asList(position, position2, position3);

    // Act
    List<Position> actualSaveAllResult = positionRepository.saveAll(entities);

    // Assert
    assertEquals(3, actualSaveAllResult.size());
    Position getResult = actualSaveAllResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllResult.get(1));
    assertSame(getResult, actualSaveAllResult.get(2));
  }

  /**
   * Test {@link JpaRepository#saveAllAndFlush(Iterable)}.
   * <p>
   * Method under test: {@link PositionRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  void testSaveAllAndFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(1);
    position2.setPositionID(new PositionID());
    position2.setQuantity(1);
    position2.setSecurity("Security");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setPositionID(new PositionID());
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    List<Position> entities = Arrays.asList(position, position2, position3);

    // Act
    List<Position> actualSaveAllAndFlushResult = positionRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(3, actualSaveAllAndFlushResult.size());
    Position getResult = actualSaveAllAndFlushResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    PositionID positionID = getResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllAndFlushResult.get(1));
    assertSame(getResult, actualSaveAllAndFlushResult.get(2));
  }

  /**
   * Test {@link JpaRepository#saveAndFlush(Object)}.
   * <p>
   * Method under test: {@link PositionRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  void testSaveAndFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setPositionID(new PositionID());
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Position actualSaveAndFlushResult = positionRepository.saveAndFlush(position);

    // Assert
    assertEquals("Security", actualSaveAndFlushResult.getSecurity());
    PositionID positionID = actualSaveAndFlushResult.getPositionID();
    assertNull(positionID.getAccountId());
    assertNull(positionID.getSecurity());
    assertEquals(1, actualSaveAndFlushResult.getAccountId().intValue());
    assertEquals(1, actualSaveAndFlushResult.getQuantity().intValue());
  }
}
