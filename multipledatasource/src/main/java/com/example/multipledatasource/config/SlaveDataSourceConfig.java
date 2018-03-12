package com.example.multipledatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactorySlave",
    transactionManagerRef = "transactionManagerSlave",
    basePackages = {"com.example.multipledatasource.slave"}
)
public class SlaveDataSourceConfig {

    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource masterDataSource;



    @Primary
    @Bean(name = "entityManagerSlave")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryMaster(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name="entityManagerFactorySlave")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(masterDataSource)
                .properties(getVendorProperties(masterDataSource))
                .packages("com.example.multipledatasource.slave")
                .persistenceUnit("SlavePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String,String> getVendorProperties(DataSource dataSource){
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerSlave")
    public PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
    }




}
