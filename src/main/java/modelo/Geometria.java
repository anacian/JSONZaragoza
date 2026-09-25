package modelo;

import java.util.List;

/**
 * @author Ana Cianca
 *
 * @description Represents the object geometry of every JSON monument
 * @date 23/09
 * @version 1.0
 */
public class Geometria {
    private String type;
    private List<Double> coordinates;

    /**
     * Returns value's type
     *
     * @return type value
     */
    public String getType() {
        return type;
    }

    /**
     * Establish value's type
     *
     * @param type new geometry's type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the coordinates' list
     *
     * @return coordinates' list [x, y] or null
     */
    public List<Double> getCoordinates() {
        return coordinates;
    }

    /**
     * Establish coordinates' list
     * @param coordinates new list
     */
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
