package com.example.domain;

import com.example.model.ApproveUser;
import com.example.model.Conditions;
import com.example.model.Results;
import com.example.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    private final RuleService service;

    //不影响运行，去红线：setting->Editor->inspections->Autowiring for bean Class  勾去掉即可
    @Autowired
    public RuleController(RuleService service) {
        this.service = service;
    }

    //场景1测试
    @RequestMapping(value = "/sceneOne", method = RequestMethod.GET, produces = "application/json")
    public Conditions getRules(@RequestParam(required = false) String app,
                               @RequestParam(required = false) String client,
                               @RequestParam(required = false) String ip) {
        Conditions conditions = new Conditions();
        conditions.setApp(app);
        conditions.setClient(client);
        conditions.setIp(ip);
        service.getCon(conditions);
        return conditions;
    }

    //测试60条规则性能
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public Conditions gettest(@RequestParam(required = false) String app,
                              @RequestParam(required = false) String client,
                              @RequestParam(required = false) String ip) {
        Conditions conditions = new Conditions();
        conditions.setApp(app);
        conditions.setClient(client);
        conditions.setIp(ip);
        service.getCon(conditions);
        return conditions;
    }

    //场景2测试
    @RequestMapping(value = "/sceneTwo", method = RequestMethod.GET, produces = "application/json")
    public ApproveUser getResults(@RequestParam(required = false) String user,
                                  @RequestParam(required = false) String finger,
                                  @RequestParam(required = false) String face,
                                  @RequestParam(required = false) String userName,
                                  @RequestParam(required = false) String password) {
        ApproveUser user1 = new ApproveUser();
        user1.setUser(user);
        user1.setFinger(finger);
        user1.setFace(face);
        user1.setUserName(userName);
        user1.setPassword(password);
        service.getUser(user1);
        return user1;
    }


}
