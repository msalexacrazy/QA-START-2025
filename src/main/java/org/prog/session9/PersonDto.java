package org.prog.session9;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PersonDto {
    private String gender;
    private NameDto name;
    private LocationDto location;
    private String nat;
}
