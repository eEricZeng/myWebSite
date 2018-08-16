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
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSendEmail() {
        Map<String,Object> map = new HashMap<>();
        homeService.sendEmail(map);
    }

}
