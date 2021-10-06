package Oblig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.scene.paint.Color;

public class MyColor {
    public static String getColorName(Color color) {
        Map<String, String> colorCodesToString = new HashMap<String, String>();
        String hexColor = "#" + Integer.toHexString(color.hashCode()).substring(0, 6);
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(
                "C:\\Users\\Sivert\\Nextcloud\\Documents\\Skole-USN\\2020 Høst\\OBJ1000\\VSCode\\Skole\\src\\Oblig\\ColorPicker.json")) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray colors = (JSONArray) jsonObject.get("colors");
            Iterator colorsIterator = colors.iterator();
            while (colorsIterator.hasNext()) {
                JSONObject slide = (JSONObject) colorsIterator.next();
                colorCodesToString.put((String) slide.get("hexString"), (String) slide.get("name"));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        }
        if (colorCodesToString.get(hexColor) == null)
            return hexColor;
        return colorCodesToString.get(hexColor);
    }
}
