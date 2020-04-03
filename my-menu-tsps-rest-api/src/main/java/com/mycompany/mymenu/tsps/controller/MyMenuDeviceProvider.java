package com.mycompany.mymenu.tsps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mycompany.mymenu.tsps.dto.Result;

public class MyMenuDeviceProvider implements IMyMenuDeviceProvider {

	@Override
	public Response getDevices(final HttpServletRequest request) {

		final List<Result> list = new ArrayList<>();
		IntStream.range(0, 100).forEach(i -> list.add(new Result(String.valueOf(i), "server" + i + ".mycompany.com")));
		return Response.ok(list, MediaType.APPLICATION_JSON).build();
	}

}
