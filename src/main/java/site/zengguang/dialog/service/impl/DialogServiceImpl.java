package site.zengguang.dialog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import site.zengguang.dialog.data.InputText;
import site.zengguang.dialog.data.Perception;
import site.zengguang.dialog.data.TuLingRequest;
import site.zengguang.dialog.data.UserInfo;
import site.zengguang.dialog.service.IDialogService;
import site.zengguang.util.constant.Constant;
import site.zengguang.util.http.HttpClientUtils;

/**
 * 智能对话业务逻辑层。
 * 
 * @author zengguang
 *
 */
@Service("dialogService")
public class DialogServiceImpl implements IDialogService{
    
    private final String APIKEY = Constant.APIKEY;
    private final String TULING_URL = Constant.TULING_URL;
    private final String RESPONSE = "response";
    private final String SUCCESS = "success";
    private final String SUCCESS_TRUE = "true";
    private final String SUCCESS_FALSE = "false";
    
    /**
     * 单个问答机器人回复.
     * 
     * @param map, key[
     *                  question: 用户提问信息]
     * @param sessionId 访问用户的sessionId
     * @return
     */
    @Override
    public Map<String, Object> getBotAnswer(Map<String, Object> map, String sessionId) {
        Map<String,Object> result = new HashMap<>();
        String question = (String) map.get("question");
        Perception perception = new Perception(new InputText(question));
        UserInfo userInfo = new UserInfo(APIKEY, sessionId);
        TuLingRequest tlReq = new TuLingRequest(perception,userInfo);
        JSONObject obj = HttpClientUtils.httpPost(TULING_URL, JSONObject.fromObject(tlReq));
        if(null==obj) {
            result.put(SUCCESS, SUCCESS_FALSE);
            return result;
        }
        result.put(SUCCESS, SUCCESS_TRUE);
        result.put(RESPONSE, obj);
        return result;
    }

}
