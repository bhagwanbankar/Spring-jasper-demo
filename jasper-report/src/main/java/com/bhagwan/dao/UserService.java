package com.bhagwan.dao;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public JasperPrint exportPdfFiles() throws SQLException, JRException, IOException {
		return userDao.exportPdfFile();
	}
	
	
}
