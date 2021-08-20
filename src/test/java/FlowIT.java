import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import service.driver.LeetcodeMailDriver;
import service.spring.config.LeetcodeConfig;

@RunWith(SpringRunner.class)
@Import({LeetcodeConfig.class})
public class FlowIT {

    @Autowired
    LeetcodeMailDriver leetcodeMailDriver;

    @Before
    public void before() {
    }

    @Test
    public void FlowIt() {
        leetcodeMailDriver.drive();
    }

}
