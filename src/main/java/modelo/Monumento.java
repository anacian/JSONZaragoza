package modelo;

/**
 * @author Ana Cianca
 *
 * @description POJOS class, deserealization of the JSON
 * @date 22-09-2026
 * @version 1.0
 */
public class Monumento {
    private String title;
    private String horario;
    private Geometria geometry;

    /**
     * Returns monument's title
     * @return title value
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establish title's value
     * @param title new value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns horario value
     * @return horario value
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Establish title's value
     * @param horario new value
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Returns Geometria's value
     * @return geometria's value
     */
    public Geometria getGeometry() {
        return geometry;
    }

    /**
     * Establish title's value
     * @param geometry new value
     */
    public void setGeometry(Geometria geometry) {
        this.geometry = geometry;
    }
}
