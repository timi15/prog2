package hu.unideb.inf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Telepules {
    private String nev;
    private Integer iranyitoszam;
    private Integer lakossag;
    @JsonFormat( pattern = "dd/MM/yyyy")
    private LocalDate alapitasDatuma;
    private String megye;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telepules telepules)) return false;
        return Objects.equals(iranyitoszam, telepules.iranyitoszam);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(iranyitoszam);
    }
}
