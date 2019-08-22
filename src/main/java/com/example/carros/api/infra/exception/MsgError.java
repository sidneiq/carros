package com.example.carros.api.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MsgError {

	public String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

