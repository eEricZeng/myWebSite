package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0 输入音频信息.
 * 
 * @author zengguang
 *
 */
public class InputMedia {

    // 音频地址
    @NotBlank
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
