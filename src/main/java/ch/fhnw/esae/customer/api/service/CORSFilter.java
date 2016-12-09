/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.esae.customer.api.service;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author andreas.martin
 */
@Provider
public class CORSFilter implements ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
        String requestheader = requestContext.getHeaderString("Access-Control-Request-Headers");
        if (requestheader != null && !"".equals(requestheader)) {
            responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", requestheader);
        }
        responseContext.getHeaders().add("Access-Control-Max-Age", "86400");
    }
}
    
