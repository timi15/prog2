package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;


@Data
@AllArgsConstructor
public class City {
    private String nev;
    private String iranyitoszam;
    private int lakossag;
    private LocalDate alapitasDatuma;
    private String megye;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return Objects.equals(iranyitoszam, city.iranyitoszam);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(iranyitoszam);
    }
}
