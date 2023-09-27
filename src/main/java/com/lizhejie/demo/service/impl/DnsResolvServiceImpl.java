package com.lizhejie.demo.service.impl;

import com.lizhejie.demo.model.vo.ResolvDomainVo;
import com.lizhejie.demo.service.DnsResolvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.xbill.DNS.*;

/**
 * TODO 暂时无法递归调用解析CNAME，只能解析一级CNAME，可优化
 * TODO 可以增加查询类型
 */
@Slf4j
@Service
public class DnsResolvServiceImpl implements DnsResolvService {
    @Override
    public List<ResolvDomainVo> resolv(String domain) {
        ArrayList<ResolvDomainVo> resolvDomainList =new ArrayList<>();
        ResolvDomainVo resolvDomainVo = new ResolvDomainVo();
        ArrayList<String> cnamesList=new ArrayList<>();
        ArrayList<String> ipsList=new ArrayList<>();
        try {
            Record[] cname_records = new Lookup(domain, Type.CNAME).run();
            Record[] ip_records = new Lookup(domain, Type.A).run();
            resolvDomainVo.setDomain(domain);
            if (cname_records != null) {
                for (Record record : cname_records) {
                    if (record instanceof CNAMERecord) {
                        CNAMERecord cnameRecord = (CNAMERecord) record;
                        cnamesList.add(cnameRecord.getTarget().toString());
                    }
                }
            }
            if (ip_records != null) {
                for (Record record : ip_records) {
                    if (record instanceof ARecord) {
                        ARecord ipRecord = (ARecord) record;
                        ipsList.add(ipRecord.getAddress().getHostAddress());
                    }
                }
            } else {
                log.error("输入的域名解析无A，CNAME记录");
                return resolvDomainList;
            }
            resolvDomainVo.setCnames(cnamesList);
            resolvDomainVo.setIps(ipsList);
            resolvDomainList.add(resolvDomainVo);
            return resolvDomainList;
        }
        catch (TextParseException e) {
            e.printStackTrace();
            return resolvDomainList;
        }
    }

}
