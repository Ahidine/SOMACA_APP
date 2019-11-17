package org.Sid.service;

import org.Sid.dao.MyTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.Sid.entities.MyTable;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.List;
@Service
public class FileService {
	@Autowired
	MyTableRepository MyTableRepository;
	// Store File Data to Database
		public void store(MultipartFile file){
			try {
				List<MyTable> lstCustomers = ExcelGenerator.parseExcelFile(file.getInputStream());
	    		// Save Customers to DataBase
				
	    		MyTableRepository.saveAll(lstCustomers);
	        } catch (IOException e) {
	        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
	        }
		}
}
