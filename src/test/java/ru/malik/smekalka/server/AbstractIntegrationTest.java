package ru.malik.smekalka.server;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public abstract class AbstractIntegrationTest {
    private static final String POSTGRES_USERNAME = "user";
    private static final String POSTGRES_PASSWORD = "pass";
    private static final String POSTGRES_DB = "db";

    @BeforeAll
    static void setUp() {
        final GenericContainer po = new PostgreSQLContainer("postgres:9.6.10")
                .withPassword(POSTGRES_PASSWORD)
                .withUsername(POSTGRES_USERNAME)
                .withDatabaseName(POSTGRES_DB);
    }
}
