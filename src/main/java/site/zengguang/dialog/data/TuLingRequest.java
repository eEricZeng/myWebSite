package site.zengguang.dialog.data;

import org.apache.commons.lang.Validate;

/**
 * 图灵API v2.0请求参数. 请求地址：http://openapi.tuling123.com/openapi/api/v2
 * 
 * @see https://www.kancloud.cn/turing/www-tuling123-com/718227
 * 
 * @author zengguang
 *
 */
public class TuLingRequest {

    // 输入类型:0-文本(默认)、1-图片、2-音频
    String reqType;

    // 输入信息
    Perception perception;

    // 用户参数
    UserInfo userInfo;

    public TuLingRequest(Perception perception, UserInfo userInfo) {
        this.reqType = new Integer(0).toString();
        Validate.notNull(perception);
        Validate.notNull(userInfo);
        this.perception = perception;
        this.userInfo = userInfo;
    }

    public TuLingRequest(String reqType, Perception perception, UserInfo userInfo) {
        Validate.notEmpty(reqType);
        Validate.notNull(perception);
        Validate.notNull(userInfo);
        this.reqType = reqType;
        this.perception = perception;
        this.userInfo = userInfo;
    }

    public String getReqType() {
        return reqType;
    }

    public Perception getPerception() {
        return perception;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public String toString() {
        return "TuLingRequest [reqType=" + reqType + ", perception=" + perception + ", userInfo=" + userInfo + "]";
    }

}
