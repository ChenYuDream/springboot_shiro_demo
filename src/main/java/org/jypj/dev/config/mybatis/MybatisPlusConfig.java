package org.jypj.dev.config.mybatis;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.plugins.parser.ISqlParser;
import com.baomidou.mybatisplus.plugins.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantHandler;
import com.baomidou.mybatisplus.plugins.parser.tenant.TenantSqlParser;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import com.baomidou.mybatisplus.toolkit.PluginUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYu
 */
@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan("org.jypj.dev.dao*")
public class MybatisPlusConfig {

    private final MybatisPlusProperties properties;

    public MybatisPlusConfig(MybatisPlusProperties properties) {
        this.properties = properties;
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 PageHelper 的支持
        paginationInterceptor.setLocalPage(true);
        return paginationInterceptor;
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(properties.resolveMapperLocations());
        factory.setTypeAliasesPackage(properties.getTypeAliasesPackage());
        MybatisConfiguration configuration = this.properties.getConfiguration();
        if (configuration == null) {
            configuration = new MybatisConfiguration();
        }
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        configuration.setLogPrefix("mapper.");
        factory.setPlugins(new Interceptor[]{paginationInterceptor(), performanceInterceptor()});
        GlobalConfiguration globalConfig = null;
        try {
            globalConfig = properties.getGlobalConfig().convertGlobalConfiguration();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        if (globalConfig == null) {
            globalConfig = new GlobalConfiguration();
        }
        globalConfig.setIdType(3);
        globalConfig.setDbColumnUnderline(true);
        factory.setConfiguration(configuration);
        factory.setGlobalConfig(globalConfig);
        return factory;
    }
}
