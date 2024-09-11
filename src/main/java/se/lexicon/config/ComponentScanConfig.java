package se.lexicon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this as a configuration class
@ComponentScan(basePackages = "data_access")  // Scans for components in this package
public class ComponentScanConfig {
}

