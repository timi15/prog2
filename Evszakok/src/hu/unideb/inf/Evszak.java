package hu.unideb.inf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
public class Evszak {
    @Getter
    @Setter
    private int sorszam;

    @Getter
    @Setter
    private String nev;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evszak evszak)) return false;
        return Objects.equals(nev, evszak.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nev);
    }
}
