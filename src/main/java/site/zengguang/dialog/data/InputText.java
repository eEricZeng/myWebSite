package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0输入文本信息.
 * 
 * @author zengguang
 *
 */
public class InputText {

    // 输入文本
    @NotBlank
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
