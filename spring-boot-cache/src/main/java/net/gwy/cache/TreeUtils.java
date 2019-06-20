package net.gwy.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guoweiyang
 * @date 2019-05-10
 */
public class TreeUtils {

    public static<E extends TreeEntity<E>> List<E> getTreeList(String topId,List<E> entityList){
        List<E> result = new ArrayList<>();
        String parentId;
        for (E entity:entityList){
            parentId = entity.getParentId();
            if(parentId==null||topId==null||"".equals(topId)||topId.equals(parentId)){
                result.add(entity);
            }
        }

        for (E entity:result){
            entity.setChildList(getSubList(entity.getId(),entityList));
        }

        return result;
    }

    private static<E extends TreeEntity<E>> List<E> getSubList(String id, List<E> entityList) {
        List<E> childList = new ArrayList<>();
        for (E entity:entityList){
            if (id!=null && id.equals(entity.getParentId())){
                childList.add(entity);
            }
        }

        for (E entity:childList){
            entity.setChildList(getSubList(entity.getId(),entityList));
        }

        if (childList.size()==0){
            return null;
        }

        return childList;
    }
}
