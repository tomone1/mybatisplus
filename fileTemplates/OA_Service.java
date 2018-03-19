#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

#parse("File Header.java")
@Service
@Transactional(rollbackFor = Exception.class)
@com.alibaba.dubbo.config.annotation.Service(protocol = {"dubbo"})
public class ${NAME}Service implements ${NAME}Facade {
    @Autowired
    private ${NAME}Dao ${NAME.toLowerCase()}Dao;

    @Override
    public String save(String jsonData) {
        ${NAME}Entity entity = JSON.toJavaObject(JSON.parseObject(jsonData), ${NAME}Entity.class);
        ${NAME.toLowerCase()}Dao.add(entity);
        return entity.getId();
    }
}
