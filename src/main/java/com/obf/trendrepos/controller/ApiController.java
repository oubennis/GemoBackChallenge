package com.obf.trendrepos.controller;

import com.obf.trendrepos.services.TrendReposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trendReposLang")
public class ApiController {

    @Autowired
    private TrendReposService trendReposService;

    @GetMapping("")
    public String getTrendLang(){

        return trendReposService.getTrendReposLangs().toString();
    }

    @RequestMapping(value = "count/{language}", method = RequestMethod.GET)
    public String getReposTrendCountByLang(@PathVariable("language") String language){

        long count = trendReposService.getReposTrendCountByLang(language);

        return "Number of trending repos using "+language +" = "+ count;
    }

    @RequestMapping(value = "listRepos/{language}", method = RequestMethod.GET)
    public String getReposTrendListByLang(@PathVariable("language") String language){

        return trendReposService.reposToString(trendReposService.getReposTrendListByLang(language));
    }

}
