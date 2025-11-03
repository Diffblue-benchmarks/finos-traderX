package finos.traderx.positionservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import finos.traderx.positionservice.model.Position;
import finos.traderx.positionservice.repository.PositionRepository;
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

@ContextConfiguration(classes = {PositionService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PositionServiceDiffblueTest {
  @MockBean
  private PositionRepository positionRepository;

  @Autowired
  private PositionService positionService;

  /**
   * Method under test: {@link PositionService#getAllPositions()}
   */
  @Test
  void testGetAllPositions() {
    // Arrange
    when(positionRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Position> actualAllPositions = positionService.getAllPositions();

    // Assert
    verify(positionRepository).findAll();
    assertTrue(actualAllPositions.isEmpty());
  }

  /**
   * Method under test: {@link PositionService#getAllPositions()}
   */
  @Test
  void testGetAllPositions2() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Position> positionList = new ArrayList<>();
    positionList.add(position);
    when(positionRepository.findAll()).thenReturn(positionList);

    // Act
    List<Position> actualAllPositions = positionService.getAllPositions();

    // Assert
    verify(positionRepository).findAll();
    assertEquals(positionList, actualAllPositions);
  }

  /**
   * Method under test: {@link PositionService#getAllPositions()}
   */
  @Test
  void testGetAllPositions3() {
    // Arrange
    Position position = new Position();
    position.setAccountId(1);
    position.setQuantity(1);
    position.setSecurity("Security");
    position.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Position position2 = new Position();
    position2.setAccountId(2);
    position2.setQuantity(0);
    position2.setSecurity("42");
    position2.setUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Position> positionList = new ArrayList<>();
    positionList.add(position2);
    positionList.add(position);
    when(positionRepository.findAll()).thenReturn(positionList);

    // Act
    List<Position> actualAllPositions = positionService.getAllPositions();

    // Assert
    verify(positionRepository).findAll();
    assertEquals(positionList, actualAllPositions);
  }

  /**
   * Method under test: {@link PositionService#getPositionsByAccountID(int)}
   */
  @Test
  void testGetPositionsByAccountID() {
    // Arrange
    ArrayList<Position> positionList = new ArrayList<>();
    when(positionRepository.findByAccountId(Mockito.<Integer>any())).thenReturn(positionList);

    // Act
    List<Position> actualPositionsByAccountID = positionService.getPositionsByAccountID(1);

    // Assert
    verify(positionRepository).findByAccountId(eq(1));
    assertTrue(actualPositionsByAccountID.isEmpty());
    assertSame(positionList, actualPositionsByAccountID);
  }
}
