#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
#parse("File Header.java")
@Api(value = "${Interface_Description}接口", description = "${Interface_Description}接口")
@Controller
@RequestMapping("/${NAME.replace("Controller","").toLowerCase()}")
public class ${NAME}Controller {
    @Resource
    private ${NAME}Facade ${NAME.toLowerCase()}Facade;
}
