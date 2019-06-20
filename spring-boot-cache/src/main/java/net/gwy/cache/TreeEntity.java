package net.gwy.cache;

import java.util.List;

/**
 * @author guoweiyang
 * @date 2019-05-10
 */
public interface TreeEntity<E> {

    public String getId();
    public String getParentId();
    public void setChildList(List<E> childList);
}
