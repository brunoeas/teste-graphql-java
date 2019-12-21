package br.com.teste_graphql_java.dto;

import java.util.Map;

/**
 * DTO dos dados para fazer a request no modelo do GraphQL
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
public class GraphqlInputDTO {

    /**
     * Nome da operação
     */
    private String operationName;

    /**
     * Variáveis
     */
    private Map<String, Object> variables;

    /**
     * Query
     */
    private String query;

    public String getOperationName() {
        return this.operationName;
    }

    public void setOperationName(final String operationName) {
        this.operationName = operationName;
    }

    public Map<String, Object> getVariables() {
        return this.variables;
    }

    public void setVariables(final Map<String, Object> variables) {
        this.variables = variables;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(final String query) {
        this.query = query;
    }

}