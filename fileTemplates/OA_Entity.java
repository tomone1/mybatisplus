#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.alibaba.fastjson.JSONObject;

import javax.persistence.Entity;
import javax.persistence.Table;
import jsyf.oa.ientity.BaseEntity;
#parse("File Header.java")
@Entity
@Table(name = "${SQL_Table_Name}", schema = "oa", catalog = "")
public class ${NAME}Entity extends BaseEntity {
    @Override
    public JSONObject getJSONObject() {
        return null;
    }

    @Override
    public String getTableName() {
        return "${SQL_Table_Name}";
    }

    @Override
    public JSONObject getJSONColumns() {
        return null;
    }
    
}
