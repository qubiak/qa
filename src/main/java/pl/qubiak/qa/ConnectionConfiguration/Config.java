package pl.qubiak.qa.ConnectionConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/qa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    /*
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        String sql = "CREATE TABLE qa(id int AUTO_INCREMENT, question varchar(255), like_counter int, PRIMARY KEY (id));";
        getJdbcTemplate().update(sql);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit2() {
        String sql = "CREATE TABLE qaanswer ( `id` INT NOT NULL AUTO_INCREMENT , `questionId` INT NOT NULL , `answer` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`));";
        getJdbcTemplate().update(sql);
     */
}
