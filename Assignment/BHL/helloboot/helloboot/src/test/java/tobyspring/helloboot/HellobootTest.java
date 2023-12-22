package tobyspring.helloboot;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HellobootApplication.class)
@TestPropertySource("classpath:/application.properties")
@Transactional
public class @interface HellobootTest {
}
