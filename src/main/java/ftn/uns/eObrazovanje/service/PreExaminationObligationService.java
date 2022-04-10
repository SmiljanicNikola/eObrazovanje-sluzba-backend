package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.PreExaminationObligations;

public interface PreExaminationObligationService {
	
	List<PreExaminationObligations> findAll();
	
	PreExaminationObligations save(PreExaminationObligations preExaminationObligations);
	
	PreExaminationObligations findOne(Integer id);
	
	void remove(Integer id);

}
