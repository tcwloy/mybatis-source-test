package com.github.tcwloy.mybatis.resource;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ResourceTest {
    @Test
    public void testGetResources() throws IOException {
        Enumeration<URL> mapper = this.getClass().getClassLoader().getResources("com");
        while (mapper.hasMoreElements()){
            URL url = mapper.nextElement();
            System.out.println(url.getPath());
        }
    }
}
