package site.zengguang.util.http;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSONObject;
import site.zengguang.dialog.data.InputText;
import site.zengguang.dialog.data.Perception;
import site.zengguang.dialog.data.TuLingRequest;
import site.zengguang.dialog.data.UserInfo;

public class HttpClientUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPost() {
        String url = "http://openapi.tuling123.com/openapi/api/v2";
        InputText inputText = new InputText();
        inputText.setText("hello world！");
        Perception perception = new Perception();
        perception.setInputText(inputText);
        UserInfo userInfo = new UserInfo();
        userInfo.setApiKey("apiKey");
        userInfo.setUserId("userId");
        TuLingRequest tl = new TuLingRequest();
        tl.setReqType("0");
        tl.setPerception(perception);
        tl.setUserInfo(userInfo);
        JSONObject map = JSONObject.fromObject(tl);
        JSONObject obj = HttpClientUtils.httpPost(url,map);
        System.out.println(obj);
    }

}
