package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration  // Marks this as a configuration class
@ComponentScan(basePackages = "se.lexicon.data_access")  // Scans for components in this package
public class ComponentScanConfig {
    @Bean // Defines a bean for Scanner
    public Scanner scanner() {
        return new Scanner(System.in); // Creates a Scanner object that Spring will inject
    }
}

