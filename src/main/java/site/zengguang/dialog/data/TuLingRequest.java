package site.zengguang.dialog.data;

/**
 * 图灵API v2.0请求参数.
 * 请求地址：http://openapi.tuling123.com/openapi/api/v2
 * @see https://www.kancloud.cn/turing/www-tuling123-com/718227
 * 
 * @author zengguang
 *
 */
public class TunLingRequest {
    
    // 输入类型:0-文本(默认)、1-图片、2-音频
    String reqType;
    
    // 输入信息
    Perception perception;
    
    // 用户参数
    UserInfo userInfo;

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
}
