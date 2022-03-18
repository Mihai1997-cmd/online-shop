package com.server.spring;

import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.repositories")
public class PersistanceJPAConfig {

    @Autowired
    Environment environment;

    private Logger logger = Logger.getLogger(PersistanceJPAConfig.class.getName());

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println(">>>>>>> creating entityManagerFactory..... ");

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasource());
        entityManagerFactoryBean.setPackagesToScan("com.repositories", "com.models");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());
        return entityManagerFactoryBean;
    }

    private Properties additionalProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "none");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        props.setProperty("hibernate.show_sql", "none");
        props.setProperty("hibernate.jdbc.batch_size", "1000");
        return props;
    }


    @Bean
    public DataSource datasource() {
        System.out.println(">>>> Create dataSource bean");
        String dbDriver = "org.postgresql.Driver";
        String dbUrl = "jdbc:postgresql://localhost:5432/marketdb";
        String dbUsername = "postgres";
        String dbPassword = "postgres";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        //pentru cazul in care este necesar sa executam anumite operatii inainte/dupa fiecare query
        ProxyDataSourceBuilder builder = ProxyDataSourceBuilder.create(dataSource).beforeQuery(this::beforeQuery);
        ProxyDataSource proxyDataSource = builder.build();

        return proxyDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    private void beforeQuery(ExecutionInfo executionInfo, List<QueryInfo> queryInfos){
        String query = queryInfos.get(0).getQuery();
        if(!queryInfos.get(0).getQuery().trim().toLowerCase().startsWith("select")) {
            logger.log(Level.INFO, "befor executing sql:"+query);
        }
    }
}
