package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DaoFactory {
	@Bean
	public UserDao userdao() throws ClassNotFoundException, SQLException{
		return new UserDao(Oracle());
	}
	@Bean
	public DbConnection Oracle(){
		return new OracleDbConnection();
	}
}
