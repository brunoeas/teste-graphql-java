package br.com.teste_graphql_java.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

import io.quarkus.runtime.StartupEvent;

/**
 * FlywayController.
 * 
 * @author Stefan Horochovec <stefan.horochovec@kepha.com.br>
 * @since 24/04/2019
 * @version 1.0
 */
@ApplicationScoped
public class FlywayController {

    @ConfigProperty(name = "quarkus.datasource.url")
    String dbURL;

    @ConfigProperty(name = "quarkus.datasource.username")
    String dbUser;

    @ConfigProperty(name = "quarkus.datasource.password")
    String dbPassword;

    /**
     * Faz a migração de schemas.
     */
    void migrate() {
        final Flyway flyway = Flyway.configure().dataSource(dbURL, dbUser, dbPassword).load();
        flyway.migrate();
    }

    /**
     * Inicializa o processo de migration.
     */
    void onStart(@Observes final StartupEvent ev) {
        migrate();
    }

}