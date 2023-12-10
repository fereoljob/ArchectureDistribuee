package com.example.archi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.example.archi.infra.tools.CRMClient.CRMClient;
import com.example.archi.infra.tools.geoLocalisationClient.GeoLocalisationClient;

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
			String address = cli.getStreet() + " " + cli.getCity() + " " + cli.getCountry();
			VirtualMapper.searchForCoordinates(cli, geoClient.extractLongAndLat(address));
			
		}
		
		return listClientDto;
	}

	@Override
	public List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
