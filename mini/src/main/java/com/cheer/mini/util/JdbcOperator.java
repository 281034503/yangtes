package com.cheer.mini.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface JdbcOperator {
	public int callback(Statement stmt)throws SQLException;
}
