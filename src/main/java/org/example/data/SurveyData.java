package org.example.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@ToString
public class SurveyData {

    @Schema(description = "The age of the survey participant", example = "25", required = true)
    @NotNull
    private int age;

    @Schema(description = "The gender of the survey participant", allowableValues = {"male", "female", "other"}, required = true)
    @NotNull
    private String gender;

    @Schema(description = "The region of the survey participant", example = "North America", required = true)
    @NotNull
    private String region;

    @Schema(description = "The unique ID of the survey", example = "survey123", required = true)
    @NotNull
    private String surveyID;

    @Schema(description = "The score given by the survey participant", example = "4", required = true, minimum = "1", maximum = "5")
    @Min(1)
    @Max(5)
    private int score;

}
