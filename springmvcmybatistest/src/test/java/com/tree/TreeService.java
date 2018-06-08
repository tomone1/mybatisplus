package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-05-07 17:55
 */

public class TreeService {
  public static List<Map<String,Object>> getChildList(List<MenuTree> list, int pId, List<Map<String,Object>> reList) {
    for (MenuTree testEntity : list) {
      if (testEntity.getPId() == pId) {//查询下级菜单
        Map<String,Object> map=new HashMap<>();
        map.put("id",testEntity.getId());
        map.put("name",testEntity.getName());
        map.put("pid",testEntity.getPId());

        if (ifChilds(list, testEntity.getId())) {
          List<Map<String,Object>> childlist=new ArrayList<>();
          childlist= getChildList(list, testEntity.getId(), childlist);
          map.put("children",childlist);
        }
        reList.add(map);
      }
    }
    return reList;
  }
  public static boolean ifChilds(List<MenuTree> list,int pId) {
    boolean flag = false;
    for (MenuTree testEntity : list) {
      //times++;
      if (testEntity.getPId()==pId) {
        flag=true;
        break;
      }
    }
    return flag;
  }


  /*data3: [{
    id: 1,
        label: '一级 2',
        children: [{
      id: 3,
          label: '二级 2-1',
          children: [{
        id: 4,
            label: '三级 3-1-1'
      }, {
        id: 5,
            label: '三级 3-1-2',
            disabled: true
      }]
    }, {
      id: 2,
          label: '二级 2-2',
          disabled: true,
          children: [{
        id: 6,
            label: '三级 3-2-1'
      }, {
        id: 7,
            label: '三级 3-2-2',
            disabled: true
      }]
    }]
  }],
  defaultProps: {
    children: 'children',
        label: 'label'
  }
};*/
}
