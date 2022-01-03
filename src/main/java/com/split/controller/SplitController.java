package com.split.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.split.dto.EachPersonDTO;
import com.split.dto.ReportDTO;
import com.split.service.SpiltService;

@CrossOrigin
@RestController
public class SplitController {

	@Autowired
	SpiltService splitService;
	
	@GetMapping()
	public String welcome() {
		return "<center><h1>Money-Split</h1>"
				+ "<h5>This an API</h5>"
				+ "<h3>Developed by AKASH PENTA</h3></center>";
	}
	
	@PostMapping("/getReport")
	public ArrayList<ReportDTO> getReport(@RequestBody List<EachPersonDTO> eachPersonDTOList) {
		ArrayList<ReportDTO> res = splitService.getReport(eachPersonDTOList);
		return res;
	}
}
