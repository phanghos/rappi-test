package com.ghoss.android.rappitest.data.entity.mapper;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by roberto on 10/15/17.
 */
public class MovieEntityToMovieMapperTest {

    private static final String JSON = "[\n" +
            "        {\n" +
            "            \"vote_count\": 2090,\n" +
            "            \"id\": 346364,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.4,\n" +
            "            \"title\": \"It\",\n" +
            "            \"popularity\": 771.460898,\n" +
            "            \"poster_path\": \"/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"It\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                18,\n" +
            "                27\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.\",\n" +
            "            \"release_date\": \"2017-09-05\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 694,\n" +
            "            \"id\": 335984,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.7,\n" +
            "            \"title\": \"Blade Runner 2049\",\n" +
            "            \"popularity\": 376.468393,\n" +
            "            \"poster_path\": \"/cbRQVCia0urtv5UGsVFTdqLDIRv.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Blade Runner 2049\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                9648,\n" +
            "                878,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/mVr0UiqyltcfqxbAUcLl9zWL8ah.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Thirty years after the events of the first film, a new blade runner, LAPD Officer K, unearths a long-buried secret that has the potential to plunge what's left of society into chaos. K's discovery leads him on a quest to find Rick Deckard, a former LAPD blade runner who has been missing for 30 years.\",\n" +
            "            \"release_date\": \"2017-10-04\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 3823,\n" +
            "            \"id\": 315635,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.3,\n" +
            "            \"title\": \"Spider-Man: Homecoming\",\n" +
            "            \"popularity\": 335.380863,\n" +
            "            \"poster_path\": \"/kY2c7wKgOfQjvbqe7yVzLTYkxJO.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Spider-Man: Homecoming\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.\",\n" +
            "            \"release_date\": \"2017-07-05\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 4733,\n" +
            "            \"id\": 211672,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.4,\n" +
            "            \"title\": \"Minions\",\n" +
            "            \"popularity\": 320.793796,\n" +
            "            \"poster_path\": \"/q0R4crx2SehcEEQEkYObktdeFy.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Minions\",\n" +
            "            \"genre_ids\": [\n" +
            "                10751,\n" +
            "                16,\n" +
            "                12,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/uX7LXnsC7bZJZjn048UCOwkPXWJ.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.\",\n" +
            "            \"release_date\": \"2015-06-17\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5546,\n" +
            "            \"id\": 321612,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.8,\n" +
            "            \"title\": \"Beauty and the Beast\",\n" +
            "            \"popularity\": 280.519048,\n" +
            "            \"poster_path\": \"/tWqifoYuwLETmmasnGHO7xBjEtt.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Beauty and the Beast\",\n" +
            "            \"genre_ids\": [\n" +
            "                10751,\n" +
            "                14,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/6aUWe0GSl69wMTSWWexsorMIvwU.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.\",\n" +
            "            \"release_date\": \"2017-03-16\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 6283,\n" +
            "            \"id\": 177572,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.8,\n" +
            "            \"title\": \"Big Hero 6\",\n" +
            "            \"popularity\": 221.55948,\n" +
            "            \"poster_path\": \"/9gLu47Zw5ertuFTZaxXOvNfy78T.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Big Hero 6\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                10751,\n" +
            "                16,\n" +
            "                28,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/2BXd0t9JdVqCp9sKf6kzMkr7QjB.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"The special bond that develops between plus-sized inflatable robot Baymax, and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.\",\n" +
            "            \"release_date\": \"2014-10-24\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5051,\n" +
            "            \"id\": 297762,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.2,\n" +
            "            \"title\": \"Wonder Woman\",\n" +
            "            \"popularity\": 211.726556,\n" +
            "            \"poster_path\": \"/imekS7f1OuHyUP2LAiTEM0zBzUz.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Wonder Woman\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/6iUNJZymJBMXXriQyFZfLAKnjO6.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"An Amazon princess comes to the world of Man to become the greatest of the female superheroes.\",\n" +
            "            \"release_date\": \"2017-05-30\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 1721,\n" +
            "            \"id\": 281338,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.7,\n" +
            "            \"title\": \"War for the Planet of the Apes\",\n" +
            "            \"popularity\": 205.6265,\n" +
            "            \"poster_path\": \"/3vYhLLxrTtZLysXtIWktmd57Snv.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"War for the Planet of the Apes\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                878,\n" +
            "                10752\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/ulMscezy9YX0bhknvJbZoUgQxO5.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.\",\n" +
            "            \"release_date\": \"2017-07-11\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 618,\n" +
            "            \"id\": 343668,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.3,\n" +
            "            \"title\": \"Kingsman: The Golden Circle\",\n" +
            "            \"popularity\": 203.696389,\n" +
            "            \"poster_path\": \"/pKESfn2Pdy0b7drvZHQb7UzgqoY.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Kingsman: The Golden Circle\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/uExPmkOHJySrbJyJDJylHDqaT58.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"When an attack on the Kingsman headquarters takes place and a new villain rises, Eggsy and Merlin are forced to work together with the American agency known as the Statesman to save the world.\",\n" +
            "            \"release_date\": \"2017-09-20\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 2121,\n" +
            "            \"id\": 339403,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.2,\n" +
            "            \"title\": \"Baby Driver\",\n" +
            "            \"popularity\": 177.664912,\n" +
            "            \"poster_path\": \"/dN9LbVNNZFITwfaRjl4tmwGWkRg.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Baby Driver\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                80\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/goCvLSUFz0p7k8R10Hv4CVh3EQv.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"After being coerced into working for a crime boss, a young getaway driver finds himself taking part in a heist doomed to fail.\",\n" +
            "            \"release_date\": \"2017-06-28\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 12082,\n" +
            "            \"id\": 19995,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.2,\n" +
            "            \"title\": \"Avatar\",\n" +
            "            \"popularity\": 169.665634,\n" +
            "            \"poster_path\": \"/kmcqlZGaSh20zpTbuoF0Cdn07dT.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Avatar\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                14,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/xSxlmtLz2NYtO07N4WexY1y53pl.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In the 22nd century, a paraplegic Marine is dispatched to the moon Pandora on a unique mission, but becomes torn between following orders and protecting an alien civilization.\",\n" +
            "            \"release_date\": \"2009-12-10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 11444,\n" +
            "            \"id\": 293660,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.4,\n" +
            "            \"title\": \"Deadpool\",\n" +
            "            \"popularity\": 166.256074,\n" +
            "            \"poster_path\": \"/inVq3FRqcYIRl2la8iZikYYxFNR.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Deadpool\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/n1y094tVDFATSzkTnFxoGZ1qNsG.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Deadpool tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.\",\n" +
            "            \"release_date\": \"2016-02-09\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 460,\n" +
            "            \"id\": 381283,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.9,\n" +
            "            \"title\": \"mother!\",\n" +
            "            \"popularity\": 156.555692,\n" +
            "            \"poster_path\": \"/qmi2dsuoyzZdJ0WFZYQazbX8ILj.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"mother!\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                27\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/uuQpQ8VDOtVL2IO4y2pR58odkS5.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A couple's relationship is tested when uninvited guests arrive at their home, disrupting their tranquil existence.\",\n" +
            "            \"release_date\": \"2017-09-13\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5503,\n" +
            "            \"id\": 245891,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7,\n" +
            "            \"title\": \"John Wick\",\n" +
            "            \"popularity\": 148.203779,\n" +
            "            \"poster_path\": \"/5vHssUeVe25bMrof1HyaPyWgaP.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"John Wick\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/mFb0ygcue4ITixDkdr7wm1Tdarx.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\n" +
            "            \"release_date\": \"2014-10-22\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 6005,\n" +
            "            \"id\": 210577,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.9,\n" +
            "            \"title\": \"Gone Girl\",\n" +
            "            \"popularity\": 143.987812,\n" +
            "            \"poster_path\": \"/gdiLTof3rbPDAmPaCf4g6op46bj.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Gone Girl\",\n" +
            "            \"genre_ids\": [\n" +
            "                9648,\n" +
            "                53,\n" +
            "                18\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bt6DhdALyhf90gReozoQ0y3R3vZ.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"With his wife's disappearance having become the focus of an intense media circus, a man sees the spotlight turned on him when it's suspected that he may not be innocent.\",\n" +
            "            \"release_date\": \"2014-10-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 4877,\n" +
            "            \"id\": 283995,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.6,\n" +
            "            \"title\": \"Guardians of the Galaxy Vol. 2\",\n" +
            "            \"popularity\": 140.345649,\n" +
            "            \"poster_path\": \"/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Guardians of the Galaxy Vol. 2\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/aJn9XeesqsrSLKcHfHP4u5985hn.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.\",\n" +
            "            \"release_date\": \"2017-04-19\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 5734,\n" +
            "            \"id\": 131631,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.6,\n" +
            "            \"title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
            "            \"popularity\": 131.941581,\n" +
            "            \"poster_path\": \"/gj282Pniaa78ZJfbaixyLXnXEDI.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"The Hunger Games: Mockingjay - Part 1\",\n" +
            "            \"genre_ids\": [\n" +
            "                878,\n" +
            "                12,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/4PwyB0ErucIANzW24Kori71J6gU.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.\",\n" +
            "            \"release_date\": \"2014-11-18\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 8713,\n" +
            "            \"id\": 680,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.3,\n" +
            "            \"title\": \"Pulp Fiction\",\n" +
            "            \"popularity\": 130.38908,\n" +
            "            \"poster_path\": \"/dM2w364MScsjFf8pfMbaWUcWrR.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Pulp Fiction\",\n" +
            "            \"genre_ids\": [\n" +
            "                53,\n" +
            "                80\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/9rZg1J6vMQoDVSgRyWcpJa8IAGy.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.\",\n" +
            "            \"release_date\": \"1994-09-10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 2814,\n" +
            "            \"id\": 166426,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.6,\n" +
            "            \"title\": \"Pirates of the Caribbean: Dead Men Tell No Tales\",\n" +
            "            \"popularity\": 111.434538,\n" +
            "            \"poster_path\": \"/xbpSDU3p7YUGlu9Mr6Egg2Vweto.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Pirates of the Caribbean: Dead Men Tell No Tales\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                28,\n" +
            "                14,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/tZvdyLP2F6x2TTuh292ceH87qZT.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Thrust into an all-new paycheck, a down-on-his-luck Capt. Jack Sparrow feels the winds of ill-fortune blowing even more strongly when deadly ghost sailors led by his old nemesis, the evil Capt. Salazar, escape from the Devil's Triangle. Jack's only hope of a payout lies in seeking out the legendary Trident of Numbers, but to find it, he must forge an uneasy alliance with a reasonably intelligent and pretty astronomer and a irritating young man in the British navy.\",\n" +
            "            \"release_date\": \"2017-05-23\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 7428,\n" +
            "            \"id\": 271110,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.1,\n" +
            "            \"title\": \"Captain America: Civil War\",\n" +
            "            \"popularity\": 109.86332,\n" +
            "            \"poster_path\": \"/kSBXou5Ac7vEqKd97wotJumyJvU.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Captain America: Civil War\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                28,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.\",\n" +
            "            \"release_date\": \"2016-04-27\"\n" +
            "        }\n" +
            "    ]";

