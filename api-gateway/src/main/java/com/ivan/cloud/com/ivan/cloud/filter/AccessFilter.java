package com.ivan.cloud.com.ivan.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ivan.Luo
 * Date: 12/8/2016 10:12 AM
 */
public class AccessFilter extends ZuulFilter
{
	private final Logger logger = Logger.getLogger(getClass());

	/**
	 * Following filter type define when the filter will be applied
	 * pre: before routing
	 * routing: at routing
	 * post: after all routing and error
	 * error: at error
	 * @return
	 */
	@Override
	public String filterType()
	{
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		return 0;
	}

	@Override
	public boolean shouldFilter()
	{
		return true;
	}

	@Override
	public Object run()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getHeader("accessToken");
		if(accessToken == null) {
			logger.warn("accessToken in http header is empty");
			// don't route the request
			ctx.setSendZuulResponse(false);
			ctx.setResponseBody("accessToken in http header is empty");
			ctx.setResponseStatusCode(401);
			return null;
		}
		logger.info("access token ok");
		return null;
	}
}
