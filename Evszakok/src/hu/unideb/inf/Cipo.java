package hu.unideb.inf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Cipo {

    @Getter
    @Setter
    private String modellszam;

    @Getter
    @Setter
    private double meret;

    @Getter
    @Setter
    private String szin;

    @Getter
    @Setter
    private Evszak evszak;



}
