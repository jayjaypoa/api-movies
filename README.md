# Project : api-movies-server
## SERVER PROJECT 
#### 1. OBJECTIVE :
The customer has requested a way to query for movie titles in [IMDB](https://www.imdb.com/).
<br><br>
#### 2. STACK :
- [Java](https://docs.oracle.com/en/java/javase/11/docs/api/index.html) (*version 11*)
- [Guice](https://github.com/google/guice) (*version 4.0*)
- [Gradle](https://docs.gradle.org/6.1.1/release-notes.html) (version 6.1.1)
- [Apache Commons](https://commons.apache.org/) (*version 3.0*)
- [JSoup](https://jsoup.org/) (*version 1.3.1*)
- [Log4J](https://logging.apache.org/log4j/2.x/) (*version 1.2.17*)
- [JUnit](https://junit.org/) (*version 4.12*)
<br><br>
#### 3. TECHNICAL DETAILS :
- The IMDB's HTML is parsed with JSoup.
  - URL's examples :
    - [Titanic](https://www.imdb.com/find?s=tt&q=Titanic&ref_=nv_sr_sm)
    - [O Poderoso Chefão](https://www.imdb.com/find?s=tt&q=O+Poderoso+Chef%C3%A3o&ref_=nv_sr_sm)
    - [Sicario](https://www.imdb.com/find?s=tt&q=sicario&ref_=nv_sr_sm)
    <br><br>  
  - After get these content, the application convert these for a object class and so filter to get just the movies titles. At the proccess finish, the application generate the response object with base at the output definition format.
<br><br>
#### 4. ANOTHER DETAILS :
- [Guice](https://github.com/google/guice) for dependency injection
- The [Optional](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html) Java Class was used for dealing with *null*
- The number port  32000 ([TCP](https://pt.wikipedia.org/wiki/Transmission_Control_Protocol)) is readed for requests
- Support for multiple concurrent accesses
- The Uncle Bob’s [Clean Code](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) principles was respected
- For get the movies titles, the application do a GET request in IMDB's URL.
<br><br>
#### 5. INPUT FORMAT :
- The protocol is text and the input is with this format :
```text
<query_length>:<query>
```
- *query_length* : is the length of the query
- *query* : is the movie title to looking for
<br><br>
#### 6. OUTPUT/RESPONSE FORMAT :
- The response is a movie title list in String format
- Each movie title was separated with LF (\n).
- The application contabilize the movie separator - LF (\n) - at the response length.
- The protocol is text and the response is with this format :  
```text
<payload_length>:<payload>
```
- *payload_length* : is the length of the response content
- *payload* : is the response content
<br><br>
#### 7. ERROR LIST :
- In error case, the application will return a code and a message for better detailment
- Errors code possibles : *EnumApiMoviesException.java* 
<br><br>
#### 8. INPUT AND OUTPUT EXAMPLES :
```text
Input : 7:TITANIC
Output : 114:Titanic\nTitanic II\nTitanic\nRaise the Titanic\nTitanic: Blood and Steel\nTitanic\nTitanic\nA Night to Remember\n
```

```text
Input : 7:TITANic
Output : 114:Titanic\nTitanic II\nTitanic\nRaise the Titanic\nTitanic: Blood and Steel\nTitanic\nTitanic\nA Night to Remember\n
```

```text
Input : 10:lagoa azul
Output : 89:Blue Lagoon: The Awakening\nThe Blue Lagoon\nReturn to the Blue Lagoon\nThe Blue Lagoon\n
```

```text
Input : 17:O Poderoso Chefão
Output : 188:The Godfather\nThe Godfather: Part II\nThe Godfather: Part III\nThe Godson\nThe Godfather vs. The Godfather Part II\nThe Godfather: Clemenza\nThe Black Godfather\nThe Godfather's Advisor\n
```

```text
Input : 13:The Godfather
Output : 99:The Godfather\nThe Godfather: Part II\nThe Godfather: Part III\nThe Godfather Saga\nThe Godfather\n
```

```text
Input : 
Output : 24:ERR-3000 - Invalid input
```

```text
Input : 0:Lagoa Azul
Output : 25:ERR-3002 - Invalid length
```

```text
Input : 200:Lagoa Azul
Output : 25:ERR-3002 - Invalid length
```

```text
Input : null
Output : 30:ERR-3004 - Separator not found
```

```text
Input : \n
Output : 30:ERR-3004 - Separator not found
```

```text
Input : :::
Output : 30:ERR-3004 - Separator not found
```

```text
Input : aaa:bbb
Output : 25:ERR-3002 - Invalid length
```

```text
Input : 25:ERR-3002 - Invalid length
Output : 26:ERR-5003 - Movie not found
```

```text
Input : aaa:
Output : 25:ERR-3002 - Invalid length
```

```text
Input : 3:
Output : 25:ERR-3002 - Invalid length
```

```text
Input : 5:12345
Output : 150:1234\nBarney's 1-2-3-4 Seasons\n1234\nCoolio: 1 2 3 4 (Sumpin' New)\nFeist: 1234\nNY Man 1234\nFitz and the Tantrums: 123456\nBlessed Album: 1 2 3 4\n
```

```text
Input : 15:A Grande Famlia
Output : 160:A Grande Família\nUna grande famiglia - 20 anni prima\nA Grande Família: O Filme\nUna grande famiglia\nLa Grande Famille\nLa grande famille\nLa grande famille\n
```

```text
Input : 85:Um filme qualquer com nome gigantesco que acontece no norte da Italia na decada de 80
Output : 26:ERR-5003 - Movie not found
```
<br>

#### 9.  RUNNING THE PROJECT  
##### 9.1. HOW GENERATE THE .JAR FILE :
This task compiles, tests, and assembles the code into a JAR file. You can run it like this:
```text
./gradlew build
```
After a few seconds, "BUILD SUCCESSFUL" indicates that the build has completed.
The jar file will be generated at *\<project\>/build/libs/*
<br>
##### 9.2. HOW RUN THE PROJECT :
You can run it like this:
```text
./gradlew run
```
##### 9.3. HOW RUN FROM THE OUTPUT JAR  :
You can run it like this:
```text
./gradlew runWithExecJarExecutable
```
JUST ATTENTION FOR YOUR JAVA VERSION. The project use Java version 11.<br>
The *gradle.build* file explicit the Java version.


<br><br>

# CALLING THE SERVER
At below, two possibilities - just sugestion - for get the server response.<br>
## 1. RUNNING THE CLIENT PROJECT (api-movies-client)
#### 1.1. OBJECTIVE :
ATTENTION : THIS CLIENT PROJECT IS JUST FOR TEST THE SERVER RESPONSE.<br>
THIS PROJECT DON'T LOOK FOR HAVE A GOOD PRACTICES LIKE DESIGN PATTERN OR A UNIT TESTS COVERAGE.<br>
THE ONLY OBJECTIVE IS CALL THE SERVER PROJECT (api-movies-server).
<br><br>

## 2. TELNET
#### 2.1 EXAMPLE:
![Telnet Example](https://i.imgur.com/TJ4F29z.png)
