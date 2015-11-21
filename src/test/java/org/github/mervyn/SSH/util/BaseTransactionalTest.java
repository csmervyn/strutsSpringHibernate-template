package org.github.mervyn.SSH.util;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: BaseTest
 * @Description: 测试类的基类(支持事物)
 * @author: Mervyn
 * @Time: 2015年11月19日 上午11:28:28
 */
/*  声明用的是Spring的测试类  */
@RunWith(SpringJUnit4ClassRunner.class)
/* 声明spring主配置文件位置，注意：以当前测试类的位置为基准,有多个配置文件以字符数组声明  */
@ContextConfiguration(locations="classpath:applicationContext.xml")
/* 声明使用事务，不声明spring会使用默认事务管理 */
@Transactional(transactionManager="transactionManager")
/* 默认自动回滚 */
@Rollback(true)
public class BaseTransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {
	/**
	 * @Filed logger : 日志输出类的对象
	 */
	protected Logger logger  = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @Title: getBean
	 * @Description: 通过Bean的Class的类型获得该Class对应的Bean
	 * @param: @param type
	 * @param: @return
	 * @return: T
	 * @throws:
	 */
	public <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}

	/**
	 * @Title: getBean
	 * @Description: 通过bean的name获得bean
	 * @param: @param beanName
	 * @param: @return
	 * @return: Object
	 * @throws:
	 */
	public Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * @Title: getContext
	 * @Description: 获得spring的applicationContext
	 * @param: @return
	 * @return: ApplicationContext
	 * @throws:
	 */
	protected ApplicationContext getContext() {
		return applicationContext;
	}
}
