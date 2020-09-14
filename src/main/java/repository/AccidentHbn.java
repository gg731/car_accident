package repository;

import model.Accident;
import model.AccidentType;
import model.Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccidentHbn {
    private final SessionFactory sf;

    public AccidentHbn(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident saveAccident(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public Accident updateAccident(Accident accident) {
        try (Session session = sf.openSession()) {
            session.update(accident);
            return accident;
        }
    }

    public List<Accident> getAllAccident() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident ", Accident.class)
                    .list();
        }
    }

    public List<Rule> getAllRule() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule ", Rule.class)
                    .list();
        }
    }

    public List<AccidentType> getAllType() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType ", AccidentType.class)
                    .list();
        }
    }

    public Accident accidentById(int id) {
        try (Session session = sf.openSession()) {
            return session.find(Accident.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public Rule ruleById(int id) {
        try (Session session = sf.openSession()) {
            return session.find(Rule.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
