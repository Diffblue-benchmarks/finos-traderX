package finos.traderx.positionservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import finos.traderx.positionservice.service.TradeService;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TradeController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TradeControllerDiffblueTest {
  @Autowired private TradeController tradeController;

  @MockBean private TradeService tradeService;

  /**
   * Test {@link TradeController#getByAccountId(int)}.
   *
   * <p>Method under test: {@link TradeController#getByAccountId(int)}
   */
  @Test
  @DisplayName("Test getByAccountId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity TradeController.getByAccountId(int)"})
  void testGetByAccountId() throws Exception {
    // Arrange
    when(tradeService.getTradesByAccountID(anyInt())).thenReturn(new ArrayList<>());

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tradeController)
        .build()
        .perform(
            MockMvcRequestBuilders.get("/trades/{accountId}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link TradeController#getAllTrades()}.
   *
   * <p>Method under test: {@link TradeController#getAllTrades()}
   */
  @Test
  @DisplayName("Test getAllTrades()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity TradeController.getAllTrades()"})
  void testGetAllTrades() throws Exception {
    // Arrange
    when(tradeService.getAllTrades()).thenReturn(new ArrayList<>());

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tradeController)
        .build()
        .perform(MockMvcRequestBuilders.get("/trades/").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link TradeController#generalError(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then StatusCode return {@link HttpStatus}.
   * </ul>
   *
   * <p>Method under test: {@link TradeController#generalError(Exception)}
   */
  @Test
  @DisplayName("Test generalError(Exception); when Exception(); then StatusCode return HttpStatus")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity TradeController.generalError(Exception)"})
  void testGeneralError_whenException_thenStatusCodeReturnHttpStatus() {
    // Arrange and Act
    ResponseEntity<String> actualGeneralErrorResult = tradeController.generalError(new Exception());

    // Assert
    HttpStatusCode statusCode = actualGeneralErrorResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(actualGeneralErrorResult.getBody());
    assertEquals(500, actualGeneralErrorResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertFalse(actualGeneralErrorResult.hasBody());
    assertTrue(actualGeneralErrorResult.getHeaders().isEmpty());
  }
}
