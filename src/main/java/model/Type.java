package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Type() {
    }

    public static Type of(int id, String name) {
        Type accidentType = new Type();
        accidentType.id = id;
        accidentType.name = name;
        return accidentType;
    }

    public static Type of(int id) {
        Type accidentType = new Type();
        accidentType.id = id;
        return accidentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type that = (Type) o;
        return id == that.id
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
