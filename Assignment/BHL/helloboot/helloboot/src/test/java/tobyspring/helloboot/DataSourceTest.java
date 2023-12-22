package tobyspring.helloboot;

@HellobootTest
public class DataSourceTest {
 @Autowired DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
