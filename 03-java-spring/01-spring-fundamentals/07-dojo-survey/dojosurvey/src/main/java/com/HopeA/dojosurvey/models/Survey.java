package com.HopeA.dojosurvey.models;

public class Survey {
	private String name;
	private String location;
	private String favorite;
	private String comment;
	public Survey(String name, String location, String favorite, String comment) {
		this.name = name;
		this.location = location;
		this.favorite = favorite;
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
