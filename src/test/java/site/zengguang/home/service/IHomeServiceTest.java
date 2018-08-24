package site.zengguang.home.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/springmvc/spring-mvc.xml", "classpath*:/application.xml"})
public class IHomeServiceTest {

    @Autowired
    private IHomeService homeService;
    Map<String,Object> map = null;
    
    @SuppressWarnings("serial")
    @Before
    public void setUp() throws Exception {
        map = new HashMap<String,Object>() {{
            this.put("email", "549373335@qq.com");
            this.put("name", "coder");
            this.put("message", "HELLO WORLD");
        }};
    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testSendEmail() {
        homeService.emailService(map);
    }

}
