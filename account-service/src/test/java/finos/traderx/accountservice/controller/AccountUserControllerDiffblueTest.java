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
import com.fasterxml.jackson.databind.json.JsonMapper;
import finos.traderx.accountservice.exceptions.ResourceNotFoundException;
import finos.traderx.accountservice.model.AccountUser;
import finos.traderx.accountservice.service.AccountUserService;
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
import org.springframework.web.client.HttpClientErrorException;

@ContextConfiguration(classes = {AccountUserController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AccountUserControllerDiffblueTest {
  @Autowired private AccountUserController accountUserController;

  @MockBean private AccountUserService accountUserService;

  /**
   * Test {@link AccountUserController#getAccountUserById(int)}.
   *
   * <ul>
   *   <li>Given {@link AccountUser} (default constructor) AccountId is one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#getAccountUserById(int)}
   */
  @Test
  @DisplayName(
      "Test getAccountUserById(int); given AccountUser (default constructor) AccountId is one; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.getAccountUserById(int)"})
  void testGetAccountUserById_givenAccountUserAccountIdIsOne_thenStatusIsOk() throws Exception {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");
    when(accountUserService.getAccountUserById(anyInt())).thenReturn(accountUser);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(
            MockMvcRequestBuilders.get("/accountuser/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"accountId\":1,\"username\":\"janedoe\"}"));
  }

  /**
   * Test {@link AccountUserController#getAccountUserById(int)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#getAccountUserById(int)}
   */
  @Test
  @DisplayName("Test getAccountUserById(int); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.getAccountUserById(int)"})
  void testGetAccountUserById_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountUserService.getAccountUserById(anyInt()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(
            MockMvcRequestBuilders.get("/accountuser/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountUserController#createAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#createAccountUser(AccountUser)}
   */
  @Test
  @DisplayName(
      "Test createAccountUser(AccountUser); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.createAccountUser(AccountUser)"})
  void testCreateAccountUser_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/accountuser/");
    postResult.characterEncoding("https://example.org/example");

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        postResult
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link AccountUserController#createAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#createAccountUser(AccountUser)}
   */
  @Test
  @DisplayName("Test createAccountUser(AccountUser); then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.createAccountUser(AccountUser)"})
  void testCreateAccountUser_thenStatusIsInternalServerError() throws Exception {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/accountuser/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(
            content()
                .string("Not enough variable values available to expand 'people.service.url'"));
  }

  /**
   * Test {@link AccountUserController#updateAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Given {@link AccountUser} (default constructor) AccountId is one.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#updateAccountUser(AccountUser)}
   */
  @Test
  @DisplayName(
      "Test updateAccountUser(AccountUser); given AccountUser (default constructor) AccountId is one; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.updateAccountUser(AccountUser)"})
  void testUpdateAccountUser_givenAccountUserAccountIdIsOne_thenStatusIsOk() throws Exception {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");
    when(accountUserService.upsertAccountUser(Mockito.<AccountUser>any())).thenReturn(accountUser);

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(1);
    accountUser2.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/accountuser/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"accountId\":1,\"username\":\"janedoe\"}"));
  }

  /**
   * Test {@link AccountUserController#updateAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#updateAccountUser(AccountUser)}
   */
  @Test
  @DisplayName(
      "Test updateAccountUser(AccountUser); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.updateAccountUser(AccountUser)"})
  void testUpdateAccountUser_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen()
      throws Exception {
    // Arrange
    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");
    when(accountUserService.upsertAccountUser(Mockito.<AccountUser>any())).thenReturn(accountUser);

    MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/accountuser/");
    putResult.characterEncoding("https://example.org/example");

    AccountUser accountUser2 = new AccountUser();
    accountUser2.setAccountId(1);
    accountUser2.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        putResult
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser2));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link AccountUserController#updateAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isInternalServerError()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#updateAccountUser(AccountUser)}
   */
  @Test
  @DisplayName("Test updateAccountUser(AccountUser); then status isInternalServerError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.updateAccountUser(AccountUser)"})
  void testUpdateAccountUser_thenStatusIsInternalServerError() throws Exception {
    // Arrange
    when(accountUserService.upsertAccountUser(Mockito.<AccountUser>any()))
        .thenThrow(new HttpClientErrorException(HttpStatus.OK));

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/accountuser/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("200 OK"));
  }

  /**
   * Test {@link AccountUserController#updateAccountUser(AccountUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#updateAccountUser(AccountUser)}
   */
  @Test
  @DisplayName("Test updateAccountUser(AccountUser); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.updateAccountUser(AccountUser)"})
  void testUpdateAccountUser_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountUserService.upsertAccountUser(Mockito.<AccountUser>any()))
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    AccountUser accountUser = new AccountUser();
    accountUser.setAccountId(1);
    accountUser.setUsername("janedoe");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put("/accountuser/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(accountUser));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountUserController#getAllAccountUsers()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#getAllAccountUsers()}
   */
  @Test
  @DisplayName("Test getAllAccountUsers(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.getAllAccountUsers()"})
  void testGetAllAccountUsers_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(accountUserService.getAllAccountUsers())
        .thenThrow(new ResourceNotFoundException("An error occurred"));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(MockMvcRequestBuilders.get("/accountuser/").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("An error occurred"));
  }

  /**
   * Test {@link AccountUserController#getAllAccountUsers()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#getAllAccountUsers()}
   */
  @Test
  @DisplayName("Test getAllAccountUsers(); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.getAllAccountUsers()"})
  void testGetAllAccountUsers_thenStatusIsOk() throws Exception {
    // Arrange
    when(accountUserService.getAllAccountUsers()).thenReturn(new ArrayList<>());

    // Act and Assert
    MockMvcBuilders.standaloneSetup(accountUserController)
        .build()
        .perform(MockMvcRequestBuilders.get("/accountuser/").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link AccountUserController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}.
   *
   * <ul>
   *   <li>Then StatusCode return {@link HttpStatus}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccountUserController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  @DisplayName(
      "Test resourceNotFoundExceptionMapper(ResourceNotFoundException); then StatusCode return HttpStatus")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity AccountUserController.resourceNotFoundExceptionMapper(ResourceNotFoundException)"
  })
  void testResourceNotFoundExceptionMapper_thenStatusCodeReturnHttpStatus() {
    // Arrange and Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult =
        accountUserController.resourceNotFoundExceptionMapper(
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
   * Test {@link AccountUserController#generalError(Exception)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then StatusCode return {@link HttpStatus}.
   * </ul>
   *
   * <p>Method under test: {@link AccountUserController#generalError(Exception)}
   */
  @Test
  @DisplayName("Test generalError(Exception); when Exception(); then StatusCode return HttpStatus")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity AccountUserController.generalError(Exception)"})
  void testGeneralError_whenException_thenStatusCodeReturnHttpStatus() {
    // Arrange and Act
    ResponseEntity<String> actualGeneralErrorResult =
        accountUserController.generalError(new Exception());

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
