package hu.unideb.inf.core;

import hu.unideb.inf.model.Tree;
import hu.unideb.inf.service.JsonReaderService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        JsonReaderService jsonReaderService = new JsonReaderService();

        ArrayList<Tree>trees= jsonReaderService.readTreesFromJsonToArrayList(args[0]);
        trees.forEach(System.out::println);

        System.out.println("\n-----------------1.feladat------------------\n");

        ArrayList<Tree> idosebb90nelEsMagasabbMint10MeterList = new ArrayList<>(idosebb90nelEsMagasabbMint10Meter(trees));
        idosebb90nelEsMagasabbMint10MeterList.forEach(System.out::println);

        System.out.println("\n-----------------2.feladat------------------\n");
        Map<String, Long> besorolasDarabszam = besorolasDarabszam(trees);
        for(Map.Entry<String, Long> tree : besorolasDarabszam.entrySet()){
            System.out.println(tree.getKey()+" "+tree.getValue());
        }

        System.out.println("\n-----------------3.feladat------------------\n");
        double atlag = atlagAr(trees);
        System.out.println(atlag);

        System.out.println("\n-----------------4.feladat------------------\n");
        ArrayList<String> atlagnalDragabbFak = new ArrayList<>(atlagnalDragabbFakNevei(atlag, trees));
        atlagnalDragabbFak.forEach(System.out::println);

        System.out.println("\n-----------------5.feladat------------------\n");
        Tree legmagasabbFa = legmagasabbFa(trees);
        System.out.println(legmagasabbFa);

        System.out.println("\n-----------------6.feladat------------------\n");
        Tree legfiatalabbFa = legfiatalabbFa(trees);
        System.out.println(legfiatalabbFa);
    }

    public static List<Tree> idosebb90nelEsMagasabbMint10Meter(ArrayList<Tree> trees){
        return  trees.stream()
                .filter(tree -> tree.getKorEvben()>90 && tree.getMagassagMeterben()>10)
                .toList();
    }

    public static Map<String, Long> besorolasDarabszam (ArrayList<Tree> trees){
        return  trees.stream()
                .collect(Collectors.groupingBy(Tree::getBesorolas, Collectors.counting()));
    }

    public static double atlagAr(ArrayList<Tree> trees){
        return trees.stream()
                .mapToDouble(Tree::getAr)
                .average()
                .getAsDouble();
    }

    public static List<String> atlagnalDragabbFakNevei(double atlagar, ArrayList<Tree> trees){
        return trees.stream()
                .filter(tree -> tree.getAr()>atlagar)
                .map(Tree::getNev)
                .toList();
    }

    public static Tree legmagasabbFa(ArrayList<Tree> trees){
        return trees.stream()
                .max(Comparator.comparing(Tree::getMagassagMeterben))
                .get();
    }

    public static Tree legfiatalabbFa(ArrayList<Tree> trees){
        return trees.stream()
                .min(Comparator.comparing(Tree::getKorEvben))
                .get();
    }




}