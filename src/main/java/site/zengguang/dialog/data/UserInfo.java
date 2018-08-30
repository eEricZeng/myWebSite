package site.zengguang.dialog.data;

import org.apache.commons.lang.Validate;

/**
 * 图灵API v2.0用户参数.
 * 
 * @author zengguang
 *
 */
public class UserInfo {

    // 机器人标识
    String apiKey;

    // 用户唯一标识
    String userId;

    // 群聊唯一标识
    String groupId;

    // 群内用户昵称
    String userIdName;

    /**
     * 用户参数构造函数.
     * 
     * @param apiKey
     *            图灵机器人apikey
     * @param userId
     *            用户ID
     */
    public UserInfo(String apiKey, String userId) {
        Validate.notEmpty(apiKey);
        Validate.notEmpty(userId);
        this.apiKey = apiKey;
        this.userId = userId;
    }

    public UserInfo(String apiKey, String userId, String groupId, String userIdName) {
        this(apiKey, userId);
        this.groupId = groupId;
        this.userIdName = userIdName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserIdName() {
        return userIdName;
    }

    public void setUserIdName(String userIdName) {
        this.userIdName = userIdName;
    }

}
