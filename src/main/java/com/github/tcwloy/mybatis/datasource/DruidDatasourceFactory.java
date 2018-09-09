package com.github.tcwloy.mybatis.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class DruidDatasourceFactory extends UnpooledDataSourceFactory {

    public DruidDatasourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
