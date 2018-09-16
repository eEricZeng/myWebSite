package site.zengguang.util.security;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author zengguang
 *
 */
public class FormValidator {

    private static StringBuffer pattern = new StringBuffer();

    /**
     * 校验字符串中是否含有非法字符.
     * 
     * @param string
     *            需要校验的字符串
     * @return true:含有非法字符；false: 不包含非法字符
     */
    public static Boolean checkSpecialStr(String string) {

        if (pattern.length() <= 0) {
            List<String> patternList = new ArrayList<String>();
            // 添加正则表达式部分，新的规则只需要在patternList添加
            patternList.add("src[\r\n]*=[\r\n]*\\'(.*?)\\'");
            patternList.add("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"");
            patternList.add("</script>");
            patternList.add("<script(.*?)>");
            patternList.add("eval\\((.*?)\\)");
            patternList.add("expression\\((.*?)\\)");
            patternList.add("javascript:");
            patternList.add("vbscript:");
            patternList.add("onload(.*?)=");
            patternList.add("alert(.*?)");
            patternList.add("onmouseover=");
            patternList.stream().forEach(a -> {
                pattern.append(".*" + a + "*|");
            });
        }

        return Pattern.matches(pattern.toString(), string);
    }
}
