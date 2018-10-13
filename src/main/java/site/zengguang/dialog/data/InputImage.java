package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0 输入图片信息.
 * 
 * @author zengguang
 *
 */
public class InputImage {

    /**
     * 图片地址.
     */
    @NotBlank
    private String url;
    
    /**
     * 图片信息构造函数.
     * 
     * @param url 图片地址
     */
    public InputImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "InputImage [url=" + url + "]";
    }

}
