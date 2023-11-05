package com.example.spring_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpringStudyApplication {

	public static void main(String[] args) {

		ServletWebServerFactory servletWebServerFactory = new TomcatServletWebServerFactory();
		WebServer webServer = servletWebServerFactory.getWebServer(
				servletContext -> {
					servletContext.addServlet("hello", new HttpServlet() {
						@Override
						protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
							super.service(req, resp);

							HelloController helloController = new HelloController();

							//인증,보안, 공통기능 처리

							if (req.getRequestURL().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
								resp.setStatus(HttpStatus.OK.value());
								resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
								resp.getWriter().println("hello servlet");

							} else if (req.getRequestURL().equals("/user")) {
								String name = req.getParameter("name");
								String hi = helloController.hello(name);

								resp.setStatus(HttpStatus.OK.value());
								resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
								resp.getWriter().println(hi);
							} else {

							}

						}
					}).addMapping("/*");
				}
		);
		webServer.start();

	}

}
