package com.ctrends.taskmanager.dao.impedimentmanager;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.model.impedimentmanager.ImpedimentManager;

@Repository("impedimentManagerDao")
public class ImpedimentManagerDAO implements IImpedimentManagerDAO {

	@Override
	public List<ImpedimentManager> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImpedimentManager getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpedimentManager> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID insertDoc(ImpedimentManager doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID updateDoc(ImpedimentManager doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
