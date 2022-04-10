package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.PreExaminationObligations;
import ftn.uns.eObrazovanje.repository.PreExaminationObligationsRepo;
import ftn.uns.eObrazovanje.service.PreExaminationObligationService;

@Service
public class PreExaminationObligationServiceImpl implements PreExaminationObligationService{

	@Autowired
	private PreExaminationObligationsRepo examinationObligationRepo;
	
	@Override
	public List<PreExaminationObligations> findAll() {
		return examinationObligationRepo.findAll();
	}

	@Override
	public PreExaminationObligations save(PreExaminationObligations preExaminationObligations) {
		examinationObligationRepo.save(preExaminationObligations);
		return preExaminationObligations;
		
	}

	@Override
	public PreExaminationObligations findOne(Integer id) {
		return examinationObligationRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		examinationObligationRepo.deleteById(id);
	}

}
