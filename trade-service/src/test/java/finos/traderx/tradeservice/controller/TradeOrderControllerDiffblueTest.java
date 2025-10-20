package finos.traderx.tradeservice.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import finos.traderx.tradeservice.exceptions.ResourceNotFoundException;
import finos.traderx.tradeservice.model.Security;
import finos.traderx.tradeservice.model.TradeOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class TradeOrderControllerDiffblueTest {
  @Mock private RestTemplate restTemplate;

  @InjectMocks private TradeOrderController tradeOrderController;

  /**
   * Test {@link TradeOrderController#createTradeOrder(TradeOrder)}.
   *
   * <p>Method under test: {@link TradeOrderController#createTradeOrder(TradeOrder)}
   */
  @Test
  @DisplayName("Test createTradeOrder(TradeOrder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity TradeOrderController.createTradeOrder(TradeOrder)"
  })
  void testCreateTradeOrder() throws Exception {
    // Arrange
    when(restTemplate.getForEntity(
            Mockito.<String>any(), Mockito.<Class<Security>>any(), isA(Object[].class)))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/trade/").contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new TradeOrder()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tradeOrderController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link TradeOrderController#createTradeOrder(TradeOrder)}.
   *
   * <p>Method under test: {@link TradeOrderController#createTradeOrder(TradeOrder)}
   */
  @Test
  @DisplayName("Test createTradeOrder(TradeOrder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity TradeOrderController.createTradeOrder(TradeOrder)"
  })
  void testCreateTradeOrder2() throws Exception {
    // Arrange
    when(restTemplate.getForEntity(
            Mockito.<String>any(), Mockito.<Class<Security>>any(), isA(Object[].class)))
        .thenThrow(new HttpClientErrorException(HttpStatus.OK));

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/trade/").contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(jsonMapper.writeValueAsString(new TradeOrder()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(tradeOrderController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }
}
