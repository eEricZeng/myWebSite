package site.zengguang.dialog.data;

/**
 * 图灵API v2.0输入信息.
 * 
 * @author zengguang
 *
 */
public class Perception {

    // 文本信息
    InputText inputText;
    
    // 图片信息
    InputImage inputImage;
    
    // 音频信息
    InputMedia inputMedia;
    
    // 客户端属性
    SelfInfo selfInfo;

    public InputText getInputText() {
        return inputText;
    }

    public void setInputText(InputText inputText) {
        this.inputText = inputText;
    }

    public InputImage getInputImage() {
        return inputImage;
    }

    public void setInputImage(InputImage inputImage) {
        this.inputImage = inputImage;
    }

    public InputMedia getInputMedia() {
        return inputMedia;
    }

    public void setInputMedia(InputMedia inputMedia) {
        this.inputMedia = inputMedia;
    }

    public SelfInfo getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(SelfInfo selfInfo) {
        this.selfInfo = selfInfo;
    }
    
}
