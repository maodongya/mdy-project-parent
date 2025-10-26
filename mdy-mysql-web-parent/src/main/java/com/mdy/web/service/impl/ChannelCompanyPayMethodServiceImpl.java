package com.mdy.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mdy.web.persistence.dao.ChannelCompanyPayMethodDao;
import com.mdy.web.persistence.entity.ChannelCompanyPayMethodEntity;
import com.mdy.web.service.inter.ChannelCompanyPayMethodService;
import com.mdy.web.uitl.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("channelCompanyPayMethodService")
public class ChannelCompanyPayMethodServiceImpl extends ServiceImpl<ChannelCompanyPayMethodDao, ChannelCompanyPayMethodEntity> implements ChannelCompanyPayMethodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        PageUtils.Query<ChannelCompanyPayMethodEntity> query=new PageUtils.Query(params);

        IPage<ChannelCompanyPayMethodEntity> page = this.page(
                query.toPageDTO(),
                query.toQueryWrapper(ChannelCompanyPayMethodEntity.class)
        );

        return new PageUtils(page);
    }

}