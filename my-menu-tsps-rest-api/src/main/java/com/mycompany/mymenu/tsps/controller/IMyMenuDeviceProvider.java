package com.mycompany.mymenu.tsps.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.cache.NoCache;

public interface IMyMenuDeviceProvider {

	@GET
	@Path("/my-menu/devices")
	@NoCache
	public Response getDevices(@Context HttpServletRequest request);

}
