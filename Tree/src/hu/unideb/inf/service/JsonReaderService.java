package hu.unideb.inf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.unideb.inf.model.Tree;
import hu.unideb.inf.model.TreeListHolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonReaderService {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    public ArrayList<Tree> readTreesFromJsonToArrayList(String fileName){
        try {
            TreeListHolder treeListHolder = OBJECT_MAPPER.readValue(new File(fileName), TreeListHolder.class);
            return treeListHolder.getAdatok();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
