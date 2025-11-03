package finos.traderx.accountservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import finos.traderx.accountservice.exceptions.ResourceNotFoundException;
import finos.traderx.accountservice.service.AccountUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountUserController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AccountUserControllerDiffblueTest {
  @Autowired
  private AccountUserController accountUserController;

  @MockBean
  private AccountUserService accountUserService;

  /**
   * Method under test:
   * {@link AccountUserController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  void testResourceNotFoundExceptionMapper() {
    // Arrange and Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult = accountUserController
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
   * {@link AccountUserController#resourceNotFoundExceptionMapper(ResourceNotFoundException)}
   */
  @Test
  void testResourceNotFoundExceptionMapper2() {
    // Arrange
    ResourceNotFoundException e = mock(ResourceNotFoundException.class);
    when(e.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    ResponseEntity<String> actualResourceNotFoundExceptionMapperResult = accountUserController
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
   * Method under test: {@link AccountUserController#generalError(Exception)}
   */
  @Test
  void testGeneralError() {
    // Arrange and Act
    ResponseEntity<String> actualGeneralErrorResult = accountUserController.generalError(new Exception("foo"));

    // Assert
    HttpStatusCode statusCode = actualGeneralErrorResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("foo", actualGeneralErrorResult.getBody());
    assertEquals(500, actualGeneralErrorResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertTrue(actualGeneralErrorResult.hasBody());
    assertTrue(actualGeneralErrorResult.getHeaders().isEmpty());
  }
}
