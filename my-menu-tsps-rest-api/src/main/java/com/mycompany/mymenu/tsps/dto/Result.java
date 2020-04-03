package com.mycompany.mymenu.tsps.dto;

public class Result {

	private final String id;
	private final String name;

	public Result(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
