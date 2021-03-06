package site.zengguang.dialog.data;

import org.apache.commons.lang.Validate;

/**
 * 图灵API v2.0 地点信息参数.
 * 
 * @author zengguang
 *
 */
public class Location {

    /**
     * 所在城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 街道
     */
    private String street;

    /**
     * 地理信息构造函数.
     * 
     * @param city
     */
    public Location(String city) {
        Validate.notEmpty(city);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Location [city=" + city + ", province=" + province + ", street=" + street + "]";
    }

}
