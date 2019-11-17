package org.Sid.web;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.Sid.dao.MyTableRepository;
import org.Sid.entities.MyTable;
import org.Sid.service.ExcelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
@RequestMapping("/api/MyTable")
public class MyTableExcelDownloadRestAPI {
    @Autowired
    MyTableRepository mytableRepository;
 
    @GetMapping(value = "/download/MyTable.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<MyTable> mytable = (List<MyTable>) mytableRepository.findAll();
    
    ByteArrayInputStream in = ExcelGenerator.customersToExcel(mytable);
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=SomacaMyTable.xlsx");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }
}