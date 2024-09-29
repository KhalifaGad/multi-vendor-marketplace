package org.khalifa.multi_vendor_marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.graphql.GraphQlAutoConfiguration;

@SpringBootApplication(exclude = GraphQlAutoConfiguration.class)
public class MultiVendorMarketplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiVendorMarketplaceApplication.class, args);
    }

}
