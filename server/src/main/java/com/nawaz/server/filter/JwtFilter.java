package com.nawaz.server.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@CrossOrigin (origins = "*" , exposedHeaders = "**")
public class JwtFilter extends OncePerRequestFilter {
	@Value("${UI.BASE.URL}")
	String UI_BASE_URL;
	
//	@Override
//	protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//			throws IOException, ServletException, MalformedJwtException {
//		final HttpServletRequest request = (HttpServletRequest) servletRequest;
//		final HttpServletResponse response = (HttpServletResponse) servletResponse;
//		final String authHeader = request.getHeader("authorization");
//		
//			try {
////				if("OPTIONS".equals(request.getMethod())) {
////					response.setStatus(HttpServletResponse.SC_OK);
////					filterChain.doFilter(request, response);
////				}
//					
//				if(authHeader!=null && authHeader.startsWith("Bearer ")){
//					final String token = authHeader.substring(7);
//					Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
//					request.setAttribute("claims", claims);
//					request.setAttribute("blog", servletRequest.getParameter("id"));
//				}else {
//					throw new ServletException("JWT Filter Exception");
//				}
//	
//			}catch(MalformedJwtException e) {
//				response.sendError(400, "JWT token is wrong");
////				e.printStackTrace();
//			}catch(ServletException e) {
//				response.sendError(400, "JWT token is wrong");
////				e.printStackTrace();
//			}
//
//		filterChain.doFilter(request, response);
//	}

	@Override
	protected void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain)
	throws IOException, ServletException, MalformedJwtException {
		System.out.println("filter started");
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.addHeader("Access-Control-Allow-Headers",
//                "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Content-Type, "
//                + "Access-Control-Request-Method, Access-Control-Request-Headers");
//        if (response.getHeader("Access-Control-Allow-Origin") == null)
//            response.addHeader("Access-Control-Allow-Origin", UI_BASE_URL);

//	    Enumeration<String> headerNames = request.getHeaderNames();
//
//	    if (headerNames != null) {
//	            while (headerNames.hasMoreElements()) {
//	                    System.out.println("Header: " + request.getHeader(headerNames.nextElement()));
//	            }
//	    }

		if(request.getHeader("content-type")!=null||request.getHeader("GET")!=null){
        
//        System.out.println("header names: " + servletRequest.getHeader);
		final String headersPresent = request.getHeader("HeadersPresent");
		final String authHeader = request.getHeader("Authorization");
		System.out.println("original authheader: "+request.getHeader("Authorization"));
//		final String authHeader = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGl6IiwiaWF0IjoxNjgyMjQxMjkyfQ.U_mZ3M3ZJnVtGMl5k7-ngocQ-wx59Hqcu2As7OmGN-g";
		
			try {		
				System.out.println("authHeader: "+authHeader);
				if(authHeader!=null && authHeader.startsWith("Bearer ")){
					final String token = authHeader.substring(7);
					System.out.println("filter started 1");

					Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
					System.out.println("filter started 2");

					request.setAttribute("claims", claims);
					System.out.println("filter started 3");

//					request.setAttribute("blog", servletRequest.getParameter("id"));
				}else {
					throw new ServletException("JWT Filter Exception");
				}
	
			}catch(MalformedJwtException e) {
				System.out.println("filter catch 1");

					response.sendError(401, "JWT token is wrong");
//					e.printStackTrace();					
			}catch(ServletException e) {
				System.out.println("filter catch 2");
				System.out.println(e.getMessage());

					response.sendError(401, "JWT token is wrong");
//					e.printStackTrace();					
			}

			System.out.println(response);
	}
		filterChain.doFilter(request, response);		
	}

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
}
