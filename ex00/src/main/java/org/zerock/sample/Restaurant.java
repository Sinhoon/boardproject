package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class Restaurant {

	/* 
	@Setter(onMethod_ = @Autowired) 
	private Chef chef;
	 */	 

	/*
	private final Chef chef;
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	*/
	
	@NonNull
	private	Chef chef;

}
