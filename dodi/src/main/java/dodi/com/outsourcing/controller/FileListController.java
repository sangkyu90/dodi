package dodi.com.outsourcing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dodi.com.outsourcing.service.FileListService;

@Controller
public class FileListController {
	@Autowired
	private FileListService flService;
	
	

}