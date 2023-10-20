package th.co.pt.ptgapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataAccessConfig {
	
	@Autowired
    private Environment env;
	
	/*@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}*/
	// Transaction manager bean definition
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
	    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
	    dataSourceTransactionManager.setDataSource(dataSourceSQLSERVER());

	    return dataSourceTransactionManager;
	}
	/*@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}*/

	@Bean(name = "dataSourceSQLSERVER")
	public DataSource dataSourceSQLSERVER() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbcSQLSERVER.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbcSQLSERVER.url"));
		dataSource.setUsername(env.getProperty("jdbcSQLSERVER.username"));
		dataSource.setPassword(env.getProperty("jdbcSQLSERVER.password"));
		return dataSource;
	}
 
	@Bean(name = "jdbcTemplateSQLSERVER")
	public JdbcTemplate jdbcTemplateSQLSERVER() {
		return new JdbcTemplate(dataSourceSQLSERVER());
	}

	@Bean(name = "npJdbcTemplate")
	public NamedParameterJdbcTemplate npJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSourceSQLSERVER());
	}
}

