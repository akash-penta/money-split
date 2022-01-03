package com.split.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.split.dto.EachPersonDTO;
import com.split.dto.ReportDTO;

@Service
public class SpiltService {

	public ArrayList<ReportDTO> getReport(List<EachPersonDTO> eachPersonDTOList) {
		
		HashMap<String, Double> data = new HashMap<String,Double>();
		double total_amount = 0;
		
		for(EachPersonDTO eachPersonDTO: eachPersonDTOList) {	
			data.put(eachPersonDTO.getName(), eachPersonDTO.getAmount());
			total_amount += eachPersonDTO.getAmount();
		}
		
		double split_amount = total_amount/data.size();
		ArrayList<ReportDTO> reportDTOList = new ArrayList<>();
		
		for(String consider_key: data.keySet()) {
			HashMap<String, Double> reportMap = new HashMap<String, Double>();
			reportMap.putAll(data);
			
			for(Map.Entry kv: reportMap.entrySet()) {
				if(kv.getKey().equals(consider_key)) {
					reportMap.put(consider_key, 0.0);
				}
				else {
					reportMap.put((String) kv.getKey(), (double)Math.round(((double) kv.getValue() - split_amount)*100)/100);
				}
			}
			ReportDTO reportDTO = new ReportDTO(consider_key);
			ArrayList<EachPersonDTO> neg = new ArrayList<>();
			ArrayList<EachPersonDTO> pos = new ArrayList<>();
			for(Map.Entry kv: reportMap.entrySet()) {
				if((double)kv.getValue() < 0) {
					neg.add(new EachPersonDTO((String)kv.getKey(), Math.abs((double)kv.getValue())));
				}
				else if((double)kv.getValue() > 0) {
					pos.add(new EachPersonDTO((String)kv.getKey(), Math.abs((double)kv.getValue())));
				}
			}
			reportDTO.setNeg(neg);
			reportDTO.setPos(pos);
			reportDTOList.add(reportDTO);
		}
		return reportDTOList;
	}
}
