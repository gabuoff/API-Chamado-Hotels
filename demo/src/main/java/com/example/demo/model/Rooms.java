package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class Rooms implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -160391855426550256L;
	
	private Integer roomID;
	private String categoryName;
	private PriceDetail priceDetail;

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	public void setPrice(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	
	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rooms rooms = (Rooms) o;
        return Objects.equals(roomID, rooms.roomID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID);
    }
}


