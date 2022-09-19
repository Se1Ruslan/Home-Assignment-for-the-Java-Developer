package com.example.reverseproject.it;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class ReverseProjectIT {

    public static ReverseProjectContainer APP;

    static {
        APP =
                new ReverseProjectContainer()
                        .withExposedPorts(8080)
                        .withLogConsumer(
                                outputFrame ->
                                        log.info(outputFrame.getUtf8String()));
        APP.start();
    }

    @BeforeAll
    static void beforeAll() {
        await()
                .atLeast(Duration.ofSeconds(1))
                .pollDelay(Duration.ofSeconds(1))
                .pollInterval(Duration.ofSeconds(1))
                .atMost(Duration.ofSeconds(60))
                .until(
                        () -> {
                            log.info("Waiting for spring boot app setting up....");
                            HttpResponse<JsonNode> healthResponse =
                                    Unirest.get(
                                                    "http://localhost:"
                                                            + APP.getFirstMappedPort()
                                                            + "/actuator/health/")
                                            .asJson();
                            return healthResponse.isSuccess()
                                    && "UP"
                                    .equalsIgnoreCase(healthResponse.getBody().getObject().getString("status"));
                        });
        log.info("Spring boot app was started");
    }

    @Test
    @SneakyThrows
    void shouldReturnReversedText() {
        //when
        HttpResponse<String> actualResponse = Unirest.get(
                        "http://localhost:"
                                + APP.getFirstMappedPort()
                                + "/api/reverse?text=12345a")
                .asString();
        String actualResponseBody = actualResponse.getBody();
        log.info("actual = {}", actualResponseBody);

        //then
        assertEquals("a54321", actualResponseBody);
    }

}
