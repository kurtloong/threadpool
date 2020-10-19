package com.example.threadpool;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TheadPoolDemoMapper extends BaseMapper<TheadPoolDemo> {

}
