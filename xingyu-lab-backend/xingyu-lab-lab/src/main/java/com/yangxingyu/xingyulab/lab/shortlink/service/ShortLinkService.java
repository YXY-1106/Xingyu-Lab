package com.yangxingyu.xingyulab.lab.shortlink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.lab.shortlink.entity.ShortLink;

public interface ShortLinkService extends IService<ShortLink> {
    String createShortLink(String originalUrl);
    String resolve(String shortCode);
}
