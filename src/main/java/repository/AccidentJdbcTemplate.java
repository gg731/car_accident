package repository;

import model.Accident;
import model.Type;
import model.Rule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        String sql = "insert into accident(name,text,address,type_id) values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    sql, new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getType().getId());

            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        accident.setId(key.intValue());

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
        String updateAccident = "update accident set name = ?,"
                + " text = ?, address = ?, type_id = ? where ( id = ? );";

        jdbc.update(updateAccident,
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId(),
                accident.getId());
    }

    public Type typeById(int id) {
        return jdbc.queryForObject("select * from type where id = ?",
                (rs, rowNum) -> {
                    Type accidentType = new Type();
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

    public List<Type> getAllTypes() {
        return jdbc.query("select * from type",
                (rs, row) -> {
                    Type type = new Type();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));

                    return type;
                });
    }
}
