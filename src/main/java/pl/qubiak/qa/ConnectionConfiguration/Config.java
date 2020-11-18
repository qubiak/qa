package pl.qubiak.qa.ConnectionConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;
import java.util.Collections;

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

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/**"))
                .apis(RequestHandlerSelectors.basePackage("pl.qubiak.qa.Controller"))
                .build().apiInfo(CreateApiInfo());
    }

    private ApiInfo CreateApiInfo() {
        return new ApiInfo("Question and Answer API",
                "Application for asking questions during e.g. a presentation.",
                "1.00",
                "https://github.com/qubiak",
                new Contact("Bartłomiej Kubiak", "https://github.com/qubiak", "kubiak1986@gmail.com"),
                "my own licence",
                "https://github.com/qubiak",
                Collections.emptyList()
        );

    }

    /*
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        String sql = "CREATE TABLE question(id int AUTO_INCREMENT, question varchar(255), like_counter int, PRIMARY KEY (id));";
        getJdbcTemplate().update(sql);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit2() {
        String sql = "CREATE TABLE answer ( `id` INT NOT NULL AUTO_INCREMENT , `questionId` INT NOT NULL , `answer` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`));";
        getJdbcTemplate().update(sql);

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit3() {
        String sql = "CREATE TABLE room ( `id` INT NOT NULL AUTO_INCREMENT , `roomName` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`));";
        getJdbcTemplate().update(sql);
     */
}
