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
- [JMeter](https://jmeter.apache.org/) (*version 5.2.1*)
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
Input : nulll
Output : 37:ERR-3003 - Separator validation error
```

```text
Input : \n
Output : 37:ERR-3003 - Separator validation error
```

```text
Input : :::
Output : 37:ERR-3003 - Separator validation error
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
Output : 37:ERR-3003 - Separator validation error
```

```text
Input : 3:
Output : 37:ERR-3003 - Separator validation error
```

```text
Input : ^[[H
Output : 37:ERR-3003 - Separator validation error
```

```text
Input : 5:12345
Output : 6365:12345\n1:23:45 Chernobyl\n1-2-3-4-5 Senses! Barney e Seus Amigos\n1234\n1,2,3,4,5,6 Get Out Alive with Bear Grylls\n1,2,3,4,5 Rainbow\n1 2 3 4 5 6 7 8\n1, 2, 3, 4, 5, 6, 7, 8 Mi adorada Malena\n1234\nEpisode #1.2345 One Life to Live\nEpisode #1.2345 Yeh Rishta Kya Kehlata Hai\nEpisode #1.2345 Shôten\nEpisode #1.2345 Unter uns\nEpisode #1.2345 Ventaneando\nEpisode #1.2345 Taarak Mehta Ka Ooltah Chashmah\nEpisode #1.2345 Loving\nEpisode #1.2345 The Edge of Night\nEpisode #1.2345 Ohayou Tokushima\nEpisode #1.2345 Neighbours\nEpisode #1.2345 Egoli: Place of Gold\nEpisode #1.2345 Home and Away\nEpisode #1.2345 Rannaghar\nEpisode #1.2345 Another World\nEpisode #1.2345 Aadade Aadharam\nEpisode #1.2345 Char Divas Sasuche\n1,2,3,4,5,6,7,8,9,10 Serious Amazon\nEpisode #1.2345 Rhythm City\nEpisode #1.2345 The Doctors\nEpisode #1.2345 Crossroads\nEpisode #1.2345 Kalimera zoi\nEpisode #1.2345 Marienhof\nEpisode #1.2345 One O'Clock News\nEpisode #1.2345 Coronation Street\nEpisode #1.2345 Le Bébête Show\nEpisode #1.2345 The Bold and the Beautiful\nEpisode #1.2345 Gute Zeiten, schlechte Zeiten\nEpisode #1.2345 Savdhaan India: Crime Alert\nEpisode #1.2345 Manasu Mamatha\nEpisode #1.2345 Six O'Clock News\nEpisode #1.2345 Jóban rosszban\nEpisode #1.2345 Hollyoaks\nEpisode #1.2345 Pierwsza milosc\nEpisode #1.2345 Days of Our Lives\nEpisode #1.2345 Verbotene Liebe\nEpisode #1.2345 Abhishekam\nEpisode #1.2345 Brookside\n12:34\n1234\n1, 2, 3, 4... A Bruxa Onilda\n1-2-3-4 Love in Progress\n1234 MisteRogers' Neighborhood\n1234\n1234 Plus belle la vie\n1,2,3,4 Hannah & Pete: Live in Leeds City Centre\nFolge 2345 Sesamstraße\nEpisode #1.12345 General Hospital\nEpisode #1.12345 Days of Our Lives\nEpisode #1.12345 The Guiding Light\nEpisode #1.12345 As the World Turns\nNY Man 1234\nFitz and the Tantrums: 123456\nFeist: 1234\nEpisode #23.45 Fox News Sunday\nEpisode #23.45 Nintama Rantarô\nEpisode #2.345 Thatteem Mutteem\nEpisode #23.45 Electric Playground\nEpisode #23.45 America's Most Wanted\nEpisode #23.45 Thuis\nEpisode #22.345 MSNBC Live\nEpisode #23.45 Extra\nEpisode #23.45 The Atheist Experience\nEpisode #23.45 The View\nEpisode #23.45 The Tonight Show Starring Johnny Carson\nEpisode #23.45 Hotel Cæsar\nEpisode #23.45 Countdown\nEpisode #23.45 This Week\nEpisode #23.45 Ros na Rún\nEpisode #2.345 Saravanan Meenatchi\nEpisode #23.45 Fair City\nEpisode #23.45 The New Price Is Right\nEpisode #23.45 Avanu Mathe Shravani\nEpisode #23.45 Top of the Pops\nEpisode #23.45 Dateline NBC\nEpisode #23.45 Siskel & Ebert & the Movies\nEpisode #23.45 Loose Women\nBarney's 1-2-3-4 Seasons\n2009 episode 1, 2, 3, 4, 5, 6, 7, 8, 9 &10 Floor Faber\n1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 La guerre des femmes\nLuim 1, 2, 3 & 4\nJacob1234\nFolge 1234 Sesamstraße\nMurmansk: 123.4\nEpisode #1.234 Las Zuquillo\nEpisode #1.234 Home Along da Riles\nEpisode #1.2342 The Edge of Night\nEpisode #1.2343 Unter uns\nEpisode #1.2340 Ventaneando\nEpisode #12.34 Thuis\nEpisode #1.2348 Marienhof\nEpisode #1.2349 Home and Away\nEpisode #1.234 Taynye znaki\nEpisode #1.234 Behenein\nEpisode #1.2347 Char Divas Sasuche\nEpisode #12.34 ITV Play of the Week\nEpisode #1.234 Ek Boond Ishq\nEpisode #1.234 Kumkum Bhagya\nEpisode #1.234 Anak Langit\nEpisode #1.234 Amigovios\nEpisode #1.234 Mann Ki Awaaz Pratigyaa\nEpisode #1.234 Jodha Akbar\nEpisode #1.234 Kesariya Balam Aavo Hamare Des\nEpisode #1.234 Ye Teri Galliyan\nEpisode #1.2343 Yeh Rishta Kya Kehlata Hai\nEpisode #1.234 Zabranena Lyubov\nEpisode #1.2344 Manasu Mamatha\nEpisode #1.234 Chellamay\nEpisode #1.2348 Shôten\nEpisode #11.234 The Mike Douglas Show\nEpisode #1.234 Meri Durga\nEpisode #1.234 Tujh Sang Preet Lagai Sajna\nEpisode #1.234 Basta't kasama kita\nEpisode #1.2346 Yeh Rishta Kya Kehlata Hai\nEpisode #1.234 Parasparam\nEpisode #1.234 Remix\nEpisode #1.234 The River\nEpisode #1.234 Rated K\nEpisode #1.234 Kriminalnaya Rossiya\nEpisode #1.234 Herzflimmern - Liebe zum Leben\nEpisode #1.234 Gata salvaje\nEpisode #12.34 Countdown\nEpisode #1.234 Labs ko si babes\nEpisode #1.234 Kirara: Ano ang kulay ng pag-ibig?\nEpisode #1.1234 Woh Rehne Waali Mehlon Ki\nEpisode #1.234 Walang tulugan with the Master Showman\nEpisode #1.2342 Neighbours\nEpisode #1.234 Mata Ki Chowki\nEpisode #1.2342 Taarak Mehta Ka Ooltah Chashmah\nEpisode #1.234 Irmãos Coragem\nEpisode #12.34 Flog It!\nEpisode #1.234 Tujhse Hai Raabta\nEpisode #12.34 Dlaczego ja?\nEpisode #1.234 Kadenang ginto\nEpisode #1.1234 Rhythm City\nEpisode #1.234 Rani Rashmoni\nEpisode #1.234 Tapur Tupur\nEpisode #1.1234 Kalimera zoi\nEpisode #1.234 El amor tiene cara de mujer\nEpisode #1.1234 Parasparam\nEpisode #1.2342 Yeh Rishta Kya Kehlata Hai\nEpisode #1.2340 Verbotene Liebe\nEpisode #1.1234 El secreto de Puente Viejo\nEpisode #1.234 Aahat\nEpisode #1.2340 Home and Away\nEpisode #1.234 Julia - Wege zum Glück\nEpisode #1.234 Ang probinsyano\nEpisode #1.2347 Rannaghar\nEpisode #1.2344 Savdhaan India: Crime Alert\nEpisode #1.2343 The Edge of Night\nEpisode #1.234 Begusarai\nEpisode #1.2346 Aadade Aadharam\nEpisode #1.2341 Egoli: Place of Gold\nEpisode #1.2346 Hollyoaks\nEpisode #1.2343 Le Bébête Show\nEpisode #12.34 Fashion News Live\nEpisode #1.2346 Days of Our Lives\nEpisode #1.234 Libertad condicionada\nEpisode #1.2341 Loving\nEpisode #1.1234 Egoli: Place of Gold\nEpisode #1.234 Gorodok\nEpisode #1.234 Harazat Tshnami\nEpisode #1.234 Zvaniy uzhin\nJérôme 50: 1, 2, 3, 4\nEpisode #1.234 Feitiço de Amor\nEpisode #1.234 Niram Maratha Pookal\nEpisode #12.34 The Atheist Experience\nEpisode #1.234 Principessa\nEpisode #1.1234 The Edge of Night\nEpisode #12.34 Burke's Backyard\nEpisode #1.234 Sana'y wala nang wakas\nEpisode #1.2344 Egoli: Place of Gold\nEpisode #1.2340 Kalimera zoi\nEpisode #1.234 Le Bébête Show\nEpisode #1.2348 Hollyoaks\nEpisode #1.234 Emmerdale Farm\nEpisode #12.34 My Wife's Girlfriends\nEpisode #1.234 O Direito de Nascer\nEpisode #1.234 Saraswatichandra\nEpisode #1.234 Kusum Dola\nEpisode #1.234 Parvarrish: Kuchh Khattee Kuchh Meethi\nEpisode #1.234 Mere Sai\nEpisode #1.234 Tekka Raja Badshah\nEpisode #1.234 Was gibt es Neues?\nEpisode #12.34 Bigg Boss\nEpisode #1.234 A Menina do Veleiro Azul\nEpisode #1.2341 Jóban rosszban\nEpisode #1.234 Zorra Total\nEpisode #1.234 To agana tulasi mun\nEpisode #1.2343 Six O'Clock News\nEpisode #1.234 Rainha das Flores\nEpisode #1.234 Kahiin To Hoga\n
```

```text
Input : 16:A Grande Familia
Output : 2179:A Grande Família\nLa gran familia\nA Grande Família\nA Grande Família: O Filme\nLa familia y... uno más\nLong jia jiang\nA Grande Família Silva A Grande Família\nA Grande Família A Grande Família\nA Grande Familia Chapa Quente\nUna grande famiglia\nLa grande famille\nLa grande famille\nLa Grande Famille\nLa grande famille Workingirls\nLa grande famille C'est cool!\nUna grande famiglia Licia dolce Licia\nQué follón de familia\nA Grande Família Justiça A Grande Família\nLa grande famine de Mao La case du siècle\nLa grande famine En direct de notre passé\nUna grande famiglia - 20 anni prima\nReunión de familia\nCuestión de familia\nCuestión de familia Los especiales de ATC\nLa grande famille du cinéma Studio Bagel\nLa gran familia 7 vidas\n¿Agrandar la familia? Aquí Mando Yo\nO Natal da Grande Faminta A Grande Família\nGrandes Famílias, Pequenos Negócios A Grande Família\nA Grande Formatura Militar\nLa grande famille de l'aviation Trente-Six Chandelles\nLa grande famille des terriens Bibi et Geneviève\nComando negro: La gran familia\nBien de Familia, una película musical\nGrande família, sala nem tanto... Decora\nThe Wade Family: A Visit to Grandmother Television Club\nLeo Méndez, el jefe de familia Los Méndez\nCapacitación de jefas de familia\nLa plus grande famille du monde Les grands reportages\nAs Grandes Férias\nEl temor más grande de la familia Falco Casa de Muñecos\nLa gran familia española: Los procesos\nBonusfamiljen\nLa cicatrice, une famille dans la grande guerre La case de l'oncle Doc\nAs Aventuras da Família Robinson\nBelas Famílias\nGala 11: Expulsión de Raquel Bollo/Visita de familiares/Visita de Morat/Nominación Gran hermano VIP\nTrump to detain immigrant families indefinitely & is ISIS making a comeback? Watching the Hawks\nA Família do Setão\nA Grande Fuga\nUna grande famiglia\nGala 11: Expulsión de Ivonne Reyes/Nominación Aída, Aylén y Elettra/Visita de familiares Gran hermano VIP\nO Grande Homem\nLes grandes familles\nVolúpia do Poder\nBolshaya semya\nA Grande Remodelação A Minha Família\nGrandes Expectativas Familia Moderna\nGrandes Mudanças Médico de Família\nGrandes benvidas Libro de familia\nA Grande Família Screen Two\n
```

```text
Input : 14:two and a half
Output : 8517:Dois Homens e Meio\nDhaai Akshar Prem Ke\nTwo and a Half Men: Growing Up Harper\nTwo and a Half Men: Dying is Easy, Comedy is Hard\nTwo and a Half Maccs\nTwo-and-a-Half\nThe Women of Two and a Half Men\nHalbe Portionen\nDos angeles y medio\nTwo and a Half Aliens 2 Aliens\nTwo and a Half Deaths CSI: Investigação Criminal\nTwo and a half Ausländer Comedy Rocket\nTwo and a Half Hours\nTwo and a Half Men Infanity\nTwo and a Half Pilots LA to Vegas\nTwo and a half hours\nTwo and a Half Men Sobrenatural\nThe New Two and a Half Men The Bob Show\nTwo and a Half Men Just Seen It\nTwo and a Half Watchmen Electric Spoofaloo\nTwo and a Half Saiyans DragonShortZ\nTwo and a Half Iron Men Tvoovies\nTwo and a Half Lion Kings The RE(boot, vival, hash)-Cast\nThe Two and a Half Feathers Dad's Army\nThe Two and a Half Feathers The Dad's Army Podcast\nHalf-Life 2: Episode Two\nA Day in the Life of Two and a Half Men\nEgo and a half The Hyperreality\nKét félidö a pokolban\nHalf of Twenty Two\nDue imbroglioni e mezzo\nTwo Men Talking About Two and a Half Men\nRatings Plummet for 'Two and a Half Men'! The Celebrity Daily\nThe Buzz Identity/Two and a Half Man Mad\nHalf Mat, One Mat, Two and a Half Go of Rice Kozure ôkami\nTwo and a Half Babies/Anchor's Away Os Padrinhos Mágicos\nTwo Half Times to Hell\nTwo and No Half Men\nTwo N a Half Mice\nTwo Half Men Package Deal\nJerry O'Connell Auditions for Two and a Half Men\nCrazy Apple/Agent Two and Half Kelly's Kountry Junction\nThe Denial Show: Charlie Sheen & Two and a Half Men The Denial Show\nKnockout Special: Two Punches for $2,500!/Half Price for Half a Driveway! Judge Judy\nTake Two Aspirins and Half a Pint of Porpoise Milk A Feiticeira\nHalf Past Two: Smile Like You Mean It\nHalf Past Two: See You Again\nHalf Past Two: So Cal Summer\nHot Health Headlines/"Two and a Half Men" Star Jon Cryer/Actress Freida Pinto The Meredith Vieira Show\nJon Cryer on the Final Season of "Two and a Half Men". Plus, from "Gone Girl" and "Marry Me", Casey Wilson The Queen Latifah Show\nBonecas Explosivas\nThe Manster\nHalf Way to Hell\nPeople Magazine Is Bringing Us Two Incredible Stories From Their "Half Their Size" Issue! We're Meeting an Incredible Man Rachael Ray\nDeux jours et demi\nHalf the Picture Screen Two\nIT Chapter Two Half in the Bag\nThe Two Finger Rule Dois Homens e Meio\nThe Two Murderers Hancock's Half Hour\nNangnangnangnang Dois Homens e Meio\nVagabond on the Half Shell Under Two Bridges\nThe Lawyer Two N a Half Mice\nPilot Dois Homens e Meio\nThe Silhouette Two N a Half Mice\nFour Balls, Two Bats and One Mitt Dois Homens e Meio\nBehind the Scenes: Season Two Half Cut Tea\nWeekend in Bangkok with Two Olympic Gymnasts Dois Homens e Meio\nThis Unblessed Biscuit Dois Homens e Meio\nThe 'Ocu' or the 'Pado'? Dois Homens e Meio\nSlowly and in a Circular Fashion Dois Homens e Meio\nArguments for the Quickie Dois Homens e Meio\nProstitutes and Gelato Dois Homens e Meio\nMy Bodacious Vidalia Dois Homens e Meio\nGorp. Fnark. Schmegle. Dois Homens e Meio\nJust Like Buffalo Dois Homens e Meio\nIs There a Mrs. Waffles? Dois Homens e Meio\nSanta's Village of the Damned Dois Homens e Meio\n818-jklpuzo Dois Homens e Meio\nThe War Against Gingivitis Dois Homens e Meio\nApologies for the Frivolity Dois Homens e Meio\nAbove Exalted Cyclops Dois Homens e Meio\nA Bottle of Wine and a Jackhammer Dois Homens e Meio\nLookin' for Japanese Subs Dois Homens e Meio\nFrodo's Headshots Dois Homens e Meio\nNot in My Mouth! Dois Homens e Meio\nThe Party Hat Two N a Half Mice\nCows, Prepare to Be Tipped Dois Homens e Meio\nMeander to Your Dander Dois Homens e Meio\nPalmdale, Ech Dois Homens e Meio\nThe Soil is Moist Dois Homens e Meio\nTazed in the Lady Nuts Dois Homens e Meio\nInflatable Annie Two N a Half Mice\nWho's Vod Kanockers Dois Homens e Meio\nThe Squat and the Hover Dois Homens e Meio\nMy Damn Stalker Dois Homens e Meio\nCrude and Uncalled For Dois Homens e Meio\nOne Nut Johnson Dois Homens e Meio\nMr. McGlue's Feedbag Dois Homens e Meio\nThe Crazy Bitch Gazette Dois Homens e Meio\nFrankenstein and the Horny Villagers Dois Homens e Meio\nHumiliation Is a Visual Medium Dois Homens e Meio\nA Jock Strap in Hell Dois Homens e Meio\nA Sympathetic Crotch to Cry On Dois Homens e Meio\nIt Never Rains in Hooterville Dois Homens e Meio\nThe Mouse Trap Two N a Half Mice\nWorking for Caligula Dois Homens e Meio\nA Possum on Chemo Dois Homens e Meio\nFish in a Drawer Dois Homens e Meio\nErgo, the Booty Call Dois Homens e Meio\nThe Mooch at the Boo Dois Homens e Meio\nHookers, Hookers, Hookers Dois Homens e Meio\nWaiting for the Right Snapper Dois Homens e Meio\nA Lung Full of Alan Dois Homens e Meio\nCastrating Sheep in Montana Dois Homens e Meio\nSmell the Umbrella Stand Dois Homens e Meio\nSmooth as a Ken Doll Dois Homens e Meio\nGlamping in a Yurt Dois Homens e Meio\nIxnay on the Oggie Day Dois Homens e Meio\nA Pot Smoking Monkey Dois Homens e Meio\nWarning, It's Dirty Dois Homens e Meio\nPhase One, Complete Dois Homens e Meio\nIt Was Mame, Mom Dois Homens e Meio\nKinda Like Necrophilia Dois Homens e Meio\nThat Special Tug Dois Homens e Meio\nJerry's Date Two N a Half Mice\nMerry Thanksgiving Dois Homens e Meio\nNo Sniffing, No Wowing Dois Homens e Meio\nGumby with a Pokey Dois Homens e Meio\nAnd the Plot Moistens Dois Homens e Meio\nThe Sea Is a Harsh Mistress Dois Homens e Meio\nThat Darn Priest Dois Homens e Meio\nThank You for the Intercourse Dois Homens e Meio\nCity of Great Racks Dois Homens e Meio\nA Chic Bar in Ibiza Dois Homens e Meio\nGrandma's Pie Dois Homens e Meio\nFor Whom the Booty Calls Dois Homens e Meio\nFor the Sake of the Child Dois Homens e Meio\nOontz. Oontz. Oontz. Dois Homens e Meio\nPaint It, Pierce It or Plug It Dois Homens e Meio\nBaseball Was Better with Steroids Dois Homens e Meio\nYay, No Polyps Dois Homens e Meio\nSomething Salted and Twisted Dois Homens e Meio\nBig Flappy Bastards Dois Homens e Meio\nWelcome to Alancrest Dois Homens e Meio\nFerrets, Attack! Dois Homens e Meio\nKissing Abraham Lincoln Dois Homens e Meio\nCamel Filters and Pheromones Dois Homens e Meio\nThis Is Not Gonna End Well Dois Homens e Meio\nThe Flavin' and the Mavin' Dois Homens e Meio\nA Big Bag of Dog Dois Homens e Meio\nUntainted by Filth Dois Homens e Meio\nPinocchio's Mouth Dois Homens e Meio\nWalnuts and Demerol Dois Homens e Meio\nPie Hole, Herb Dois Homens e Meio\nAvoid the Chinese Mustard Dois Homens e Meio\nTucked, Taped and Gorgeous Dois Homens e Meio\nThank God for Scoliosis Dois Homens e Meio\nWelcome Home, Jake Dois Homens e Meio\nSpringtime on a Stick Dois Homens e Meio\nTinkle Like a Princess Dois Homens e Meio\nThat Was Saliva, Alan Dois Homens e Meio\nRelease the Dogs Dois Homens e Meio\nThe Devil's Lube Dois Homens e Meio\nA Bag Full of Jawea Dois Homens e Meio\nThe Ol' Mexican Spinach Dois Homens e Meio\nYes, Monsignor Dois Homens e Meio\nMmm, Fish. Yum. Dois Homens e Meio\nNine Magic Fingers Dois Homens e Meio\nMy Tongue Is Meat Dois Homens e Meio\nWest Side Story Dois Homens e Meio\nSips, Sonnets and Sodomy Dois Homens e Meio\nIce Cold Two N a Half Mice\nThe Unfortunate Little Schnauzer Dois Homens e Meio\nTwo Outta Three Ain't Bad Half Mile of Hell\nThing One, Thing Two Half Minute Horror\nWhich of These Two Ladies Is He Married To? Half Hour Story\nThirty-Eight, Sixty-Two, Thirty-Eight Dois Homens e Meio\nZejdz z Zmoich Wlosów Dois Homens e Meio\nDave Learns That JR is His Half-Brother Tayong dalawa\nI Think You Offended Don Dois Homens e Meio\nCorey's Been Dead for an Hour Dois Homens e Meio\nLotta Delis in Little Armenia Dois Homens e Meio\nThe Straw in My Donut Hole Dois Homens e Meio\nHere I Come, Pants! Dois Homens e Meio\nI Think I Banged Lucille Ball Dois Homens e Meio\nBest H.O. Money Can Buy Dois Homens e Meio\nA Kosher Slaughterhouse Out in Fontana Dois Homens e Meio\nDead from the Waist Down Dois Homens e Meio\nShe'll Still Be Dead at Halftime Dois Homens e Meio\nA Giant Cat Holding a Churro Dois Homens e Meio\nAlways a Bridesmaid, Never a Burro Dois Homens e Meio\nThree Hookers and a Philly Cheesesteak Dois Homens e Meio\nOw, Ow, Don't Stop Dois Homens e Meio\nPeople Who Love Peepholes Dois Homens e Meio\nThat's Summer Sausage, Not Salami Dois Homens e Meio\nThat Pistol-Packin' Hermaphrodite Dois Homens e Meio\nYou Do Know What the Lollipop Is For Dois Homens e Meio\nLove Isn't Blind, It's Retarded Dois Homens e Meio\nThat's Not What They Call It in Amsterdam Dois Homens e Meio\nThe Spit-Covered Cobbler Dois Homens e Meio\n
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
![Gradlew Build Example](https://i.imgur.com/AKLr9SB.png)
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
<br><br>

# 3. JMETER
At below, somes multithreading test with JMeter.<br>
The test configuration applied is located at *../jmeter/Test Plan for api-movies-server.jmx*
<br>
## 3.1 JMETER THREAD GROUP:
JMeter Thread Group configuration with 20 threads:
![JMeter Thread Group](https://i.imgur.com/puXPKE0.png)
<br><br>
## 3.2 JMETER TEST:
The JMeter Test component with Groovy language for call the server project.
![JMeter Test](https://i.imgur.com/m5qD7Hq.png)
The source (Groovy) :
```groovy
def sock = new Socket()
sock.setSoTimeout(4000)
sock.connect(new InetSocketAddress("127.0.0.1", 32000))
if (sock.isConnected()) {
	log.info('Connection established')
	sock.withStreams { inStream, outStream ->
		def reader = inStream.newReader()
		outStream << "13:The Godfather"		
	}
} else {
	log.info('Server is not listening')
}
log.info("Finished");
```

<br><br>
## 3.3 VIEW RESULTS TREE:
The View Results Tree with all the callers indicating sucess.<br>
![View Results Tree](https://i.imgur.com/8BJT8HE.png)
<br>
## 3.4 THE SERVER CONSOLE:
For finish, the server''s console result (with logback for better visualization).<br>
![Console example](https://i.imgur.com/7wnMbkK.png)
<br><br>
