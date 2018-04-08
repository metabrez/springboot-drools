package com.example.domain;

import com.example.model.Address;
import com.example.model.fact.AddressCheckResult;
import com.example.service.ReloadDroolsRules;
import com.example.utils.KieUtils;
import org.kie.api.runtime.KieSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@RequestMapping("/test")
@Controller
public class ReloadController {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ReloadController.class);
    @Resource
    private ReloadDroolsRules rules;

    @ResponseBody
    @RequestMapping("/address")
    public void test(){
        KieSession kieSession = KieUtils.getKieContainer().newKieSession();
        Address address = new Address();
        address.setPostcode("994251");
        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        LOG.info("触发了" + ruleFiredCount + "条规则");
        if(result.isPostCodeResult()){
            LOG.info("规则校验通过");
        }

        kieSession.dispose();
    }

    @ResponseBody
    @RequestMapping("/reload")
    public String reload() throws IOException {
        rules.reload();
        return "ok";
    }
}
