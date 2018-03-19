#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import jsyf.oa.idao.BaseDao;
import jsyf.oa.ientity.IBaseEntity;

#parse("File Header.java")
@Repository
public class ${NAME}Dao extends BaseDao {

    public ${NAME}Dao() {
        super.iBaseEntity = new ${NAME}Entity();
    }

    public List<${NAME}Entity> getEntityListByCondition(String condition, Object[] params) {
        List<JSONObject> jsonList = getJSONListByCondition(condition, params);
        List<${NAME}Entity> entityList = new ArrayList<>();
        for (int i = 0; i < jsonList.size(); i++) {
            ${NAME}Entity entity = (${NAME}Entity) convertJson2Entity(jsonList.get(i));
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public IBaseEntity convertJson2Entity(JSONObject json) {
        return JSON.toJavaObject(json, ${NAME}Entity.class);
    }
}

