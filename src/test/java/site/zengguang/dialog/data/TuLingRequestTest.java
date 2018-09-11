package site.zengguang.dialog.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TuLingRequestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTuLingRequestPerceptionUserInfo() {
        new TuLingRequest(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTuLingRequestStringPerceptionUserInfo() {
        new TuLingRequest(null, null, null);
    }

}
