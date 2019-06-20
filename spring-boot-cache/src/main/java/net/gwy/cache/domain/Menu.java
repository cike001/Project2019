package net.gwy.cache.domain;

import lombok.Data;
import net.gwy.cache.TreeEntity;

import java.util.List;

/**
 * @author guoweiyang
 * @date 2019-05-09
 */
@Data
public class Menu implements TreeEntity<Menu> {

    public String id;
    public String name;
    public String parentId;
    public List<Menu> childList;
}
