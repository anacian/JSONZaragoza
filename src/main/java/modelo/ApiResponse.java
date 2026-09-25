package modelo;

import java.util.List;

/**
 * @author Ana Cianca
 *
 * @description Object Geometry of every monument
 * @date 22/09
 * @version 1.0
 */
public class ApiResponse {
    // Numero total de monumentos de la API
    private int totalCount;
    // Indice de inicio de la pagina de resultados
    private int start;
    // Numero de filas solicitadas mediante parametro rows
    private int rows;
    // List of monuments receive from the petition
    private List<Monumento> result;

    /**
     * Returns the total amount of monuments from the API
     * @return totalCount value
     */
    public int getTotalCount() { return totalCount; }

    /**
     * Establish the total amount of monuments
     * @param totalCount new value
     */
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

    /**
     * Returns the index  of the first result page
     * @return start's value
     */
    public int getStart() { return start; }

    /**
     * Establish the index
     * @param start's new value
     */
    public void setStart(int start) { this.start = start; }

    /**
     * Returns the number of rows
     * @return row's value
     */
    public int getRows() { return rows; }

    /**
     * Establish the number of rows
     * @param rows's new number
     */
    public void setRows(int rows) { this.rows = rows; }

    /**
     * Returns the list of monuments
     * @return monument's list
     */
    public List<Monumento> getResult() { return result; }

    /**
     * Establish the list of monumentos
     * @param result's new value
     */
    public void setResult(List<Monumento> result) { this.result = result; }
}