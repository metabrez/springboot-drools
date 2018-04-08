package com.example.service;

import com.example.model.ApproveUser;
import com.example.model.Conditions;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {
private static final Logger LOG = LoggerFactory.getLogger(RuleService.class);

    private final KieContainer container;

    @Autowired
    public RuleService (KieContainer container){
        this.container = container;
    }

    //场景一：匹配规则执行
    public Conditions getCon(Conditions conditions){
        //4000人每人匹配60条规则
       for (int i = 0 ; i < 4000 ; i++){
           //获取session会话
           KieSession session = container.newKieSession("conditions-rules");
           session.insert(conditions);
           int count = session.fireAllRules();
           session.dispose();
           LOG.info("执行了 " + count + " 条规则！");
       }
        return conditions;
    }

    //场景二：匹配规则执行
    public ApproveUser getUser(ApproveUser user){
        KieSession session = container.newKieSession("conditions-rules");
        session.insert(user);
        int count = session.fireAllRules();
        session.dispose();
        LOG.info("执行了 " + count + " 条规则！");
        return  user;
    }

}
