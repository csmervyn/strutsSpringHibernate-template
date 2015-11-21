package org.github.mervyn.SSH.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: User
 * @Description: 测试实体类User
 * @author: Mervyn
 * @Time: 2015年11月18日 下午2:19:32
 */
@Entity		//将一个类声明为一个实体bean
@Table(name="user")		//name -可选，表示表的名称，默认情况下，表名与实体名称一致，只有在不一致的情况下，需要指定表名
public class User implements Serializable{
	
	/**
	 * @Filed serialVersionUID : 用来标明当前class的版本号
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	
	@Id
	@GeneratedValue(generator = "userGenerator")    
	@GenericGenerator(name = "userGenerator", strategy = "native")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
