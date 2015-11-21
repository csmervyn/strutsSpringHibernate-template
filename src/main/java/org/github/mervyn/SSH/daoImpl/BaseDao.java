package org.github.mervyn.SSH.daoImpl;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;





import org.github.mervyn.SSH.dao.IBaseDao;
import org.github.mervyn.SSH.domain.Page;
import org.github.mervyn.SSH.domain.PageRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

/**
 * @ClassName: BaseDao
 * @Description: Dao层的基类
 * @author: Mervyn
 * @Time: 2015年11月19日 上午8:51:24
 *  @param <T>
 *  @param <ID>
 */
public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {
	/**
	 * @Filed entityClass : 泛型反射类
	 */
	private Class<T> entityClass;
	
	/**
	 * @Filed sessionFactory : hibernate的sessionFactory
	 */
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * @Filed logger : 日志输出类的对象
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * <p>Title: </p>
	 * <p>Description: 通过反射获取子类确定的泛型类</p>
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type genericType = this.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
	}
	

	/**
	 * @Title: getSession
	 * @Description: 获取和当前线程绑定的Session
	 * @param: @return
	 * @return: Session
	 * @throws:
	 */
	public Session getSession(){
		//需要开启事物，才能得到CurrentSession
		return sessionFactory.getCurrentSession();
	}
	
	
	
	
	

	/*
	 *(非 Javadoc) 
	 * <p>Title: save</p> 
	 * <p>Description: 保存entity对象</p> 
	 * @param entity 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#save(java.lang.Object) 
	 */
	public void save(T entity) {
		Assert.notNull(entity, "entity'保存'时不能为null!");
		this.getSession().save(entity);
		logger.debug("save entity: {}", entity);
		
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: update</p> 
	 * <p>Description: 更新entity对象</p> 
	 * @param entity 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#update(java.lang.Object) 
	 */
	public void update(T entity) {
		Assert.notNull(entity, "entity'更新'时不能为null!");
		this.getSession().update(entity);
		logger.debug("update entity: {}", entity);
		
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: delete</p> 
	 * <p>Description: 根据entity删除该entity,entity对象必须是session中的对象或含id属性的transient对象.</p> 
	 * @param entity 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#delete(java.lang.Object) 
	 */
	public void delete(T entity) {
		Assert.notNull(entity, "entity'删除'时不能为null!");
		this.getSession().delete(entity);
		logger.debug("delete entity: {}", entity);
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: deleteById</p> 
	 * <p>Description: 通过id删除entity</p> 
	 * @param id 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#deleteById(java.io.Serializable) 
	 */
	public void deleteById(ID id) {
		Assert.notNull(id, "通过id删除entity时，id不能null!");
		this.delete(findById(id));
		logger.debug("delete entity: {},id is {}", entityClass.getSimpleName(),id);
		
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: deleteAll</p> 
	 * <p>Description: 删除entity的list集合entities</p> 
	 * @param entities 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#deleteAll(java.util.Collection) 
	 */
	public void deleteAll(Collection<T> entities) {
		Assert.notNull(entities, "删除entity的list集合entities时，entities不能为null!");
		for(T entity: entities){
			this.delete(entity);
		}
		logger.debug("delete entities: {}",entities);
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: findById</p> 
	 * <p>Description: 通过id查找entity</p> 
	 * @param id
	 * @return 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#findById(java.io.Serializable) 
	 */
	public T findById(ID id) {
		Assert.notNull(id, "通过id查找entity时，id不能为null!");
		//get采用的是立即检索方式
		return (T)this.getSession().get(entityClass, id);
		
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: contains</p> 
	 * <p>Description: 通过entity判断数据库中是否存在该entity</p> 
	 * @param entity
	 * @return 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#contains(java.lang.Object) 
	 */
	public boolean contains(T entity) {
		Assert.notNull(entity, "通过entity判断数据库中是否存在该entity时，entity不能为null!");
		return this.getSession().contains(entity);
	}

	
	/*
	 *(非 Javadoc) 
	 * <p>Title: findByHQL</p> 
	 * <p>Description: 根据hqlString语句和values参数（可选）查询唯一的entity对象</p> 
	 * @param hqlString
	 * @param values
	 * @return 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#findByHQL(java.lang.String, java.lang.Object[]) 
	 */
	@SuppressWarnings("unchecked")
	public T findByHQL(String hqlString, Object... values) {
		Assert.notNull(hqlString, "hqlSting不能为null!");
		Assert.hasText(hqlString,"hqlString不能为空！");
		Query query = this.getSession().createQuery(hqlString);
		if(values != null){
			for(int i= 0; i < values.length; i++){
				query.setParameter(i, values[i]);
			}
		}
		return (T)query.uniqueResult();
	}

	/*
	 *(非 Javadoc) 
	 * <p>Title: findListByHQL</p> 
	 * <p>Description: 根据hqlString语句和values参数（可选）查询entity组成的list</p> 
	 * @param hqlString
	 * @param values
	 * @return 
	 * @see org.github.mervyn.SSH.dao.IBaseDao#findListByHQL(java.lang.String, java.lang.Object[]) 
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListByHQL(String hqlString, Object... values) {
		Assert.notNull(hqlString, "hqlSting不能为null!");
		Assert.hasText(hqlString,"hqlString不能为空！");
		Query query = this.getSession().createQuery(hqlString);
		if(values != null){
			for(int i= 0; i < values.length; i++){
				query.setParameter(i, values[i]);
			}
		}
		return (List<T>)query.list();
	}
}
