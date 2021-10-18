package com.whynotyue.community;

import com.whynotyue.community.dao.AlphaDao;
import com.whynotyue.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.whynotyue.community.util.CommunityConstant.DEFAULT_EXPIRED_SECONDS;
import static com.whynotyue.community.util.CommunityConstant.REMEMBER_EXPIRED_SECONDS;

@SpringBootTest
// 使用 CommunityApplication 做配置类
@ContextConfiguration(classes = CommunityApplication.class)
// 获取 Spring 容器，需要实现 ApplicationContextAware，重写 setApplicationContext()
class CommunityApplicationTests implements ApplicationContextAware {

    // 定义 Spring 容器
    private ApplicationContext applicationContext;

    // 获取 Spring 容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {

        // 1. 获取自定义的 bean
        // AlphaDao 接口及其实现类被 @Repository 注解
        // 当有多个实现类时，可以用 @Primary 注解该实现类，表示优先调用
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        // 2. 指定使用哪个 bean
        // @Repository("name")：给 bean 取名字
        alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);
        System.out.println(alphaDao.select());
    }

    @Test
    public void testBeanManager() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    @Qualifier("alphaHibernate")
    private AlphaDao alphaDao;

    @Test
    public void testDI() {
        System.out.println(alphaDao);
    }

    @Test
    public void testExpiredSeconds() {
        boolean rememberme = true;
        int expiredSeconds = rememberme ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(new Date(System.currentTimeMillis() + DEFAULT_EXPIRED_SECONDS * 1000)));
        System.out.println(sf.format(new Date(System.currentTimeMillis() + expiredSeconds * 1000)));
    }

}
