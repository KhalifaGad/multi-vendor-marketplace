package org.khalifa.multi_vendor_marketplace.lib.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Profile;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
@Profile("server")
public class ConstraintViolationExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected List<GraphQLError> resolveToMultipleErrors(@NotNull Throwable exception, @NotNull DataFetchingEnvironment env) {
        if (!(exception instanceof ConstraintViolationException constraintViolationException)) {
            return super.resolveToMultipleErrors(exception, env);
        }

        return constraintViolationException
                .getConstraintViolations()
                .stream()
                .map(this::mapViolationToGraphQLError)
                .toList();
    }

    private GraphQLError mapViolationToGraphQLError(ConstraintViolation<?> violation) {
        var path = Arrays.stream(violation.getPropertyPath().toString().split("\\."))
                .reduce((first, second) -> second).orElseThrow();

        return GraphqlErrorBuilder.newError()
                .message(violation.getMessage())
                .path(Collections.singletonList(path))
                .extensions(Map.of("type", "VALIDATION"))
                .build();
    }
}
