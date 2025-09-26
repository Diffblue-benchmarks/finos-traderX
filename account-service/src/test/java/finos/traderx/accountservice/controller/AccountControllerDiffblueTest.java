package finos.traderx.accountservice.controller;

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
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import finos.traderx.accountservice.exceptions.ResourceNotFoundException;
import finos.traderx.accountservice.model.Account;
import finos.traderx.accountservice.service.AccountService;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AccountController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AccountControllerDiffblueTest {
  @Autowired private AccountController accountController;

  @MockBean private AccountService accountService;

  /**
   * Test {@link AccountController#getAccountById(int)}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) DisplayName is {@code Display Name}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#getAccountById(int)}
   */
  @Test
  @DisplayName(
      "Test getAccountById(int); given Account (default constructor) DisplayName is 'Display Name'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.getAccountById(int)"})
  void testGetAccountById_givenAccountDisplayNameIsDisplayName_thenStatusIsOk() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.getAccountById(anyInt())).thenReturn(account);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(MockMvcRequestBuilders.get("/account/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"id\":1,\"displayName\":\"Display Name\"}"));
  }

  /**
   * Test {@link AccountController#getAccountById(int)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#getAccountById(int)}
   */
  @Test
  @DisplayName("Test getAccountById(int); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.getAccountById(int)"})
  void testGetAccountById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountService.getAccountById(anyInt()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(MockMvcRequestBuilders.get("/account/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountController#createAccount(Account)}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) DisplayName is {@code Display Name}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  @DisplayName(
      "Test createAccount(Account); given Account (default constructor) DisplayName is 'Display Name'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.createAccount(Account)"})
  void testCreateAccount_givenAccountDisplayNameIsDisplayName_thenStatusIsOk() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/account/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"id\":1,\"displayName\":\"Display Name\"}"));
  }

  /**
   * Test {@link AccountController#createAccount(Account)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  @DisplayName(
      "Test createAccount(Account); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.createAccount(Account)"})
  void testCreateAccount_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen()
      throws Exception {
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

    MockHttpServletRequestBuilder requestBuilder =
        postResult
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link AccountController#createAccount(Account)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#createAccount(Account)}
   */
  @Test
  @DisplayName("Test createAccount(Account); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.createAccount(Account)"})
  void testCreateAccount_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountService.upsertAccount(Mockito.<Account>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/account/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountController#updateAccount(Account)}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) DisplayName is {@code Display Name}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  @DisplayName(
      "Test updateAccount(Account); given Account (default constructor) DisplayName is 'Display Name'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.updateAccount(Account)"})
  void testUpdateAccount_givenAccountDisplayNameIsDisplayName_thenStatusIsOk() throws Exception {
    // Arrange
    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);
    when(accountService.upsertAccount(Mockito.<Account>any())).thenReturn(account);

    Account account2 = new Account();
    account2.setDisplayName("Display Name");
    account2.setId(1);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/account/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"id\":1,\"displayName\":\"Display Name\"}"));
  }

  /**
   * Test {@link AccountController#updateAccount(Account)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  @DisplayName(
      "Test updateAccount(Account); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.updateAccount(Account)"})
  void testUpdateAccount_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen()
      throws Exception {
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

    MockHttpServletRequestBuilder requestBuilder =
        putResult
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link AccountController#updateAccount(Account)}.
   *
   * <ul>
   *   <li>Given {@link PropertyNamingStrategy} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  @DisplayName("Test updateAccount(Account); given PropertyNamingStrategy (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.updateAccount(Account)"})
  void testUpdateAccount_givenPropertyNamingStrategy() throws Exception {
    // Arrange
    when(accountService.upsertAccount(Mockito.<Account>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    Builder builderResult = JsonMapper.builder();
    builderResult.propertyNamingStrategy(new PropertyNamingStrategy());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/account/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(builderResult.findAndAddModules().build().writeValueAsString(account));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountController#updateAccount(Account)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#updateAccount(Account)}
   */
  @Test
  @DisplayName("Test updateAccount(Account); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.updateAccount(Account)"})
  void testUpdateAccount_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountService.upsertAccount(Mockito.<Account>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    Account account = new Account();
    account.setDisplayName("Display Name");
    account.setId(1);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/account/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonMapper.builder().findAndAddModules().build().writeValueAsString(account));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountController#getAllAccount()}.
   *
   * <ul>
   *   <li>Given {@link AccountService} {@link AccountService#getAllAccount()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#getAllAccount()}
   */
  @Test
  @DisplayName(
      "Test getAllAccount(); given AccountService getAllAccount() return ArrayList(); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.getAllAccount()"})
  void testGetAllAccount_givenAccountServiceGetAllAccountReturnArrayList_thenStatusIsOk()
      throws Exception {
    // Arrange
    when(accountService.getAllAccount()).thenReturn(new ArrayList<>());

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(MockMvcRequestBuilders.get("/account/").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link AccountController#getAllAccount()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#getAllAccount()}
   */
  @Test
  @DisplayName("Test getAllAccount(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.getAllAccount()"})
  void testGetAllAccount_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountService.getAllAccount())
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountController)
        .build()
        .perform(MockMvcRequestBuilders.get("/account/").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}.
   *
   * <ul>
   *   <li>Then StatusCode return {@link HttpStatus}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccountController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  @DisplayName(
      "Test resourceNotFoundExceptionMapper(ResourceNotFoundException); then StatusCode return HttpStatus")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity AccountController.resourceNotFoundExceptionMapper(ResourceNotFoundException)"
  })
  void testResourceNotFoundExceptionMapper_thenStatusCodeReturnHttpStatus() {
    // Arrange and Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult =
        accountController.resourceNotFoundExceptionMapper(
            new ResourceNotFoundException("An error occurred"));

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
   * Test {@link AccountController#generalError(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then StatusCode return {@link HttpStatus}.
   * </ul>
   *
   * <p>Method under test: {@link AccountController#generalError(Exception)}
   */
  @Test
  @DisplayName("Test generalError(Exception); when Exception(); then StatusCode return HttpStatus")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountController.generalError(Exception)"})
  void testGeneralError_whenException_thenStatusCodeReturnHttpStatus() {
    // Arrange and Act
    ResponseEntity<String> actualGeneralErrorResult =
        accountController.generalError(new Exception());

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
