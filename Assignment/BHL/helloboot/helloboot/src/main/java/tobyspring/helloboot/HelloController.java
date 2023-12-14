package tobyspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


//@RestController
@RestController
//메타 어노테이션(어노테이션 코드위에 어노테이션을 붙이는것)
public class HelloController  {
    //@GetMapping("/hello")
    private final HelloService helloService;
    private final ApplicationContext applicationContext;
    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;

        System.out.println(applicationContext);
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
   @GetMapping("/hello")
    public String hello(String name) {
       
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println(applicationContext);
//        this.applicationContext=applicationContext;
//    }
}
