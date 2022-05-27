package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -160391855426550256L;
	private Integer roomId;
    private String categoryName;
    private BigDecimal totalPrice;
    private List<PriceDetail> priceDetail;

}


