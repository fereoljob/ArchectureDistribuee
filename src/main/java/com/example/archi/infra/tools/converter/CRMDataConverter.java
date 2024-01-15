package com.example.archi.infra.tools.converter;


import org.springframework.stereotype.Component;

import com.example.archi.domain.ModelTO;
@Component
public interface CRMDataConverter<T> {
	public ModelTO convertDatas(T dataType);
}
