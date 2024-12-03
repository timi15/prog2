package hu.unideb.inf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Evszak tel = new Evszak(1, "tel");
        Evszak tavasz = new Evszak(2, "tavasz");
        Evszak nyar = new Evszak(3, "nyar");
        Evszak osz = new Evszak(4, "osz");

        Cipo cipo1 = new Cipo("1111", 32.4, "feher", tel);
        Cipo cipo2 = new Cipo("1112", 40.0, "fekete", tavasz);
        Cipo cipo3 = new Cipo("1113", 40.5, "kek", osz);
        Cipo cipo4 = new Cipo("1114", 38.0, "feher", osz);
        Cipo cipo5 = new Cipo("1115", 27.5, "feher", tel);
        Cipo cipo6 = new Cipo("1116", 45.5, "fekete", nyar);
        Cipo cipo7 = new Cipo("1117", 43.0, "feher", nyar);
        Cipo cipo8 = new Cipo("1118", 47.5, "szurke", tavasz);
        Cipo cipo9 = new Cipo("1119", 36.0, "feher", osz);
        Cipo cipo10 = new Cipo("1110", 37.5, "zold", tel);

        ArrayList<Cipo> cipoList = new ArrayList<>(List.of(cipo1, cipo2, cipo3, cipo4, cipo5, cipo6, cipo7, cipo8, cipo9, cipo10));
        cipoList.forEach(System.out::println);

        System.out.println();

        HashMap<Evszak, ArrayList<Cipo>> cipoMap = new HashMap<>();
        ArrayList<Cipo> cipok;
        for (int i = 0; i < cipoList.size(); i++) {
            Cipo cipo = cipoList.get(i);
            if(cipoMap.containsKey(cipo.getEvszak())){
                cipok = cipoMap.get(cipo.getEvszak());
            }else{
                cipok = new ArrayList<>();
            }
            cipok.add(cipo);
            cipoMap.put(cipo.getEvszak(), cipok);
        }

        for (Map.Entry<Evszak, ArrayList<Cipo>> cipo : cipoMap.entrySet()){
            System.out.println(cipo.getKey()+"\t"+cipo.getValue());
        }



    }
}