package net.gwy.cache;

import net.gwy.cache.domain.Menu;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringBootCacheApplicationTests {

    public static void main(String[] args){
        List<Menu> list=new ArrayList<>();
        Menu menu1=new Menu();
        menu1.setId("1");
        menu1.setParentId("0");
        menu1.setName("菜单1");
        list.add(menu1);

        Menu menu2=new Menu();
        menu2.setId("2");
        menu2.setParentId("0");
        menu2.setName("菜单2");
        list.add(menu2);

        Menu menu3=new Menu();
        menu3.setId("3");
        menu3.setParentId("1");
        menu3.setName("菜单11");
        list.add(menu3);

        Menu menu4=new Menu();
        menu4.setId("4");
        menu4.setParentId("3");
        menu4.setName("菜单111");
        list.add(menu4);

//        List<Menu> menuList = getParent(menu4, list);
//        System.out.println(menuList);
        List<Menu> treeList = TreeUtils.getTreeList("", list);
        System.out.println(treeList);

    }

    public static List<Menu> getParent(Menu menu,List<Menu> list){
        List<Menu> res = new ArrayList<>();
        res.add(menu);
        getPar(list,menu.getParentId(),res);
        return res;
    }

    public static void getPar(List<Menu> list,String parentId,List<Menu> res){
        for (Menu menu:list){
            if(menu!=null && menu.getId().equals(parentId)){
                res.add(menu);
                if(!parentId.equals("0")){
                    getPar(list,menu.getParentId(),res);
                }
            }

        }
    }


}
