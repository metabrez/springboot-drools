package com.example.service;

import com.example.utils.KieUtils;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


@Component
public class ReloadDroolsRules {
    private static final Logger LOG = LoggerFactory.getLogger(ReloadDroolsRules.class);
    public void reload() throws UnsupportedEncodingException {
        KieServices kieServices = getKieServices();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write("src/main/resources/rules/temp.drl", loadRules());
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            LOG.info("message:"+results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        KieUtils.setKieContainer(kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId()));
        LOG.info("reload新规则重载成功");
    }

    private String loadRules() {
        // 字符串加载规则
        return "package plausibcheck.adress\n\n rule \"Postcode 6 numbers\"\n\n    when\n  then\n   " +
                "System.out.println(\"规则2中打印日志：校验通过!\");\n end";
    }

    private String loadDB(){
        //数据库加载规则文件
        //TO-DO
        return "";
    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }
    public void reloadByHelper() throws UnsupportedEncodingException {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(loadRules(), ResourceType.DRL);
        Results results = kieHelper.verify();
        if (results.hasMessages(Message.Level.ERROR)) {
            System.out.println(results.getMessages());
            throw new IllegalStateException("### errors ###");
        }
        //KieBase kieBase = kieHelper.build();
        KieContainer kieContainer = kieHelper.getKieContainer();
        KieUtils.setKieContainer(kieContainer);
        LOG.info("新规则重载成功");
    }

}
