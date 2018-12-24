package com.timber.timberyard.auth.exporter.api;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timber.timberyard.auth.exporter.model.ExporterResponse;
import com.timber.timberyard.auth.exporter.service.ExporterService;
import com.timber.timberyard.auth.model.DefaultToApiJsonSerializer;
import com.timber.timberyard.auth.model.Exporter;
import com.timber.timberyard.auth.model.Office;
import com.timber.timberyard.auth.model.User;

@RestController
public class ExporterController {
	
	@Autowired
	private ExporterService exporterService;

	@Autowired
    private DefaultToApiJsonSerializer<User> toApiJsonSerializer;

	
	@RequestMapping(value = "/exporter/registration", method = RequestMethod.POST)
    public String registration(@RequestBody Exporter exporterForm, BindingResult bindingResult, Model model) {

		Exporter exporter = exporterService.saveExporter(exporterForm);
		ExporterResponse response = new ExporterResponse(exporter.getId(),exporter.getExporterName(),exporter.getExporterAddress());
		        return this.toApiJsonSerializer.serialize(response);
    }
	
	   @RequestMapping(value = "/exporter/export", method = RequestMethod.GET)
	    public String getOffice(@QueryParam("exporterId") final Long exporterId) {

	    	Optional<Exporter> exporter = exporterService.getExporter(exporterId);
	        return this.toApiJsonSerializer.serialize(exporter);
	    }
}
