package com.programatori.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private AuthClient authClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("Authorization");

        String url = request.getRequestURL().toString();
        System.out.println(url);
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = authClient.verify(token);
            if(responseEntity.getBody().equals(true)){
                HttpHeaders httpHeaders = responseEntity.getHeaders();
                List<String> roles = httpHeaders.get("roles");
                String role = roles.get(0);
                System.out.println(role);
                ctx.addZuulRequestHeader("roles", role);
            }
        }catch (Exception e){

        }


        return null;
    }


}
