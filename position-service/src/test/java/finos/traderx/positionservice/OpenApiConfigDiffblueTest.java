package finos.traderx.positionservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.junit.jupiter.api.Test;

class OpenApiConfigDiffblueTest {
  /**
   * Method under test: {@link OpenApiConfig#config()}
   */
  @Test
  void testConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OpenAPI actualConfigResult = (new OpenApiConfig()).config();

    // Assert
    List<Server> servers = actualConfigResult.getServers();
    assertEquals(2, servers.size());
    Server getResult = servers.get(0);
    assertEquals("", getResult.getUrl());
    Info info = actualConfigResult.getInfo();
    assertEquals("0.1.0", info.getVersion());
    assertEquals("3.0.1", actualConfigResult.getOpenapi());
    assertEquals("Empty URL to help proxied documentation work", getResult.getDescription());
    assertEquals("FINOS TraderX Position Service", info.getTitle());
    Server getResult2 = servers.get(1);
    assertEquals("Local Dev URL", getResult2.getDescription());
    assertEquals("Service for retrieving blotter data, for trades and positions", info.getDescription());
    assertEquals("http://localhost:18090", getResult2.getUrl());
    assertNull(actualConfigResult.getComponents());
    assertNull(actualConfigResult.getExternalDocs());
    assertNull(actualConfigResult.getPaths());
    assertNull(info.getContact());
    assertNull(info.getLicense());
    assertNull(getResult.getVariables());
    assertNull(getResult2.getVariables());
    assertNull(actualConfigResult.getJsonSchemaDialect());
    assertNull(info.getSummary());
    assertNull(info.getTermsOfService());
    assertNull(actualConfigResult.getSecurity());
    assertNull(actualConfigResult.getTags());
    assertNull(actualConfigResult.getWebhooks());
    assertNull(actualConfigResult.getExtensions());
    assertNull(info.getExtensions());
    assertNull(getResult.getExtensions());
    assertNull(getResult2.getExtensions());
    assertEquals(SpecVersion.V30, actualConfigResult.getSpecVersion());
  }
}
