package tobyspring.helloboot;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {
	public static void main(String[] args) {
		ServletWebServerFactory serverFactory= new TomcatServletWebServerFactory();
        //익명 클래스
        WebServer webServer=serverFactory.getWebServer(servletContext -> {
			HelloController helloController=new HelloController();
            servletContext.addServlet("frontcontroller", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					//인증,보안,다국어,공통 기능
					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");
						String ret=helloController.hello(name);
						//super.service(req, resp); //service 매소드 (요청,응답)
						//resp.setStatus(200); //1번 상태 코드
						resp.setStatus(HttpStatus.OK.value());//200
						//resp.setHeader("Content-Type","text/plain");//2번 header
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						//resp.getWriter().println("Hello " + name);//3번 header의 contents type에 해당하는 body
						resp.getWriter().println(ret);
					}
					else if (req.getRequestURI().equals("/user")){
						//
					}
					else{
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}//mapping이 필요->mapping 부분 바꾸기
			}).addMapping("/*");//.addMapping("/hello");
        });
		webServer.start();
	}

}
