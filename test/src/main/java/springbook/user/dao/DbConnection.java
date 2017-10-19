package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
	public Connection newMaker() throws SQLException, ClassNotFoundException;
}
