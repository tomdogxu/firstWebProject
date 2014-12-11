package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danga.MemCached.MemCachedClient;
import com.tomdogxu.model.UserBean;
import com.tomdogxu.util.MemcachedUtil;

public class MemcachedSpringTest {
 
    private MemCachedClient cachedClient;
	private ApplicationContext context;
     
   @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("beans.xml");
        cachedClient = (MemCachedClient)context.getBean("memcachedClient");
    }
     
    @Test
    public void testMemcachedSpring() {
        UserBean user = new UserBean("lou", "jason");
        cachedClient.set("user", user);
        UserBean cachedBean = (UserBean) cachedClient.get("user");
        System.out.println(cachedBean.getUsername());
        Assert.assertEquals(user, cachedBean);
        MemcachedUtil.put("1", "111");
        System.out.println(MemcachedUtil.get("1"));
    }
}