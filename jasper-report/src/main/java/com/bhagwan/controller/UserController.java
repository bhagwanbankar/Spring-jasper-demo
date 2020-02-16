package com.bhagwan.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bhagwan.dao.UserService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
@RequestMapping("/")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView home() {

		return new ModelAndView("home");

	}

	@GetMapping("/export")
	public void export(ModelAndView model, HttpServletResponse response) throws SQLException, JRException, IOException {

		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));
		OutputStream out = response.getOutputStream();
		jasperPrint = userService.exportPdfFiles();
		logger.info("After getting jasper report stream");
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);

	}
}
