package com.example.archi.infra.tools.converter;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.archi.domain.ModelTO;
import com.example.archi.infra.tools.thriftService.InternalLeadDto;
@Component("internalConverter")
public class InternalCRMDataConverter implements CRMDataConverter<InternalLeadDto> {

    @Override
    public ModelTO convertDatas(InternalLeadDto dataType) {
        String[] tab = dataType.getName().split(",");
        ModelTO model = new ModelTO(tab[0],tab[1],dataType.getAnnualRevenue(), dataType.getPhone(), dataType.getStreet(), dataType.getPostalCode(),
          dataType.getCity(), dataType.getCountry(), dataType.getCompany(), LocalDateTime.parse(dataType.getCreationDate()), dataType.getState());
        return model;
    }
    
}
