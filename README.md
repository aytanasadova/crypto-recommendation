# crypto-recommendation
Recommendation service for Crypto investment
Things to consider: 
● Documentation is our best friend, so it will be good to share one for the endpoints 
Swagger UI : http://server-url:8593/swagger-ui/index.html#/
● Initially the cryptos are only five, but what if we want to include more? Will the recommendation service be able to scale?
Yes, Spring batch auto downloads all files in specified resource with filter “. *csv”
 ● New cryptos pop up every day, so we might need to safeguard recommendations service endpoints from not currently supported cryptos 
Because of above explanation, I think my service supports this case. (Otherwise we should discuss)
● For some cryptos it might be safe to invest, by just checking only one month's time frame. However, for some of them it might be more accurate to check six months or even a year. Will the recommendation service be able to handle this?
 There are methods that let us to make search in the whole data and with interval values. It supports not just year and month, also all intervals. 
I would like to add some thoughts:
-	I assume that in any case data will appear in csv files (ex for analyse 6 month’s data). If there is a case that I only will have one month’s data, we should consider use persistence.
-	For price I choose precision 4 after analyse csv files. It would be better to discuss.
-	Date zone should be discussed. Default I choose my current. (In the csv files which time zone used)
-	Currency maters should be discussed
-	In database I used the same names as in csv files. I think names are suitable and there is no need to make confusion by declaring names different in the database. (Open to discussion)
-	In queries I used group by clause, I would like to go back and check performance to give symbols a unique id, because group by works great with integer(digit) values
-	I assume that timestamp for each symbol is unique, if not then we need to discuss which value you would like to choose in case of same timestamp
-	Question: if symbol has the same max price for 2 different time, which time do you want to see (maybe both?)
-	For scheduled reading file I used cron  based job (should be discussed)
Due time limitation, I would like to consider some points, especially missing test cases and some code documentation points in future (they will appear my GitHub):

For the task I used Spring boot (Batch processing) with H2 database (JDBC template).
 To increase performance, I prefer to use spring cache. After csv files read, job cleans spring cache. But this case should be discussed, if csv files updates very quickly then maybe cache will not help. 
For now, I didn’t use dB level indexes because they can reduce writing performance. Maybe we should make trade offs in some point.
