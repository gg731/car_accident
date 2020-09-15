package model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private AccidentType type;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "accident_rule", joinColumns = {
            @JoinColumn(name = "accident_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "rule_id", referencedColumnName = "id")})
    private List<Rule> rules = new ArrayList<>();

    public Accident() {
    }

    public Accident(int id, String name, String text, String address,
                    AccidentType type, List<Rule> rules) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
        this.type = type;
        this.rules = rules;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return id == accident.id
                && Objects.equals(name, accident.name)
                && Objects.equals(text, accident.text)
                && Objects.equals(address, accident.address)
                && Objects.equals(type, accident.type)
                && Objects.equals(rules, accident.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address);
    }
}
