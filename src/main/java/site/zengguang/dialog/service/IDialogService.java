package site.zengguang.dialog.service;

import java.util.Map;

public interface IDialogService {

    /**
     * 单个问答机器人回复.
     * 
     * @param map, key[
     *                  question: 用户提问信息]
     * @param sessionId 访问用户的sessionId
     * @return
     */
    Map<String, Object> getBotAnswer(Map<String, Object> map, String sessionId);

}
