package com.github.tcwloy.mybatis.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class DruidDatasourceFactory extends UnpooledDataSourceFactory {

    public DruidDatasourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
