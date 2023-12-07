package com.example.archi.archi.tools;


import org.springframework.stereotype.Component;

import com.example.archi.archi.model.standard.ModelTO;
@Component
public interface CRMDataConverter<T> {
	public ModelTO convertDatas(T dataType);
}
