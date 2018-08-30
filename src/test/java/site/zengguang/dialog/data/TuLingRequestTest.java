package site.zengguang.dialog.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

public class TuLingRequestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTuLingRequestPerceptionUserInfo() {
        TuLingRequest tlReq = new TuLingRequest(null,null);
        Assert.isTrue(null!=tlReq);
    }

    @Test
    public void testTuLingRequestStringPerceptionUserInfo() {
        TuLingRequest tlReq = new TuLingRequest(null,null,null);
        Assert.isTrue(null!=tlReq);
    }

}
