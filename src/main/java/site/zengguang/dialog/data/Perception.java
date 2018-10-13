package site.zengguang.dialog.data;

import org.apache.commons.lang.Validate;

/**
 * 图灵API v2.0输入信息.
 * 
 * @author zengguang
 *
 */
public class Perception {

    /**
     * 文本信息
     */
    private InputText inputText;

    /**
     * 图片信息
     */
    private InputImage inputImage;

    /**
     * 音频信息
     */
    private InputMedia inputMedia;

    /**
     * 客户端属性
     */
    private SelfInfo selfInfo;

    /**
     * 仅含有文本信息的输入信息构造函数.
     * 
     * @param inputText
     *            文本信息对象
     */
    public Perception(InputText inputText) {
        Validate.notNull(inputText);
        this.inputText = inputText;
    }

    /**
     * 仅含有图片信息的输入信息构造函数.
     * 
     * @param inputImage
     *            图片信息对象
     */
    public Perception(InputImage inputImage) {
        Validate.notNull(inputImage);
        this.inputImage = inputImage;
    }

    /**
     * 仅含有音频信息的输入信息构造函数.
     * 
     * @param inputMedia
     *            音频信息对象
     */
    public Perception(InputMedia inputMedia) {
        Validate.notNull(inputMedia);
        this.inputMedia = inputMedia;
    }

    /**
     * 文本信息和客户端属性的输入信息构造函数.
     * 
     * @param inputText
     *            文本信息对象
     * @param selfInfo
     *            客户端属性
     */
    public Perception(InputText inputText, SelfInfo selfInfo) {
        this(inputText);
        this.selfInfo = selfInfo;
    }

    /**
     * 音频信息和客户端属性的输入信息构造函数.
     * 
     * @param inputImage
     *            图片信息对象
     * @param selfInfo
     *            客户端属性
     */
    public Perception(InputImage inputImage, SelfInfo selfInfo) {
        this(inputImage);
        this.selfInfo = selfInfo;
    }

    /**
     * 音频信息和客户端属性的输入信息构造函数.
     * 
     * @param inputMedia
     *            音频信息对象
     * @param selfInfo
     *            客户端属性
     */
    public Perception(InputMedia inputMedia, SelfInfo selfInfo) {
        this(inputMedia);
        this.selfInfo = selfInfo;
    }

    public InputText getInputText() {
        return inputText;
    }

    public InputImage getInputImage() {
        return inputImage;
    }

    public InputMedia getInputMedia() {
        return inputMedia;
    }

    public SelfInfo getSelfInfo() {
        return selfInfo;
    }

    @Override
    public String toString() {
        return "Perception [inputText=" + inputText + ", inputImage=" + inputImage + ", inputMedia=" + inputMedia
                + ", selfInfo=" + selfInfo + "]";
    }

}
