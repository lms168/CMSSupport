package com.yue.test.service;

import com.yue.test.bean.*;
import com.yue.test.repository.*;
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
@Service("testService")
//类中所有public函数都纳入事务管理的标识.
public class TestService {
	@Autowired
	private TestRepository testRepository;

	///////////////////////////////////保存用户信息///////////////////////////////////////////////////////
	public Test findTestById(long id){
		return this.testRepository.findById(id);
    }

	/**
	 * 保存
	 * @param test
	 */
	public Test saveTest(Test test){
		return testRepository.save(test);
	}

	/**
	*删除
    * @param test
	*/
	public void deleteTest(Test test){
			testRepository.delete( test);
	}

	/**
	 * 动态分页查询
	 * @param test
	 * @param pageable
	 */
	public Page<Test> findAllDynatic(final Test test,Pageable pageable){

		 return testRepository.findAll(new Specification<Test>() {
			public Predicate toPredicate(Root<Test> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
	};

}
