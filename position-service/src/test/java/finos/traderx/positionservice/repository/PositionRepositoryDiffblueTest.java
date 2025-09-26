package finos.traderx.positionservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

@ContextConfiguration(classes = {PositionRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"finos.traderx.positionservice.model"})
class PositionRepositoryDiffblueTest {
  @Autowired private PositionRepository positionRepository;

  /**
   * Test {@link PositionRepository#findByAccountId(Integer)}.
   *
   * <p>Method under test: {@link PositionRepository#findByAccountId(Integer)}
   */
  @Test
  @DisplayName("Test findByAccountId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findByAccountId(Integer)"})
  void testFindByAccountId() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    List<Position> actualFindByAccountIdResult = positionRepository.findByAccountId(1);

    // Assert
    assertEquals(1, actualFindByAccountIdResult.size());
    Position getResult = actualFindByAccountIdResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link PositionRepository#count()}.
   *
   * <p>Method under test: {@link PositionRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PositionRepository.count()"})
  void testCount() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertEquals(2L, positionRepository.count());
  }

  /**
   * Test {@link PositionRepository#count(Example)} with {@code Example}.
   *
   * <p>Method under test: {@link PositionRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PositionRepository.count(Example)"})
  void testCountWithExample() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertEquals(1L, positionRepository.count(example));
  }

  /**
   * Test {@link PositionRepository#delete(Object)}.
   *
   * <p>Method under test: {@link PositionRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.delete(Object)"})
  void testDelete() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);

    // Act
    positionRepository.delete(position3);

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteAll()}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAll()}
   */
  @Test
  @DisplayName("Test deleteAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAll()"})
  void testDeleteAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAll();

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link PositionRepository#deleteAllById(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAllById(Iterable)"})
  void testDeleteAllById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    PositionID positionID = new PositionID();
    PositionID positionID2 = new PositionID();

    List<PositionID> ids = Arrays.asList(positionID, positionID2, new PositionID());

    // Act
    positionRepository.deleteAllById(ids);

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(2, findAllResult.size());
    Position getResult = findAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = findAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteAllByIdInBatch(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAllByIdInBatch(Iterable)"})
  void testDeleteAllByIdInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAllByIdInBatch(new ArrayList<>());

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(2, findAllResult.size());
    Position getResult = findAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = findAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteAllInBatch()}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAllInBatch()}
   */
  @Test
  @DisplayName("Test deleteAllInBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAllInBatch()"})
  void testDeleteAllInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteAllInBatch();

    // Assert
    assertTrue(positionRepository.findAll().isEmpty());
  }

  /**
   * Test {@link PositionRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAllInBatch(Iterable)"})
  void testDeleteAllInBatchWithIterable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);

    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteAllInBatch(entities);

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteAll(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link PositionRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteAll(Iterable)"})
  void testDeleteAllWithIterable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);

    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteAll(entities);

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteById(Object)}.
   *
   * <p>Method under test: {@link PositionRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteById(Object)"})
  void testDeleteById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.deleteById(new PositionID());

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(2, findAllResult.size());
    Position getResult = findAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = findAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#deleteInBatch(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.deleteInBatch(Iterable)"})
  void testDeleteInBatch() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position4 = new Position();
    position4.setAccountId(1);
    position4.setQuantity(1);
    position4.setSecurity("Security");
    position4.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position5 = new Position();
    position5.setAccountId(1);
    position5.setQuantity(1);
    position5.setSecurity("Security");
    position5.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    positionRepository.save(position3);
    positionRepository.save(position4);
    positionRepository.save(position5);

    List<Position> entities = Arrays.asList(position3, position4, position5);

    // Act
    positionRepository.deleteInBatch(entities);

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(1, findAllResult.size());
    Position getResult = findAllResult.get(0);
    assertEquals("42", getResult.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#existsById(Object)}.
   *
   * <ul>
   *   <li>When {@link PositionID#PositionID(Integer, String)} with accountId is one and {@code
   *       Security}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#existsById(Object)}
   */
  @Test
  @DisplayName(
      "Test existsById(Object); when PositionID(Integer, String) with accountId is one and 'Security'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionRepository.existsById(Object)"})
  void testExistsById_whenPositionIDWithAccountIdIsOneAndSecurity_thenReturnTrue() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertTrue(positionRepository.existsById(new PositionID(1, "Security")));
  }

  /**
   * Test {@link PositionRepository#existsById(Object)}.
   *
   * <ul>
   *   <li>When {@link PositionID#PositionID()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object); when PositionID(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionRepository.existsById(Object)"})
  void testExistsById_whenPositionID_thenReturnFalse() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertFalse(positionRepository.existsById(new PositionID()));
  }

  /**
   * Test {@link PositionRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Given {@link Position} (default constructor) AccountId is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#exists(Example)}
   */
  @Test
  @DisplayName(
      "Test exists(Example); given Position (default constructor) AccountId is one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionRepository.exists(Example)"})
  void testExists_givenPositionAccountIdIsOne_thenReturnTrue() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertTrue(positionRepository.exists(example));
  }

  /**
   * Test {@link PositionRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PositionRepository.exists(Example)"})
  void testExists_thenReturnFalse() {
    // Arrange
    Position position = new Position();
    position.setAccountId(2);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act and Assert
    assertFalse(positionRepository.exists(example));
  }

  /**
   * Test {@link PositionRepository#findAll()}.
   *
   * <p>Method under test: {@link PositionRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findAll()"})
  void testFindAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll();

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = actualFindAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#findAllById(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findAllById(Iterable)"})
  void testFindAllById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);
    PositionID positionID = new PositionID();
    PositionID positionID2 = new PositionID();

    List<PositionID> ids = Arrays.asList(positionID, positionID2, new PositionID());

    // Act and Assert
    assertTrue(positionRepository.findAllById(ids).isEmpty());
  }

  /**
   * Test {@link PositionRepository#findAll(Example)} with {@code example}.
   *
   * <p>Method under test: {@link PositionRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findAll(Example)"})
  void testFindAllWithExample() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll(example);

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link PositionRepository#findAll(Example, Pageable)} with {@code example}, {@code
   * pageable}.
   *
   * <p>Method under test: {@link PositionRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page PositionRepository.findAll(Example, Pageable)"})
  void testFindAllWithExamplePageable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act
    Page<Position> actualFindAllResult = positionRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Position> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    Position getResult = toListResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link PositionRepository#findAll(Example, Sort)} with {@code example}, {@code sort}.
   *
   * <ul>
   *   <li>When unsorted.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName(
      "Test findAll(Example, Sort) with 'example', 'sort'; when unsorted; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findAll(Example, Sort)"})
  void testFindAllWithExampleSort_whenUnsorted_thenReturnSizeIsOne() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll(example, Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
  }

  /**
   * Test {@link PositionRepository#findAll(Pageable)} with {@code pageable}.
   *
   * <p>Method under test: {@link PositionRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page PositionRepository.findAll(Pageable)"})
  void testFindAllWithPageable() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    Page<Position> actualFindAllResult = positionRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<Position> toListResult = actualFindAllResult.toList();
    assertEquals(2, toListResult.size());
    Position getResult = toListResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = toListResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#findAll(Sort)} with {@code sort}.
   *
   * <ul>
   *   <li>When unsorted.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PositionRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'; when unsorted; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.findAll(Sort)"})
  void testFindAllWithSort_whenUnsorted_thenReturnSizeIsTwo() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    List<Position> actualFindAllResult = positionRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(2, actualFindAllResult.size());
    Position getResult = actualFindAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = actualFindAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#findById(Object)}.
   *
   * <p>Method under test: {@link PositionRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PositionRepository.findById(Object)"})
  void testFindById() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act and Assert
    assertFalse(positionRepository.findById(new PositionID()).isPresent());
  }

  /**
   * Test {@link PositionRepository#findOne(Example)}.
   *
   * <p>Method under test: {@link PositionRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PositionRepository.findOne(Example)"})
  void testFindOne() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Example<Position> example = Example.of(position3);

    // Act
    Optional<Position> actualFindOneResult = positionRepository.findOne(example);

    // Assert
    Position getResult = actualFindOneResult.get();
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertTrue(actualFindOneResult.isPresent());
  }

  /**
   * Test {@link PositionRepository#flush()}.
   *
   * <p>Method under test: {@link PositionRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PositionRepository.flush()"})
  void testFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(-1);
    position2.setSecurity("42");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    positionRepository.save(position);
    positionRepository.save(position2);

    // Act
    positionRepository.flush();

    // Assert
    List<Position> findAllResult = positionRepository.findAll();
    assertEquals(2, findAllResult.size());
    Position getResult = findAllResult.get(1);
    assertEquals("42", getResult.getSecurity());
    Position getResult2 = findAllResult.get(0);
    assertEquals("Security", getResult2.getSecurity());
    assertEquals(-1, getResult.getQuantity().intValue());
    assertEquals(1, getResult2.getAccountId().intValue());
    assertEquals(1, getResult2.getQuantity().intValue());
    assertEquals(2, getResult.getAccountId().intValue());
  }

  /**
   * Test {@link PositionRepository#save(Object)}.
   *
   * <p>Method under test: {@link PositionRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PositionRepository.save(Object)"})
  void testSave() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Position actualSaveResult = positionRepository.save(position);

    // Assert
    assertEquals("Security", actualSaveResult.getSecurity());
    assertEquals(1, actualSaveResult.getAccountId().intValue());
    assertEquals(1, actualSaveResult.getQuantity().intValue());
  }

  /**
   * Test {@link PositionRepository#saveAll(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.saveAll(Iterable)"})
  void testSaveAll() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(1);
    position2.setQuantity(1);
    position2.setSecurity("Security");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    List<Position> entities = Arrays.asList(position, position2, position3);

    // Act
    List<Position> actualSaveAllResult = positionRepository.saveAll(entities);

    // Assert
    assertEquals(3, actualSaveAllResult.size());
    Position getResult = actualSaveAllResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllResult.get(1));
    assertSame(getResult, actualSaveAllResult.get(2));
  }

  /**
   * Test {@link PositionRepository#saveAllAndFlush(Iterable)}.
   *
   * <p>Method under test: {@link PositionRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PositionRepository.saveAllAndFlush(Iterable)"})
  void testSaveAllAndFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(1);
    position2.setQuantity(1);
    position2.setSecurity("Security");
    position2.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position3 = new Position();
    position3.setAccountId(1);
    position3.setQuantity(1);
    position3.setSecurity("Security");
    position3.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    List<Position> entities = Arrays.asList(position, position2, position3);

    // Act
    List<Position> actualSaveAllAndFlushResult = positionRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(3, actualSaveAllAndFlushResult.size());
    Position getResult = actualSaveAllAndFlushResult.get(0);
    assertEquals("Security", getResult.getSecurity());
    assertEquals(1, getResult.getAccountId().intValue());
    assertEquals(1, getResult.getQuantity().intValue());
    assertSame(getResult, actualSaveAllAndFlushResult.get(1));
    assertSame(getResult, actualSaveAllAndFlushResult.get(2));
  }

  /**
   * Test {@link PositionRepository#saveAndFlush(Object)}.
   *
   * <p>Method under test: {@link PositionRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PositionRepository.saveAndFlush(Object)"})
  void testSaveAndFlush() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    Position actualSaveAndFlushResult = positionRepository.saveAndFlush(position);

    // Assert
    assertEquals("Security", actualSaveAndFlushResult.getSecurity());
    assertEquals(1, actualSaveAndFlushResult.getAccountId().intValue());
    assertEquals(1, actualSaveAndFlushResult.getQuantity().intValue());
  }
}
