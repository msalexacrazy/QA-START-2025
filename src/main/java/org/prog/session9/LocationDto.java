package org.prog.session9;

import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private String city;
    private String state;
    private String country;
    private CoordinatesDto coordinates;
    private String postcode;
    private TimezoneDto timezone;
}