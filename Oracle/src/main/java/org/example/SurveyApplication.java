package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.example.config.SurveyConfiguration;
import org.example.resources.SurveyResource;

/**
 * The main application class for the Survey application.
 * <p>
 * This class extends Dropwizard's {@link Application} and sets up the environment
 * for the Survey service, including registering resources, health checks, and Swagger
 * documentation.
 * </p>
 */
public class SurveyApplication extends Application<SurveyConfiguration> {

    /**
     * The entry point for the Survey application.
     * <p>
     * This method starts the Dropwizard application and sets up necessary configurations
     * by calling the {@link #run(SurveyConfiguration, Environment)} method.
     * </p>
     *
     * @param args Command line arguments passed to the application
     * @throws Exception if there is any issue starting the application
     */
    public static void main(String[] args) throws Exception {
        new SurveyApplication().run(args);
    }

    /**
     * Configures the Survey application.
     * <p>
     * This method registers Swagger, the Survey resource, the OpenAPI UI, and health checks
     * with the Dropwizard environment.
     * </p>
     *
     * @param configuration the configuration for the Survey application
     * @param environment the Dropwizard environment used to register resources and services
     */
    @Override
    public void run(SurveyConfiguration configuration, Environment environment) {

        // Set up Swagger for the application
        SwaggerBundle<SurveyConfiguration> swaggerBundle = new SwaggerBundle<SurveyConfiguration>() {
            /**
             * Provides the Swagger configuration from the Survey application's configuration.
             *
             * @param configuration the configuration to retrieve the Swagger settings
             * @return the Swagger configuration
             */
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(SurveyConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        };

        // Register the Swagger bundle with the Dropwizard environment
        environment.jersey().register(swaggerBundle);

        // Register the Survey resource class to handle HTTP requests
        environment.jersey().register(SurveyResource.class);

        // Register the OpenAPI UI (Swagger UI) for visual API documentation
        environment.jersey().register(OpenApiResource.class);

        // Register the health check for the Survey service
        environment.healthChecks().register("survey-health-check", new SurveyHealthCheck());
    }
}
