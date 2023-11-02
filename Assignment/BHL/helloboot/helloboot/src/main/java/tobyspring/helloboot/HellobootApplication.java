package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration//구성정보를 가지고 있는 클래스이다.
@ComponentScan
public class HellobootApplication {
	@Bean
	public ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	@Bean
	public DispatcherServlet dispatcherServlet(){
		return new DispatcherServlet();
	}
//	@Bean
//	public HelloController helloController(HelloService helloService){
//		return new HelloController(helloService);
//	}
//	//인터페이스 타입으로 리턴
//	@Bean
//	public HelloService helloService(){
//		return new SimpleHelloService();
//	}
//	public static void main(String[] args) {
//		MySpringApplication.run(HellobootApplication.class, args);
		//익명클래스 사용
		//자바코드로 만든 구성정보를 사용하려면 2가지 작업이 더 필요함
		//GenericWeb은 자바코드로 만든 구성정보를 읽을 수 없음
//		ServletWebServerFactory serverFactory= new TomcatServletWebServerFactory();
//        WebServer webServer=serverFactory.getWebServer(servletContext -> {
//			servletContext.addServlet("dispatcherServlet",
//						new DispatcherServlet(applicationContext)
//					new HttpServlet() {
//			//HelloController helloController=new HelloController(helloService);
//            //servletContext.addServlet("frontcontroller", new HttpServlet() {
//				@Override
//				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//					//인증,보안,다국어,공통 기능
//					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
//						String name = req.getParameter("name");
//						//if(req.getRequestURI().equals("/hello")&&req.getMethod().equals(HttpMethod.GET.name())){
//						HelloController helloController=applicationContext.getBean(HelloController.class);
//						String ret=helloController.hello(name);
//						//super.service(req, resp); //service 매소드 (요청,응답)
//						//resp.setStatus(200); //1번 상태 코드
//						//resp.setStatus(HttpStatus.OK.value());//200
//						//resp.setHeader("Content-Type","text/plain");//2번 header
//						//resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
//						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
//						//resp.getWriter().println("Hello " + name);//3번 header의 contents type에 해당하는 body
//						resp.getWriter().println(ret);
//					}
////					else if (req.getRequestURI().equals("/user")){}
//					else{
//						resp.setStatus(HttpStatus.NOT_FOUND.value());
//					}
//				}//mapping이 필요->mapping 부분 바꾸기
//			}
//			).addMapping("/*");//.addMapping("/hello");
//        });
//		webServer.start();
//	}
	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class,args);
	}
}
