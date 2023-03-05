package org.kcatucuamba.appmockito.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private  static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "kcatucuamba");
        map.put("age", "25");
        String jsonResponse = "";
        try {
            jsonResponse = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        logger.info(jsonResponse);
    }
}
