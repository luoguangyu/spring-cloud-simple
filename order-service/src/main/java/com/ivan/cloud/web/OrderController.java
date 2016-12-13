package com.ivan.cloud.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ivan.Luo
 * Date: 12/6/2016 10:30 AM
 */
@RestController
public class OrderController
{
	private final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getString()
	{
		logger.debug("in hello method");
		return "hello";
	}
}
