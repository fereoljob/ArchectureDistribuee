package com.example.archi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class VirtualCRMServiceIMPL implements  VirtualCRMService{	
	
	private List<CRMClient> listClients;
	private GeoLocalisationClient geoClient;
	public VirtualCRMServiceIMPL(List<CRMClient> listCli,GeoLocalisationClient geoCli) throws IOException{
		listClients = listCli;
		geoClient = geoCli;
	}
	
	@Override
	public List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue,String state) {
		List<VirtualLeadDTO> listClientDto = new ArrayList<>();
		for(CRMClient c : listClients){
			(c.findLeads(lowAnnualRevenue, highAnnualRevenue, state)).forEach( elem -> {listClientDto.add(VirtualMapper.fromModelToVirtual(elem));});

		}
		for(VirtualLeadDTO cli : listClientDto) {
			String address = cli.getStreet() + " " + cli.getCity() + " " + cli.getCountry() + " " 
							+ cli.getPostalCode();
			cli.setGeo( geoClient.extractLongAndLat(address));
			
		}
	    Collections.sort(listClientDto, (dto1, dto2) -> Double.compare(dto2.getAnnualRevenue(),
	    																dto1.getAnnualRevenue()));

		return listClientDto;
	}

	@Override
	public List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		List<VirtualLeadDTO> listClientDto = new ArrayList<>();
		for(CRMClient c : listClients){
			(c.findLeadsByDate(startDate, endDate)).forEach( elem -> {listClientDto.add(VirtualMapper.fromModelToVirtual(elem));});

		}
		for(VirtualLeadDTO cli : listClientDto) {
			String address = cli.getStreet() + " " + cli.getCity() + " " + cli.getCountry();
			cli.setGeo( geoClient.extractLongAndLat(address));
			
		}

		return listClientDto;
	}

}
