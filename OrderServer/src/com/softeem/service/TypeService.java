package com.softeem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.bean.TypeBean;
import com.softeem.dao.TypeDao;

@Service(value="typeService")
public class TypeService {
	@Resource(name = "typeDao")
	private TypeDao typeDao;
	
	
	public List<TypeBean> listAllType(){
		return typeDao.selectAllType();
	}
	
	public TypeBean getTypeById(int typeId)
	{
		return typeDao.selectById(typeId);
	}

	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
	
}
