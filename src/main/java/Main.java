import com.fasterxml.jackson.databind.ObjectMapper;
import modelo.ApiResponse;
import modelo.Monumento;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * @author Ana Cianca
 *
 * @description Main program that translates an API from JSON and generates a full report
 * @date 23/09
 * @version 1.0
 */
public class Main {
    /**
     * Entrance point of the program
     * @param args command line argument
     */
    public static void main(String[] args) {
        // Construyo la URL
        String url = "https://www.zaragoza.es/sede/servicio/monumento.json"
                + "?rows=50&fl=title,horario,geometry";

        // Creo el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Construir la petición (URI + método GET)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();


        try {
            // Enviar la petición y capturar la respuesta
            HttpResponse<String> response =
                    client.send(
                            request, HttpResponse.BodyHandlers.ofString()
                    );
            // Comprobar el código de estado
            if (response.statusCode() != 200) {
                System.out.println("HTTP error: " + response.statusCode());
                return;
            }

            // Capturar el cuerpo JSON
            String json = response.body();
            //Interpretar el JSON
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(json, ApiResponse.class);

            List<Monumento> monumentos = apiResponse.getResult();
            System.out.println("ZARAGOZA OPEN MONUMENTS");
            System.out.println("-----------------------");
            System.out.println("Total monuments reported by API: " + apiResponse.getTotalCount());
            System.out.println("Records received: " + monumentos.size());
            System.out.println();
            int c = 1;
            for(Monumento m : monumentos) {
                System.out.println(c + ". " + m.getTitle());

                String horario;

                if (m.getHorario() != null) {
                    horario = m.getHorario();
                } else {
                    horario = "Not available";
                }
                System.out.println("Opening information: " + horario);

                if(m.getGeometry() != null && m.getGeometry().getCoordinates() != null && m.getGeometry().getCoordinates().size() >= 2) {
                    List<Double> coords = m.getGeometry().getCoordinates();
                    System.out.println(" Coordinates " + coords.get(0) + ", " + coords.get(1));
                } else {
                    System.out.println("Coordinates: Not available");
                }
                System.out.println();
                c++;
            }
            // Contar monumentos cuyo titulo contiene "Museo"
            int conMuseo = 0;
            for(Monumento m : monumentos) {
                if(m.getTitle() != null && m.getTitle().toLowerCase().contains("museo")) {
                    conMuseo++;
                }
            }
            System.out.println("Monuments containing \"Museo\" in te title: " + conMuseo);
            System.out.println();

            // Buscar el monumento con mayor y menos segunda coordenada
            Monumento mayor = null;
            Monumento menor = null;

            for(Monumento m : monumentos) {
                boolean tieneCoordenadas = m.getGeometry() != null && m.getGeometry().getCoordinates() != null && m.getGeometry().getCoordinates().size() >= 2;
                if(tieneCoordenadas) {
                    double segunda = m.getGeometry().getCoordinates().get(1);
                    if(mayor == null) {
                        mayor = m;
                    } else if(segunda > mayor.getGeometry().getCoordinates().get(1)) {
                        mayor = m;
                    }

                    if(menor == null) {
                        menor = m;
                    } else if (segunda < menor.getGeometry().getCoordinates().get(1)) {
                        menor = m;
                    }
                }
            }
            System.out.println("Greatest second coordinate:");
            System.out.println("   " + mayor.getTitle() + " -> " + mayor.getGeometry().getCoordinates().get(1));

            System.out.println("Smallest second coordinate:");
            System.out.println("   " + menor.getTitle() + " -> " + menor.getGeometry().getCoordinates().get(1));



        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
