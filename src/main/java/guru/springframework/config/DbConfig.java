package guru.springframework.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:custom.properties")
public class DbConfig {

    @Value("${guru.username}")
    public String user;

    @Value("${guru.passwo}")
    String pass;

    @Value("${guru.url}")
    String url;
    
    @Bean
    PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(pass);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

}
