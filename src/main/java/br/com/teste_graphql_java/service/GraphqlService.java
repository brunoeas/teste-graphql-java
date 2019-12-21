package br.com.teste_graphql_java.service;

import java.util.Collections;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.teste_graphql_java.dto.GraphqlInputDTO;
import br.com.teste_graphql_java.startup.SchemaLoader;
import graphql.ExecutionInput;
import graphql.ExecutionResult;

/**
 * Service do GraphQL
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@Path("/graphql")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GraphqlService {

    /**
     * Schema Loader
     */
    @Inject
    SchemaLoader schemaLoader;

    /**
     * Executa uma request com GraphQL
     * 
     * @return Response status 200 OK
     */
    @POST
    public Response execute(final GraphqlInputDTO graphqlInput) {

        final ExecutionInput input = this.mountInput(graphqlInput);

        final ExecutionResult result = schemaLoader.getGraphql().execute(input);

        return Response.ok(result).build();
    }

    /**
     * Monta um Execution Input com o GraphqlInputDTO
     * 
     * @param graphqlInput - DTO do GraphQL Input
     * @return Um Execution Input
     */
    private ExecutionInput mountInput(final GraphqlInputDTO graphqlInput) {

        return ExecutionInput.newExecutionInput()
                .query(graphqlInput.getQuery())
                .variables(graphqlInput.getVariables() != null ? graphqlInput.getVariables() : Collections.emptyMap())
                .operationName(graphqlInput.getOperationName())
                .build();
    }

}