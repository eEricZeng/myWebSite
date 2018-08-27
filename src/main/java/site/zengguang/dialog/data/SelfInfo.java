package site.zengguang.dialog.data;

/**
 * 图灵API v2.0 客户端属性
 * @author zengguang
 *
 */
public class SelfInfo {

    // 地理位置信息
    Location location;

    /**
     * 客户端属性构造函数.
     * 
     * @param location 地理位置信息
     */
    public SelfInfo(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return location;
    }

}
