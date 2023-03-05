package Presentation.Conf;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@ApplicationScoped
@DataSourceDefinition(
        name = "jdbc/postgres",
        className = "org.postgresql.jdbc3.Jdbc3PoolingDataSource",
        user = "test",
        password = "test",
        url = "jdbc:tc:postgresql:15.2:///test",
        properties = {
                "allowPublicKeyRetrieval=true",
                "useSSL=false",
                "requireSSL=false"
        }
)
public class Main extends Application {
}
