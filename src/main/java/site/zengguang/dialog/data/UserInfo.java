package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0用户参数.
 * 
 * @author zengguang
 *
 */
public class UserInfo {

    // 机器人标识
    @NotBlank
    String apiKey;

    // 用户唯一标识
    @NotBlank
    String userId;

    // 群聊唯一标识
    String groupId;

    // 群内用户昵称
    String userIdName;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
