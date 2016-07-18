package com.yue.${pkg}.service;

import com.yue.${pkg}.bean.*;
import com.yue.${pkg}.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


//Spring Bean的标识.
@Service("${bean}Service")
//类中所有public函数都纳入事务管理的标识.
public class ${Bean}Service {
	@Autowired
	private ${Bean}Repository ${bean}Repository;

	///////////////////////////////////保存用户信息///////////////////////////////////////////////////////

	public ${Bean} find${Bean}ById(long id){
		return this.${bean}Repository.findById(id);
    }

	/**
	 * 保存
	 * @param ${bean}
	 */
	public ${Bean} save${Bean}(${Bean} ${bean}){
		return ${bean}Repository.save(${bean});
	}


	/**
	*删除
    * @param ${bean}
	*/
	public void delete${Bean}(${Bean} ${bean}){
			${bean}Repository.delete( ${bean});
	}



	/**
	 * 动态分页查询
	 * @param ${bean}
	 * @param pageable
	 */
	public Page<${Bean}> findAllDynatic(final ${Bean} ${bean},Pageable pageable){

		 return ${bean}Repository.findAll(new Specification<${Bean}>() {
			public Predicate toPredicate(Root<${Bean}> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
	};

}
