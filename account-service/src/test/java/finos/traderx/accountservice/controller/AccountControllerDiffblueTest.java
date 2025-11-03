package finos.traderx.accountservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import finos.traderx.accountservice.exceptions.ResourceNotFoundException;
import finos.traderx.accountservice.model.Account;
import finos.traderx.accountservice.service.AccountService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccountControllerDiffblueTest {
  @Autowired
  private AccountController accountController;

  @MockBean
  private AccountService accountService;

  /**
   * Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  void testCreateAccount() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"displayName\":\"Display Name\"}"));
  }

  /**
   * Method under test: {@link AccountController#getAllAccount()}
   */
  @Test
  void testGetAllAccount() throws Exception {
    // Arrange
    when(accountService.getAllAccount()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link AccountController#getAllAccount()}
   */
  @Test
  void testGetAllAccount2() throws Exception {
    // Arrange
    when(accountService.getAllAccount()).thenThrow(new ResourceNotFoundException("An error occurred"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
  }

  /**
   * Method under test:
   * {@link AccountController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  void testResourceNotFoundExceptionMapper() {
    // Arrange and Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult = accountController
        .resourceNotFoundExceptionMapper(new ResourceNotFoundException("An error occurred"));

    // Assert
    HttpStatusCode statusCode = actualResourceNotFoundExceptionMapperResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("An error occurred", actualResourceNotFoundExceptionMapperResult.getBody());
    assertEquals(404, actualResourceNotFoundExceptionMapperResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_FOUND, statusCode);
    assertTrue(actualResourceNotFoundExceptionMapperResult.hasBody());
    assertTrue(actualResourceNotFoundExceptionMapperResult.getHeaders().isEmpty());
  }

  /**
   * Method under test:
   * {@link AccountController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  void testResourceNotFoundExceptionMapper2() {
    // Arrange
    ResourceNotFoundException e = mock(ResourceNotFoundException.class);
    when(e.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult = accountController
        .resourceNotFoundExceptionMapper(e);

    // Assert
    verify(e).getMessage();
    HttpStatusCode statusCode = actualResourceNotFoundExceptionMapperResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("Not all who wander are lost", actualResourceNotFoundExceptionMapperResult.getBody());
    assertEquals(404, actualResourceNotFoundExceptionMapperResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_FOUND, statusCode);
    assertTrue(actualResourceNotFoundExceptionMapperResult.hasBody());
    assertTrue(actualResourceNotFoundExceptionMapperResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link AccountController#generalError(Exception)}
   */
  @Test
  void testGeneralError() {
    // Arrange and Act
    ResponseEntity<String> actualGeneralErrorResult = accountController.generalError(new Exception("foo"));

    // Assert
    HttpStatusCode statusCode = actualGeneralErrorResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("foo", actualGeneralErrorResult.getBody());
    assertEquals(500, actualGeneralErrorResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertTrue(actualGeneralErrorResult.hasBody());
    assertTrue(actualGeneralErrorResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  void testCreateAccount2() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/account/");
    postResult.characterEncoding("https://example.org/example");

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account2);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  void testCreateAccount3() throws Exception {
    // Arrange
    when(accountService.upsertAccount(Mockito.<Account>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/account/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
  }

  /**
   * Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  void testUpdateAccount() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/account/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"displayName\":\"Display Name\"}"));
  }

  /**
   * Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  void testUpdateAccount2() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);
    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/account/");
    putResult.characterEncoding("https://example.org/example");

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account2);
    MockHttpServletRequestBuilder requestBuilder = putResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  void testUpdateAccount3() throws Exception {
    // Arrange
    when(accountService.upsertAccount(Mockito.<Account>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    String content = (new ObjectMapper()).writeValueAsString(account);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/account/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("An error occurred"));
  }
}
