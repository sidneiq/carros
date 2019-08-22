package com.example.carros.enums;

public enum StatusRest {


	ERROR("error");
	//SUCCESS("success");

	private String status = "";

	private StatusRest(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return getStatus();
	}
}
