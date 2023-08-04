package models;

import enums.StationType;
import lombok.Data;

@Data
public class Station {
    private String id;
    private String station;
    private StationType type;
    private Orbit orbit;
}
