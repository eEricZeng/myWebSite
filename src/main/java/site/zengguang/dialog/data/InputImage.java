package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0 输入图片信息.
 * 
 * @author zengguang
 *
 */
public class InputImage {

    // 图片地址
    @NotBlank
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
