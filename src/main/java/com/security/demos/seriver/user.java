package com.security.demos.seriver;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.demos.dao.account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface user  extends BaseMapper<account> {

    @Select("  select  * from account")
List<account> selectList();

    @Select( "select * from account where  account=#{name}  ")
    account longin(String name);

}
