package Application.Commands.ApplicationUser.Create;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
class CreateApplicationUserControllerTest {

    @Container
    private PostgreSQLContainer dbContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:15.2")
    );

    @BeforeEach
    void setUp()
    {
        Flyway flyway = Flyway.configure()
                .dataSource(dbContainer.getJdbcUrl(), dbContainer.getUsername(), dbContainer.getPassword())
                .cleanDisabled(false)
                .load();
        flyway.clean();
        flyway.migrate();
    }



    @Test
    void handle() {
        String email = "test@test.com";
        String password = "password";

        //var result = new CreateApplicationUser().Handle(email, password);
    }
}