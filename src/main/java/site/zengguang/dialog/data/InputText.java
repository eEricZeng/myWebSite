package site.zengguang.dialog.data;

import javax.validation.constraints.NotBlank;

/**
 * 图灵API v2.0输入文本信息.
 * 
 * @author zengguang
 *
 */
public class InputText {

    /**
     * 输入文本.
     */
    @NotBlank
    private String text;

    /**
     * 输入文本构造函数.
     * 
     * @param text 用户输入的文本
     */
    public InputText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "InputText [text=" + text + "]";
    }

}
