package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0 输入音频信息.
 * 
 * @author zengguang
 *
 */
public class InputMedia {

    /**
     *  音频地址.
     */
    @NotBlank
    private String url;
    
    /**
     * 音频信息构造函数.
     * 
     * @param url 音频地址
     */
    public InputMedia(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "InputMedia [url=" + url + "]";
    }

}
