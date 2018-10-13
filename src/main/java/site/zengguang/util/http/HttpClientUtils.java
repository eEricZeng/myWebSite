package site.zengguang.util.http;

import java.io.IOException;
import java.net.URLDecoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * HTTP请求工具类。
 * 
 * @author zengguang
 *
 */
@SuppressWarnings("deprecation")
public class HttpClientUtils {
    
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class); 

    /**
     * post请求
     * 
     * @param url 请求地址
     * @param jsonParam 请求参数
     * @return
     */
    @SuppressWarnings({ "resource" })
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        // post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        JSONObject jsonResult = null;
        try {
            url = URLDecoder.decode(url, "UTF-8");
            HttpPost method = new HttpPost(url);
            if (null != jsonParam) {
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            // 请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                try {
                    // 读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(),"UTF-8");
                    // 把json字符串转换成json对象
                    jsonResult = JSONObject.fromObject(str);
                } catch (Exception e) {
                    logger.error("post请求提交失败:" + url, e);
                }
                return jsonResult;
            }
        } catch (IOException e) {
            logger.error("post请求提交失败:" + url, e);
        }
        return null;
    }
    
    /**
     * 禁用工具类的构造方法.
     */
    private HttpClientUtils() {
    }
    
}