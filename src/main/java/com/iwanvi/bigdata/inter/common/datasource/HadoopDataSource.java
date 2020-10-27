package com.iwanvi.bigdata.inter.common.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.FileNotFoundException;

/**
 * hadoop_data 数据库
 */
@Configuration
@MapperScan(basePackages = "com.iwanvi.bigdata.inter.dao.hadoop_data",
        sqlSessionTemplateRef = "hadoopDataSqlSessionTemplate")
public class HadoopDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopDataSource.class);

    @Bean(name = "hadoopDataDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hadoopdata")
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "hadoopDataTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("hadoopDataDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hadoopDataSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("hadoopDataDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = patternResolver.getResources("classpath:mapper/hadoop_data/*.xml");
            bean.setMapperLocations(resources);
        } catch (FileNotFoundException fileNotFoundException){
            LOGGER.warn("mapper/hadoop_data/ 目录还没有任何Mapper.xml文件哦！");
        }
        return bean.getObject();
    }

    @Bean(name = "hadoopDataSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("hadoopDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
