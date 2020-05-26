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
Output : 4094:Titanic\nSomente Deus por Testemunha\nTitanic\nTitanic II\nO Resgate do Titanic\nNáufragos do Titanic\nTitanic: Blood and Steel\nTitanic\nTitãs\nAtaque dos Titãs\nTitã\nDuelo de Titãs\nFúria de Titãs\nTitanic - O Épico Nazista Banido\nFúria de Titãs 2\nFúria de Titãs\nOs Jovens Titãs\nTitan A.E.\nTitanic 2\nSatanic Panic\nS.O.S. Titanic\nAtaque dos Titãs\nTitans\nOs Jovens Titãs em Ação!\nTitanic\nThe Titan Games\nTitanic\nTitan\nTitane\nOs Jovens Titãs em Ação! Nos Cinemas\nJovens Titãs: O Contrato de Judas\nThe Titanic\nTitanic\nOs Jovens Titãs em Ação! Vs. Os Jovens Titãs\nTitanic II\nTitanic\nTitanica\nLutando Pela Paz\nAttack on Titan\nA Liga da Justiça e os Jovens Titãs\nTitã Simbiônico\nTitanic\nTitanium\nClass of the Titans\nA Lenda do Titanic\nNazi Titanic\nTitanic: A Lenda Continua\nSatânico\nSaving the Titanic\nTitanic\nTitanfall 2\nTitanic\nTitans\nTitanic: The Aftermath\nTitan\nCírculo de Fogo: A Revolta\nWhose Line Is It Anyway?\nMistérios do Titanic\nTitans\nPercy Jackson and the Titan's Curse\nTentacolino\nTitanic 5 Second Movies\nTitanic KIMkelly\nTitanic When Weather Changed History\nTitanic Collision Course\nTitanic Segundos Fatais\nTitanic HBO First Look\nTitanic Time & Again\nTitanic Cinema Historia\nTitanic IC Places Hollywood\nTitanic La noche temática\nTitanic The True Story\nTitanic La Scene en Plus\nTitanic The Misadventures of Joker & Kylo\nTitanic The Unemployed Historian\nTitanic Ato Falho\nTitanic Ha-Shminiya\nTitanic MovieBerto\nTitanic L'Académie\nTitanic Tamara's Never Seen\nTitanic Faux Raccord\nTitanic The Real Story\n'Titanic' Casting Calls\nTitanic Uusi päivä\nTitanic Merci Qui?\nTitanic\nTitanic 30-Second Bunny Theatre\nTitanic A.J.'s Time Travelers\nTitanic French and Saunders\nTitanic Really That Good\nTitanic Time & Again\nTitanic Forget About It\nTitanic Va de Retro\nTitanic On Film\nTitanic How to Make It in Hollywood\nTitanic The Nostalgia Chick\nTitanic Who Knew?\nTitanic Explicado a los frikis\nTitanic\nTitanic Honest Trailers\nAttack on Titan: Junior High\nInimigos e Amantes\nShingeki no kyojin: Endo obu za wârudo\nTitan Maximum\nWhose Line Is It Anyway?\nOs Jovens Titãs: Missão Tóquio\nSaved from the Titanic\nTitanic vals\nTitanium\nA Camareira do Titanic\nTitans\nTitanfall\nKitani Mohabbat Hai\nTeen Titans Project\nBack to the Titanic\nTeen Titans\nDeathstalker - Desafio Mortal\nTitanica\nClash of the Titans\nTitan\nWhose Line Is It Anyway?\nTitanik\nCrash of the Titans\nTitan\nA Teta e a Lua\nRômulo & Remo\nCírculo de Fogo\nTitans\nMetatitanic\nTransformers: Titans Return\nBritanick\nCR: Titanic\nLego Titanic\nTitanic 32\nTitanic 2.0 Loway and Mr. Hand\nTitanicat Animals Unleashed\nTitanic 3D Chris Stuckmann Movie Reviews\nLe Titanic L'Épopée temporelle\nTitanic 3D Projector\nTitanic 2 Time & Again\nTitanic II Hunter Reviews\nThe Titanic In Search of...\nTitanic 2 FanboyFlicks, Bad Movies!\nTitanica\nTattoo Titans\nTales of Titans\nTitans\nWords of the Titanic\nSirens of Titan\nGekijôban Shingeki no Kyojin Kôhen: Jiyû no tsubasa\nWhy They Sank the Titanic\nTitanic Code\nTitanic Love\nEl Hormiguero: Vacaciones en el Titanic\nTitán\nNew Teen Titans\nGekijouban Shingeki no kyojin Zenpen: Guren no yumiya\nTitanic Boy\nTitans Titãs\nTitanic: The Legend Lives On\nStarship Titanic\nA Slap on Titan\nTitán Tantalus\nTitan\nTitan Est\nTitan Quest\nTitan Space Pioneer\nTitans Transformers: Cybertron\nTitans Eleventh Hour: O Último Recurso\nThe Titan Dan August\nTitanic Review\nTitan\nTitanic: Birth of a Legend\nThe Titans\nBife 'Titanik'\nTitan Beyond Belief: Fact or Fiction\nTitan SesioneS con Alejandro Franco\nThe Titans Xena: A Princesa Guerreira\nTitanyum\nAttack on Titan 2\nTitane\nTitans\nTitan\nTitan\nTitan\nTitans\nTitanic 2: Give up the Ghost\nClash of the Titans\nTitanic: Sinking the Myths\nTitanic: Echoes of Titanic\nTitanic Survivors\nThe Titans In a Time of Ancient Gods: The Xena Podcast with Hayley and Justine\nAmerican Titans\nTitan Interplanetary Quest\nWrath of the Titans\nRockets and Titans\nTitanic: 100 Years On\nTonî Takitani\nTitanic Explorer\nBeyond Titanic\n
```

```text
Input : 7:TITANic
Output : 4094:Titanic\nSomente Deus por Testemunha\nTitanic\nTitanic II\nO Resgate do Titanic\nNáufragos do Titanic\nTitanic: Blood and Steel\nTitanic\nTitãs\nAtaque dos Titãs\nTitã\nDuelo de Titãs\nFúria de Titãs\nTitanic - O Épico Nazista Banido\nFúria de Titãs 2\nFúria de Titãs\nOs Jovens Titãs\nTitan A.E.\nTitanic 2\nSatanic Panic\nS.O.S. Titanic\nAtaque dos Titãs\nTitans\nOs Jovens Titãs em Ação!\nTitanic\nThe Titan Games\nTitanic\nTitan\nTitane\nOs Jovens Titãs em Ação! Nos Cinemas\nJovens Titãs: O Contrato de Judas\nThe Titanic\nTitanic\nOs Jovens Titãs em Ação! Vs. Os Jovens Titãs\nTitanic II\nTitanic\nTitanica\nLutando Pela Paz\nAttack on Titan\nA Liga da Justiça e os Jovens Titãs\nTitã Simbiônico\nTitanic\nTitanium\nClass of the Titans\nA Lenda do Titanic\nNazi Titanic\nTitanic: A Lenda Continua\nSatânico\nSaving the Titanic\nTitanic\nTitanfall 2\nTitanic\nTitans\nTitanic: The Aftermath\nTitan\nCírculo de Fogo: A Revolta\nWhose Line Is It Anyway?\nMistérios do Titanic\nTitans\nPercy Jackson and the Titan's Curse\nTentacolino\nTitanic 5 Second Movies\nTitanic KIMkelly\nTitanic When Weather Changed History\nTitanic Collision Course\nTitanic Segundos Fatais\nTitanic HBO First Look\nTitanic Time & Again\nTitanic Cinema Historia\nTitanic IC Places Hollywood\nTitanic La noche temática\nTitanic The True Story\nTitanic La Scene en Plus\nTitanic The Misadventures of Joker & Kylo\nTitanic The Unemployed Historian\nTitanic Ato Falho\nTitanic Ha-Shminiya\nTitanic MovieBerto\nTitanic L'Académie\nTitanic Tamara's Never Seen\nTitanic Faux Raccord\nTitanic The Real Story\n'Titanic' Casting Calls\nTitanic Uusi päivä\nTitanic Merci Qui?\nTitanic\nTitanic 30-Second Bunny Theatre\nTitanic A.J.'s Time Travelers\nTitanic French and Saunders\nTitanic Really That Good\nTitanic Time & Again\nTitanic Forget About It\nTitanic Va de Retro\nTitanic On Film\nTitanic How to Make It in Hollywood\nTitanic The Nostalgia Chick\nTitanic Who Knew?\nTitanic Explicado a los frikis\nTitanic\nTitanic Honest Trailers\nAttack on Titan: Junior High\nInimigos e Amantes\nShingeki no kyojin: Endo obu za wârudo\nTitan Maximum\nWhose Line Is It Anyway?\nOs Jovens Titãs: Missão Tóquio\nSaved from the Titanic\nTitanic vals\nTitanium\nA Camareira do Titanic\nTitans\nTitanfall\nKitani Mohabbat Hai\nTeen Titans Project\nBack to the Titanic\nTeen Titans\nDeathstalker - Desafio Mortal\nTitanica\nClash of the Titans\nTitan\nWhose Line Is It Anyway?\nTitanik\nCrash of the Titans\nTitan\nA Teta e a Lua\nRômulo & Remo\nCírculo de Fogo\nTitans\nMetatitanic\nTransformers: Titans Return\nBritanick\nCR: Titanic\nLego Titanic\nTitanic 32\nTitanic 2.0 Loway and Mr. Hand\nTitanicat Animals Unleashed\nTitanic 3D Chris Stuckmann Movie Reviews\nLe Titanic L'Épopée temporelle\nTitanic 3D Projector\nTitanic 2 Time & Again\nTitanic II Hunter Reviews\nThe Titanic In Search of...\nTitanic 2 FanboyFlicks, Bad Movies!\nTitanica\nTattoo Titans\nTales of Titans\nTitans\nWords of the Titanic\nSirens of Titan\nGekijôban Shingeki no Kyojin Kôhen: Jiyû no tsubasa\nWhy They Sank the Titanic\nTitanic Code\nTitanic Love\nEl Hormiguero: Vacaciones en el Titanic\nTitán\nNew Teen Titans\nGekijouban Shingeki no kyojin Zenpen: Guren no yumiya\nTitanic Boy\nTitans Titãs\nTitanic: The Legend Lives On\nStarship Titanic\nA Slap on Titan\nTitán Tantalus\nTitan\nTitan Est\nTitan Quest\nTitan Space Pioneer\nTitans Transformers: Cybertron\nTitans Eleventh Hour: O Último Recurso\nThe Titan Dan August\nTitanic Review\nTitan\nTitanic: Birth of a Legend\nThe Titans\nBife 'Titanik'\nTitan Beyond Belief: Fact or Fiction\nTitan SesioneS con Alejandro Franco\nThe Titans Xena: A Princesa Guerreira\nTitanyum\nAttack on Titan 2\nTitane\nTitans\nTitan\nTitan\nTitan\nTitans\nTitanic 2: Give up the Ghost\nClash of the Titans\nTitanic: Sinking the Myths\nTitanic: Echoes of Titanic\nTitanic Survivors\nThe Titans In a Time of Ancient Gods: The Xena Podcast with Hayley and Justine\nAmerican Titans\nTitan Interplanetary Quest\nWrath of the Titans\nRockets and Titans\nTitanic: 100 Years On\nTonî Takitani\nTitanic Explorer\nBeyond Titanic\n
```

```text
Input : 10:lagoa azul
Output : 171:Lagoa Azul Terra Brasil\nLagoa Azul: O Despertar\nClub Lago Azul Al salir de clase\nA Lagoa Azul\nMíster Lago Azul Al salir de clase\nDe Volta à Lagoa Azul\nA Lagoa Azul\n
```

```text
Input : 17:O Poderoso Chefão
Output : 472:O Poderoso Chefão\nO Poderoso Chefão Receitas em série com Isadora Becker\nO Poderoso Chefão II\nO Poderoso Chefão III\nO Poderoso Chefão Por Acaso\nThe Godfather vs. The Godfather Part II\nThe Godfather: Cannoli\nO Poderoso Chefinho A Grande Família\nA Fúria do Poderoso Chefão\nO Conselheiro do Poderoso Chefão\nRestaurando O Poderoso Chefão\nThe Godfather: Clemenza\nO Mundo de O Poderoso Chefão\nThe Godfather on the Red Carpet\nThe Godfather: Riffing on the Riffing\n
```

```text
Input : 13:The Godfather
Output : 5744:O Poderoso Chefão\nThe Godfather\nThe Godfather\nO Poderoso Chefão II\nO Poderoso Chefão III\nThe Godfather: A Novel for Television\nO Chefão de Nova York\nThe Godfather Trilogy: 1901-1980\nThe Godfather II\nGodfather of Harlem\nThe Godfathers\nAmor E Vingança\nO Céu Mandou Alguém\nGodfather\nGod Father\nOur Godfather\nThe Godfather\nThe Godfather\nThe Godfather Legacy\nThe Godfather\nThe Godfather: Part 2\nGodfather\nPadrinhos de Tóquio\nThe Godfathers I'm Dickens, He's Fenster\nThe Godfather Cinema & Spice\nThe Godfather Beyond the Blockbusters\nThe Godfather\nThe Godfather Seaview\nThe Godfather Tamara's Never Seen\nThe Godfathers Inside the Mafia\nThe Godfather Jr.\nThe Godfather Sammy & Co\nThe Godfather Renegade Cut\nThe Godfather High Incident\nThe Godfather Matlock\nThe Godfather Doctor in Charge\nThe Godfather Os Quatro Homens Justos\nEd the Godfather Mister Ed\nThe God Father 60 Minutes\nThe Godfather Um Amor de Família\nThe Godfather Cute Girl Movie Review\nThe Godfather Ascendance\nThe Godfather Lost in Adaptation\nThe Godfather SCTV Network 90\nThe Godfather Brothers Grimm Fairy Tales: Poseidon God of Water - 20, Story Time\nThe Godfather Jake and Amir\nThe Godfather\nThe Godfather Bingles\nThe Godfather Accidentally on Purpose\nThe Godfather People Just Do Nothing\nThe God-Fathers The Soul Man\nThe Godfather\nThe Godfather Sorry!\nL'amico del padrino\nThe Godfather: Mob Wars\nGodfather\nThe Godfathers of Hardcore\nF. Godfather\nThe Good Father\nChung gik tin ji moon sang\nXiangang xiao jiao fu\nThe Godfathers of Mondo\nO Conselheiro do Poderoso Chefão\nMy Father, Godfather\nTrês Padrinhos\nThe Black Godfather\nThe Good Father\nThe Godfather of Green Bay\nGjoleka djali i abazit\nDisco Godfather\nThe Godfather Parody\nThe Godfather of Disco\nThe Godfather and the Mob\nThe Godfather Opening\nThe Good Father\nThe Good Father\nThe Last Godfather\nZinksärge für die Goldjungen\nGotti: Godfather and Son\nProti fora nonos\nGodfather Chuyen Ngay Xua\nGodfather Malvolia: The Queen of Screams\nGodfather Sorry, Ari\nGodfather CollegeHumor Originals\nGodfather Ayesha's Homemade\nGodfather Wayne and Shuster International\nGodfather 5 Second Movies\nGodfather\nGodfather The Naked Chef\nThe Good Father Doctors\nThe Goodfather\nThe GoodFather Treasure King\nThe Goodfather The Kids from C.A.P.E.R.\nThe Good Father Casualty\nThe Godfather II: Crime Rings\nA Fúria do Poderoso Chefão\nThe Godfather of Terror\nThe Three Godfathers\nThe Godfather of Sarin\nThe Godfather Part IV America's Court with Judge Ross\nThe Godfather: Clemenza\nDer Enkel des Paten\nThe Godfather Trilogy Sardonicast\nThe Godfather Legacy History Specials\nThe Godfather Part II Tamara's Never Seen\nOur Father the Godfather 48 Hours: Hard Evidence\nThe Godfather: Part 3 Cheers\nThe Godfather and the Crib Nesting\nThe Godfather In-Law\nThe Godfather: Jupiter The Planets\nThe Godfather of Waikiki Dog the Bounty Hunter\nThe Godfather Trials Bizness As Usual\nThe Godfather: Part II Renegade Cut\nThe Godfather: Gangland\nThe Godfathers of Time\nHip Hop to the Godfather Kid Notorious\nThe Godfather Pt. IV America's Court with Judge Ross\nAndy the Godfather The Amos 'n Andy Show\nThe Godfather... And Ubul És Ubul\nThe Godfather (1972) Cinematic Venom Presents: 1001 Movies You Must See Before You Die\nThe Godfather: Cannoli\nEl compadre Mendoza\nBonanno: A Godfather's Story\nThe Godfather vs. The Godfather Part II\nDa jiao long\nFrancis and the Godfather\nSno-Line\nThe Three Godfathers\nLittle Godfather\nThe Godfather Family: A Look Inside\nThe Godfather: The Don's Edition\nThe Godfather : The Orient Club\nJian dong xiao xiong\nThe Three Godfathers\nThe Gay Godfather\nGodfather Gene Gene Simmons: Family Jewels\nGodfather II Sage Reviews\nGodfather Death Brothers Grimm Fairy Tales: Poseidon God of Water - 20, Story Time\nPère et parrain\nGodfathering Nurse Jackie\nGodfather Too Dog's Head Bay\nGodfather II The Angry Joe Show\nDa ge rang wei\nThe Godfather of Fitness\nBo jin\nThe Real Godfather\nThe Godfathers Daughter\nThe Godfather: Blackhand Edition\nA Outra Face do Chefão\nThe Godfather's Daughter\nDope Godfathers\nAwesome Godfather Magical Tales\nMovie Godfathers Time & Again\nIlbon daebu\nChefão por Acaso\nMumbai Godfather\nThe Godfather: A Look Back UCB Comedy Originals\nThe Godfather: Riffing on the Riffing\nThe Godfathers of Education Little Napoleons\nThe Godfathers of Comedy\nThe Godfather: Kiss of Death\nThe Punk Meets the Godfather Junior: The Miniseries\nThe Music of 'The Godfather'\nThe Godfather: Swiss Parody\nThe Godfather of Cocaine Frontline\nMr. Monk Meets the Godfather Monk: Um Detetive Diferente\nPS Vita & the Godfather Review The Emilio Game Show\nConsulting the Godfather\nThe Godfather of the Bride 2 Frango Robô\nThe Godfather's Daughter 48 Hours\nThe Godfather: On Location\nCannoli from The Godfather Binging with Babish\nThe Godfather: Not the Movie Hitz\nThe Godfather on the Red Carpet\nGodfathers of London\nThe Goldfather Fool's Gold\nPaul Mooney: The Godfather of Comedy\nLan gui yu che tou\nThe Godfather: Behind the Scenes\nOsaka daebu\nThe Fairy Godfather\nGodfather of Pittsburgh\nThe Last Godfather\nMedici: Godfathers of the Renaissance\nMemoirs of a Godfather\nStoryboards: The Godfather Part III\nRussian Godfathers\nHerschell Gordon Lewis: The Godfather of Gore\nChue chop chuan ha reung\nThe Rockford Files: Godfather Knows Best\nSoldier Godfather\nGodfather: The Legend Continues\nThe Fairy Godfather Eu Sou o Máximo\nMexican Godfather Manhunt: Kill or Capture\nGodfather of Pawn Trato Feito\nRequiem for a Godfather The Partners\nDerrick's Godfather CollegeHumor Originals\nTahiti Godfather\nNinja Godfather Ninja the Mission Force\nGodfather of Drugs Auwch_\n
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
