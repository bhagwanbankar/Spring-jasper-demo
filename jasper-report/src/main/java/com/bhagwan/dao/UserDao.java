package com.bhagwan.dao;

import java.io.IOException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface UserDao {

	public JasperPrint exportPdfFile() throws SQLException, JRException, IOException;
	
}