    MovieEntityToMovieMapper mapper;

    @Before
    public void setUp() {
        mapper = new MovieEntityToMovieMapper();
    }

    @Test
    public void checkNotNull() {
        assertNotNull(mapper);
    }

    @Test
    public void map_returnsExpectedObject() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<MovieEntity>>(){}.getType();
        List<MovieEntity> movieEntities = gson.fromJson(JSON, type);
        List<Movie> movieList = mapper.map(movieEntities);
        assertEquals(movieList.size(), movieList.size());
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            MovieEntity movieEntity = movieEntities.get(i);
            assertEquals(movie.getTitle(), movieEntity.getTitle());
            assertEquals(movie.getBackdropPath(), movieEntity.getBackdropPath());
            assertEquals(movie.getOriginalLanguage(), movieEntity.getOriginalLanguage());
            assertEquals(movie.getOriginalTitle(), movieEntity.getOriginalTitle());
            assertEquals(movie.getOverview(), movieEntity.getOverview());
            assertEquals(movie.getPosterPath(), movieEntity.getPosterPath());
            assertEquals(movie.getReleaseDate(), movieEntity.getReleaseDate());
            assertEquals(movie.getAdult(), movieEntity.getAdult());
            assertEquals(movie.getId(), movieEntity.getId());
            assertEquals(movie.getVideo(), movieEntity.getVideo());
            assertEquals(movie.getVoteCount(), movieEntity.getVoteCount());
        }
    }
}