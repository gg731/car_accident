package repository;

import model.Accident;
import model.AccidentType;
import model.Rule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        int id = jdbc.update(
                "insert into accident(name,text,address,type_id) values(?,?,?,?)",
                accident.getName(), accident.getText(),
                accident.getAddress(), accident.getType().getId());

        accident.setId(id);
        return accident;
    }

    public List<Accident> getAllAccidents() {
        return jdbc.query("select * from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    accident.setType(typeById(rs.getInt("type_id")));

                    return accident;
                });
    }

    public void updateAccident(Accident accident) {
        jdbc.update(
                "update accident set name =" + accident.getName()
                        + " text = " + accident.getText()
                        + " address = " + accident.getAddress()
                        + " type_id = " + accident.getType().getId()
                        + " where id = " + accident.getId());
    }

    public AccidentType typeById(int id) {
        return jdbc.queryForObject("select * from type where id = ?",
                (rs, rowNum) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));

                    return accidentType;
                }, id);
    }

    public Accident accidentById(int id) {
        return jdbc.queryForObject("select * from accident where id = ?",
                (rs, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    accident.setType(typeById(rs.getInt("type_id")));

                    return accident;
                }, id);
    }

    public Rule ruleById(int id) {
        return jdbc.queryForObject("select * from rule where id = ?",
                (rs, rowNum) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));

                    return rule;
                }, id);
    }

    public List<Rule> getAllRules() {
        return jdbc.query("select * from rule",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));

                    return rule;
                });
    }

    public List<AccidentType> getAllTypes() {
        return jdbc.query("select * from type",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));

                    return type;
                });
    }
}
