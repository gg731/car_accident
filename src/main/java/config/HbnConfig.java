package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class HbnConfig {

    @Bean
    public DataSource ds(@Value("${jdbc.driver}") String driver,
                         @Value("${jdbc.url}") String url,
                         @Value("${jdbc.username}") String username,
                         @Value("${jdbc.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(@Value("${hibernate.dialect}") String dialect,
                                                  @Value("${hibernate.show_sql}") String showSql,
                                                  DataSource ds) {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setPackagesToScan("model");
        Properties ps = new Properties();
        ps.setProperty("hibernate.dialect", dialect);
        ps.setProperty("hibernate.show_sql", showSql);
        sf.setHibernateProperties(ps);
        return sf;
    }

    @Bean
    public PlatformTransactionManager htx(SessionFactory sf) {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf);
        return htm;
    }

}
