package com.atd.onlineWarranties.lib;

import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Milan Yadav on 04-01-2018.
 */
public class Test {

    public static void main(String s[]) throws IOException, ParseException {


        Test t = new Test();
        String item[] = {"My Profile", "Messages", "Approvals"};
        List<String> newList = Arrays.asList(item);
        String s1 = "sfas fsf 12";
//        System.out.println(s1.replaceAll("[^A-Za-z]",""));
        System.out.println(s1.replaceAll("[0-9]", ""));
//        getJSONData(System.getProperty("user.dir")+"/TestData/PortalTestData1.json");
        getJSONDataArray(System.getProperty("user.dir")+"/TestData/PortalTestData.json");
    }

    public static void getJSONData(String jsonFilePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(jsonFilePath));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray getArray = (JSONArray) jsonObject.get("category");
        for (int i = 0; i < getArray.size(); i++) {
            JSONObject jsonObjectRow = (JSONObject) getArray.get(i);
            String num = (String) jsonObjectRow.get("num");
            String solution = (String) jsonObjectRow.get("solution");
            System.out.println(num+solution);
        }
    }

    public static void getJSONDataArray(String jsonFilePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(jsonFilePath));
        JSONArray jArray = (JSONArray)obj;
        for (int j=0;j<jArray.size();j++) {
            System.out.println("Sol "+((JSONObject) jArray.get(j)).get("solution")+
                    "-->>Num "+((JSONObject) ((JSONArray) obj).get(j)).get("num"));
        }
    }
}