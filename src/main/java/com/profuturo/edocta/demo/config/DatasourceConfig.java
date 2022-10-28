package com.profuturo.edocta.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public class DatasourceConfig {

	@Value("${autenticacion.driver-name}")
	private String AUT_DRIVER;

	@Value("${autenticacion.url}")
	private String AUT_URL;

	@Value("${autenticacion.user}")
	private String AUT_USER;

	@Value("${autenticacion.password}")
	private String AUT_PASSWORD;

	@Bean(name = "dsAut")
	public DataSource dsAut() {
		return DataSourceBuilder.create().driverClassName(AUT_DRIVER).url(AUT_URL).username(AUT_USER)
				.password(AUT_PASSWORD).build();
	}

	@Bean(name = "jdbcAut")
	@Autowired
	public JdbcTemplate jdbcAut(@Qualifier("dsAut") DataSource dsAut) {
		return new JdbcTemplate(dsAut);

	}

	@Bean(name = "txmAut")
	@Autowired
	public DataSourceTransactionManager txmAut(@Qualifier("dsAut") DataSource datasource) {
		DataSourceTransactionManager txAut = new DataSourceTransactionManager(datasource);
		return txAut;
	}

}
