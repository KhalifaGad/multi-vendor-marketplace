package org.khalifa.multi_vendor_marketplace.config;

import graphql.scalars.ExtendedScalars;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@Profile("server")
public class GraphQLConfig extends GraphQlAutoConfiguration {
    public GraphQLConfig(ListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> {
            wiringBuilder.scalar(ExtendedScalars.DateTime);
            wiringBuilder.scalar(ExtendedScalars.Date);
            wiringBuilder.scalar(ExtendedScalars.UUID);
        };
    }
}
