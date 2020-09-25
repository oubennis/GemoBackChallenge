package com.obf.trendrepos.services;

import com.obf.trendrepos.models.Item;
import com.obf.trendrepos.models.Items;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class TrendReposService {

    @Value("${trendReposApi.url}")
    private String trendReposUrl;

    @Value("${lastXDays}")
    private long lastXDays;

    RestTemplate restTemplate = new RestTemplate();

    public List<Item> getReposFromGithubApi(){

        LocalDate date = LocalDate.now().minusDays(lastXDays);
        Items response = restTemplate.getForObject(MessageFormat.format(trendReposUrl, date), Items.class);

        if (response != null)
            return response.getItems();

        return new ArrayList<>();
    }


    public String reposToString(List<Item> repos){
        if(repos.isEmpty())
            return "No repo found !";

        StringBuilder stringRepos = new StringBuilder();
        for(Item item : repos){
            stringRepos.append("<div> Repo Name : <span style=\"display: inline-block; min-width: 200px;\">")
                    .append(item.getName())
                    .append("</span> || ")
                    .append("Repo Lang : ").append(item.getLanguage())
                    .append(" || ")
                    .append("<a href=\"").append(item.getHtml_url()).append("\" target=\"_blank\">").append("Repo URL </a>")
                    .append("</div> ");
        }
        return stringRepos.toString();
    }
}
