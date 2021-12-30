package com.split.dto;

import java.util.ArrayList;

public class ReportDTO {
	
	private String name;
	private ArrayList<EachPersonDTO> neg = new ArrayList<>();
	private ArrayList<EachPersonDTO> pos = new ArrayList<>();
	
	public ReportDTO() {
		super();
	}
	public ReportDTO(String name) {
		super();
		this.name = name;
	}
	public ReportDTO(String name, ArrayList<EachPersonDTO> neg, ArrayList<EachPersonDTO> pos) {
		super();
		this.name = name;
		this.neg = neg;
		this.pos = pos;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<EachPersonDTO> getNeg() {
		return neg;
	}
	public void setNeg(ArrayList<EachPersonDTO> neg) {
		this.neg = neg;
	}
	public ArrayList<EachPersonDTO> getPos() {
		return pos;
	}
	public void setPos(ArrayList<EachPersonDTO> pos) {
		this.pos = pos;
	}
	
	@Override
	public String toString() {
		return "ReportDTO [name=" + name + ", neg=" + neg + ", pos=" + pos + "]";
	}
}
