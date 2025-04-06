package org.example.resources;

import org.example.data.SurveyData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ArrayList;

/**
 * Resource class for handling survey-related API endpoints.
 * <p>
 * This class provides methods to create a new survey and retrieve all surveys.
 * It simulates the storage of surveys in memory (for demo purposes) and uses
 * Swagger annotations for API documentation.
 * </p>
 */
@Path("/surveys")
@Produces(MediaType.APPLICATION_JSON)
public class SurveyResource {

    // List to simulate a database (for demo purposes)
    private static List<SurveyData> surveys = new ArrayList<>();

    /**
     * Endpoint to create a new survey.
     * <p>
     * This method accepts a survey object in the request body and adds it to the
     * list of surveys. A successful creation returns HTTP 201 (Created), and
     * invalid input results in HTTP 400 (Bad Request).
     * </p>
     *
     * @param newSurvey the survey data to be created
     * @return a Response indicating the result of the operation
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create a new survey", description = "Creates a new survey and returns it")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the survey"),
            @ApiResponse(responseCode = "400", description = "Invalid input provided")
    })
    public Response createSurvey(@Valid @Parameter(description = "Survey object to be created") SurveyData newSurvey) {
        // Simple validation to check if survey data is valid
        if (newSurvey.getAge() <= 0 || newSurvey.getScore() < 0 || newSurvey.getSurveyID() == null || newSurvey.getSurveyID().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid survey data provided").build();
        }

        // Add the new survey to the list (in a real-world scenario, you'd save this to a database)
        surveys.add(newSurvey);

        return Response.status(Response.Status.CREATED).entity(newSurvey).build();
    }

    /**
     * Endpoint to get all surveys.
     * <p>
     * This method retrieves all the surveys stored in memory (simulated) and
     * returns them as a JSON array. If there are no surveys available, it returns
     * HTTP 204 (No Content) with a message indicating that no surveys were found.
     * </p>
     *
     * @return a Response containing the list of surveys or a message indicating no surveys
     */
    @GET
    @Operation(summary = "Get all surveys", description = "Fetches all available surveys")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved surveys")
    })
    public Response getAllSurveys() {
        if (surveys.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("No surveys found").build();
        }
        return Response.ok(surveys).build();
    }
}
