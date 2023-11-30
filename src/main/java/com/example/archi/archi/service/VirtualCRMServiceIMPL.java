package com.example.archi.archi.service;

import java.io.IOException;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.example.archi.archi.model.apache.VirtualLeadDTO;

@Service
public class VirtualCRMServiceIMPL implements VirtualCRMService.Iface{	
	
	private VirtualMapper _virtualMapper;
	public VirtualCRMServiceIMPL() throws IOException{
		this._virtualMapper = new VirtualMapper();
	}
	
	@Override
	public List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue) {
		// TODO Auto-generated method stub
		try {
			return _virtualMapper.convertFromSalesforce();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
