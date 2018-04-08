package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpHelper {
    private static final Logger LOG = LoggerFactory.getLogger(IpHelper.class);

    /**
     * 判断IP是否在允许IP范围内
     * @param ip     测试IP
     * @param ipSection  允许IP范围
     * @return
     */
    public static boolean ipExistsInRange(String ip,String ipSection) {
        ipSection = ipSection.trim();
        LOG.info("设定IP地址范围："+ipSection);
        ip = ip.trim();
        LOG.info("测试IP地址："+ip);
        int idx = ipSection.indexOf('-');
        String beginIP = ipSection.substring(0, idx);
        String endIP = ipSection.substring(idx + 1);
        return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);
    }

    public static long getIp2long(String ip) {
        ip = ip.trim();
        String[] ips = ip.split("\\.");
        long ip2long = 0L;
        for (int i = 0; i < 4; ++i) {
            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);
        }
        return ip2long;
    }

    /**
     * 测试使用确定IP范围
     * @param ip
     * @return
     */
    public static boolean ipExistsInRangeTest(String ip) {
        String ipSection = "192.168.1.00-192.168.1.255";
        ipSection = ipSection.trim();
        if (ip == null){
            ip = "127.0.0.1";
        }else{
            ip = ip.trim();
        }
        int idx = ipSection.indexOf('-');
        String beginIP = ipSection.substring(0, idx);
        String endIP = ipSection.substring(idx + 1);
        return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);
    }
}
