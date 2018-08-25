package pl.oskarpolak.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherModel {

    @JsonProperty("main")
    private TempModel tempModel;

    @JsonProperty("clouds")
    private CloudModel cloudModel;

    @Data
    public static class TempModel {
         private double temp;
    }

    @Data
    public static class CloudModel {
        @JsonProperty("all")
        private double cloudy;
    }
}
