package org.example;

import com.codahale.metrics.health.HealthCheck;


/**
 * A health check for the Survey application.
 * <p>
 * This health check performs a simple check to determine if the application is healthy.
 * The check always returns a healthy status.
 * </p>
 */
public class SurveyHealthCheck extends HealthCheck {

    /**
     * Performs the health check.
     *
     * @return the result of the health check, indicating whether the application is healthy or not
     * @throws Exception if any unexpected error occurs while performing the health check
     */
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
