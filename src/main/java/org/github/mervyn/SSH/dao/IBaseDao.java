package org.github.mervyn.SSH.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.github.mervyn.SSH.domain.Page;
import org.github.mervyn.SSH.domain.PageRequest;

/**
 * @ClassName: IBaseDao
 * @Description: BaseDao封装接口
 * @author: Mervyn
 * @Time: 2015年11月18日 下午7:49:25
 * @param <T>: Dao访问的entity实体类
 * @param <ID>: Dao访问的entity实体类的主键类
 */
public interface IBaseDao<T,ID extends Serializable> {
	/**
	 * @Title: save
	 * @Description: 保存实体
	 * @param: @param entity
	 * @return: void
	 * @throws:
	 */
	void save(T entity);
	
	/**
	 * @Title: update
	 * @Description: 更新entity
	 * @param: @param entity
	 * @return: void
	 * @throws:
	 */
	void update(T entity);
	
	/**
	 * @Title: delete
	 * @Description: 删除该entity
	 * @param: @param entity
	 * @return: void
	 * @throws:
	 */
	void delete(T entity);
	
	/**
	 * @Title: deleteById
	 * @Description: 根据entity的id删除该entity
	 * @param: @param id
	 * @return: void
	 * @throws:
	 */
	void deleteById(ID id);
	
	/**
	 * @Title: deleteAll
	 * @Description: 删除entities集合中的所有entity
	 * @param: @param entities
	 * @return: void
	 * @throws:
	 */
	void deleteAll(Collection<T> entities);
	
	/**
	 * @Title: findById
	 * @Description: 根据entity的id获得该id对应的entity
	 * @param: @param id
	 * @param: @return
	 * @return: T
	 * @throws:
	 */
	T findById(ID id);
	
	/**
	 * @Title: contains
	 * @Description: 数据库中是否存在该entity
	 * @param: @param entity
	 * @param: @return
	 * @return: boolean
	 * @throws:
	 */
	boolean contains(T entity);
	
	/**
	 * @Title: findByHQL
	 * @Description: 根据hqlStirng获得T类型唯一的entity
	 * @param: @param hqlString
	 * @param: @param values
	 * @param: @return
	 * @return: T
	 * @throws:
	 */
	T findByHQL(String hqlString, Object... values);
	
	/**
	 * @Title: findListByHQL
	 * @Description: 根据hqlString获得T类型的entity组成的List
	 * @param: @param hqlString
	 * @param: @param values
	 * @param: @return
	 * @return: List<T>
	 * @throws:
	 */
	List<T> findListByHQL(String hqlString, Object... values);
}
