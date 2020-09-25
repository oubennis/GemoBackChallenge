# Gemography Backend Challenge

This project is done in line with Gemography backend challenge. It aims at creating a microservice that lists languages used by the 100 trending projects, based on the Github API which help to get trending repository. 

#About the API:

* It starts by using Github API to obtain the 100 trending repository by using these parameters : "page" and "per_page", that the API offers.
* Afterwards we create three EndPoints in order to order to :
  1- List languages used in these repositories.
  2- Count number of repos using each language.
  3- List of repos using each language.

#How it works ?

* Run the Spring-Boot project in your local or in any other compatible environnement that include a JDK and a Maven repository 
* Then, to list languages used on trending repositories we use : GET ---> http://localhost:8080/api/trendReposLang
* We can get the Laguage repositories count by using : GET ---> http://localhost:8080/api/trendReposLang/count/{language}
* We can get the repositories by Language by using : GET ---> http://localhost:8080/api/trendReposLang/listRepos/{language}
