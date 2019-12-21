package br.com.teste_graphql_java.startup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.coxautodev.graphql.tools.SchemaParser;

import br.com.teste_graphql_java.dto.LivroDTO;
import br.com.teste_graphql_java.resolver.MutationResolver;
import br.com.teste_graphql_java.resolver.QueryResolver;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

/**
 * Loader do Schema
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@ApplicationScoped
public class SchemaLoader {

    /**
     * Query Resolver
     */
    @Inject
    QueryResolver queryResolver;

    /**
     * Mutation Resolver
     */
    @Inject
    MutationResolver mutationResolver;

    /**
     * GraphQL
     */
    private GraphQL graphql;

    /**
     * Executa no Startup e setta o GraphQL
     */
    @PostConstruct
    public void onStartup() {
        final GraphQLSchema schema = SchemaParser.newParser()
                .schemaString(this.getSchema())
                .resolvers(queryResolver, mutationResolver)
                .dictionary("LivroInput", LivroDTO.class)
                .build()
                .makeExecutableSchema();

        this.graphql = GraphQL.newGraphQL(schema).build();
    }

    /**
     * Retorna o Schema convertido em String
     * 
     * @return O Schema em String
     */
    private String getSchema() {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(this.getSchemaFile()))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retorna o arquivo do Schema
     * 
     * @return O arquivo .graphql com o Schema
     */
    private InputStream getSchemaFile() {
        return this.getClass().getClassLoader().getResourceAsStream("graphql/schema.graphqls");
    }

    /**
     * Get do GraphQL
     * 
     * @return O GraphQL
     */
    public GraphQL getGraphql() {
        return this.graphql;
    }

}