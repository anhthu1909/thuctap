//package com.springmvcproject.dao.impl;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.springmvcproject.dao.INewDAO;
//import com.springmvcproject.mapper.NewMapper;
//import com.springmvcproject.model.NewModel;
//
//@Repository
//public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
//
//	@Override
//	public List<NewModel> findAll() {
//		StringBuilder sql = new StringBuilder("SELECT * FROM news");
//		return query(sql.toString(), new NewMapper());
//	}
//}
