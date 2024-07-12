package com.example.sumpractbackv1.model.dto.response;

import java.time.LocalDate;

import com.example.sumpractbackv1.model.entity.InitialED;

import lombok.*;

@Data
public class InitialEDResponse {

	private Long edno;

	private LocalDate edDate;

	private Long edAuthor;

	public InitialEDResponse(InitialED initialED) {
		this.edno = initialED.getEdno();
		this.edDate = initialED.getEdDate();
		this.edAuthor = initialED.getEdAuthor();
	}
	
}
