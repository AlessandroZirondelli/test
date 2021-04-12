package provaTest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.UnaryOperator;

//import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class RW<X>{
    private class LocalDateConverter implements JsonSerializer < LocalDate >,  JsonDeserializer < LocalDate > {
        @Override
        public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
            //return new JsonPrimitive( DateTimeFormatter.ofPattern("d-MMM-yyyy").format(localDate));
        	return new JsonPrimitive( DateTimeFormatter.ofPattern("d-MMM-yyy").format(localDate));
           
        }
   
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
           // return LocalDate.parse(json.getAsString(),
         //       DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ITALIAN));
           // return LocalDate.parse(json.getAsString(),DateTimeFormatter.ofPattern("d-MMM-yyyy"));
            return LocalDate.parse(json.getAsString(),DateTimeFormatter.ofPattern("d-MMM-yyy"));
        }
    }
   private class LocalTimeConverter implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime>{

    @Override
    public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        // TODO Auto-generated method stub
        return DateTimeFormatter.ISO_LOCAL_TIME.parse(json.getAsString(),LocalTime::from);
    }

    @Override
    public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
        // TODO Auto-generated method stub
        return new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_TIME.format(src));
    }
       
   }
 /*   private class LocalDateDeserializer implements JsonDeserializer < LocalDate > {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
        throws JsonParseException {
            return LocalDate.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("d-MMM-yyyy").withLocale(Locale.ITALIAN));
        }
    }
    private static class LocalDateSerializer implements JsonSerializer < LocalDate > {
        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        @Override
        public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(localDate));
        }
    }
    */
    /*
     
      */
    
        String FS = File.separator;
        String filename = System.getProperty("user.home") + FS + "prova" + FS + "file2.json";
    
    public void write(Set<X> set) {
 

        GsonBuilder gsonB = new GsonBuilder();
        gsonB.registerTypeAdapter(LocalDate.class, new LocalDateConverter());
        gsonB.registerTypeAdapter(LocalTime.class, new LocalTimeConverter());
        Gson gson=gsonB.create();
        // Java objects to String
        // String json = gson.toJson(staff);
        
        // Java objects to File
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(set, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  Set<X> read(Class<?> cls) {
       // TypeToken t1 = TypeToken().get(cls) ;
      //  TypeToken t = new TypeToken<>() {}.get(cls);
        GsonBuilder gsonB = new GsonBuilder();
        gsonB.registerTypeAdapter(LocalTime.class, new LocalTimeConverter());
        gsonB.registerTypeAdapter(LocalDate.class, new LocalDateConverter());
        Gson gson=gsonB.create();
        Set<X> coll= new HashSet<>();
                    try (Reader reader = new FileReader(filename)) {
                      // Type set = new TypeToken<Set<X>>(){}.getType();
                   //   Type typeSet = type; 
                        Type typeSet = TypeToken.getParameterized(Set.class, cls).getType();
                        coll = gson.fromJson(reader,typeSet);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        return coll;
        
        
    
        
    }

}

