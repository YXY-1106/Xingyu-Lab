package com.yangxingyu.xingyulab.lab.shortlink.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.lab.shortlink.entity.ShortLink;
import com.yangxingyu.xingyulab.lab.shortlink.mapper.ShortLinkMapper;
import com.yangxingyu.xingyulab.lab.shortlink.service.ShortLinkService;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLink> implements ShortLinkService {

    @Override
    public String createShortLink(String originalUrl) {
        String shortCode = IdUtil.nanoId(6);
        ShortLink link = new ShortLink();
        link.setShortCode(shortCode);
        link.setOriginalUrl(originalUrl);
        link.setClickCount(0);
        link.setStatus(0);
        this.save(link);
        return shortCode;
    }

    @Override
    public String resolve(String shortCode) {
        ShortLink link = this.getOne(new LambdaQueryWrapper<ShortLink>()
                .eq(ShortLink::getShortCode, shortCode)
                .eq(ShortLink::getStatus, 0));
        if (link == null) {
            return null;
        }
        link.setClickCount(link.getClickCount() + 1);
        this.updateById(link);
        return link.getOriginalUrl();
    }
}
