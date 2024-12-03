package hu.unideb.inf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.unideb.inf.model.Telepules;
import hu.unideb.inf.model.TelepulesListHolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderService {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    public List<Telepules> readCitiesFromJsonToList(String fileName){
        try {
            TelepulesListHolder telepulesListHolder = OBJECT_MAPPER.readValue(new File(fileName), TelepulesListHolder.class);
            return telepulesListHolder.getAdatok();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
            return new ArrayList<>();
        }
    }
}
