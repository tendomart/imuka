package com.imuka.imuka.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imuka.imuka.model.FundingOpportunities;

@Controller
@RequestMapping("funds")
public class FundingOpportunitiesController extends BaseController<FundingOpportunities>{
	private static final Logger log = LogManager.getLogger("com.imuka.farm.controller.FundingOpportunitiesController");

	
}