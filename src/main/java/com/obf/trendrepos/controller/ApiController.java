package com.obf.trendrepos.controller;

import com.obf.trendrepos.services.TrendReposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trendRepos")
public class ApiController {

    @Autowired
    private TrendReposService trendReposService;

    @GetMapping("")
    public String getTrendLang(){

        return trendReposService.reposToString(trendReposService.getReposFromGithubApi());
    }
}