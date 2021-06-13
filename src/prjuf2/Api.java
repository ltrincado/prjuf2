package prjuf2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Api {
    public static void main() {
        try {
            LocalDate date = LocalDate.now().minusDays(1);
            URL url = new URL("https://api.covid19tracking.narrativa.com/api/" + date.toString());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));

            JSONObject jsonObject1 = (JSONObject) jsonObject.get("dates");
            JSONObject dates = (JSONObject) jsonObject1.get(date.toString());
            JSONObject countries = (JSONObject) dates.get("countries");
            JSONObject Namibia = (JSONObject) countries.get("Namibia");
            System.out.println("El número de morts a Afghanistan a dia " + date + " és de: " + Namibia.get("today_confirmed") + ".");
            JSONObject spain = (JSONObject) countries.get("Spain");

            JSONArray regions = (JSONArray) spain.get("regions");
            for (int i = 0; i < regions.size(); i++) {
                JSONObject regio = (JSONObject) regions.get(i);
                if (regio.get("name").toString().contains("Cataluña")) {
                    System.out.println("El número de contagiats a Catalunya a dia " + date + " és de: " + regio.get("today_confirmed") + ".");
                }
                if (regio.get("name").toString().contains("C. Valenciana")) {
                    System.out.println("El número de nous casos a la comunitat valenciana a dia " + date + " és de: " + regio.get("today_new_open_cases") + ".");
                }
                JSONArray provincies = (JSONArray) regio.get("sub_regions");
                for (int j = 0; j < provincies.size(); j++) {
                    JSONObject provincia = (JSONObject) provincies.get(j);
                    if (provincia.get("name").toString().contains("Gerona")) {
                        System.out.println("El número de contagiats a la província de Girona a dia " + date + " és de: " + provincia.get("today_confirmed") + ".");
                    }
                    if (provincia.get("name").toString().contains("Castellón")) {
                        System.out.println("El número de contagiats a la província de Castelló a dia " + date + " és de: " + provincia.get("today_deaths") + ".");
                    }
                }
            }
            connection.disconnect();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
