๐ mongoDB ๋ฉ๋ด์ผ์์ import/export ๊ด๋ จ ๋ฌธ์๋ 4.2 ๋ฒ์ ์์ ํ์ธํ๊ธฐ

ย  ย  ย (21.06.16 ๊ธฐ์ค, ์ถ ํ ์๋ฐ์ดํธ ๋  ์ ์์)

## **mongoimport**

ย : MongoDB ๊ฐ์ ธ์ค๊ธฐ

ย  ย ์ธ๋ถ์ ํ์ผ์์ ํ์ฌ ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ก ๋ถ๋ฌ์ค๋ ๊ฒฝ์ฐ ์ฌ์ฉ

## **mongoexport**

ย : MongoDB ๋ด๋ณด๋ด๊ธฐ

ย  ย ํ์ฌ ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ฅผ ์ธ๋ถํ์ผ๋ก ๋ด๋ณด๋ด๋ ๊ฒฝ์ฐ ์ฌ์ฉ

**\[์๋ฏธ\]**

  
**\- h\[--host\], u\[--username\], -p\[--password\], -d\[--db\], -c\[--collection\], -f\[--fields\], --file, --drop, --out,**

```
 // myaddr.json ์ผ๋ก ์๋์ ํ์ผ์ ์ ์ฅ 
 
    {"address" : [
    {"name":"ํ๊ธธ๋", "addr":"์์ธ์ ์์ด๋"},
    {"name":"์ ๊ธธ๋", "addr":"์ ์ฃผ์ ์ ์ฃผ๋"}]}
```

**\# ๋จผ์  Test ๋๋ ํฐ๋ฆฌ ์์ ๋ฌธ์๋ฅผ ํ์ธ ํ json ํ์ผ ํ์ ํ์ธ ํด ๋ณด์.**

```
C:\Test>dir/w
 C ๋๋ผ์ด๋ธ์ ๋ณผ๋ฅจ์๋ ์ด๋ฆ์ด ์์ต๋๋ค.
 ๋ณผ๋ฅจ ์ผ๋ จ ๋ฒํธ: BE80-C42F

 C:\Test ๋๋ ํฐ๋ฆฌ

[.]           [..]          1.jpg         2.jpg         3.jpg
a.txt         b.txt         c.json        c.txt         d.mp4
myaddr.json
               9๊ฐ ํ์ผ          34,202,093 ๋ฐ์ดํธ
               2๊ฐ ๋๋ ํฐ๋ฆฌ  409,474,809,856 ๋ฐ์ดํธ ๋จ์

C:\Test>type myaddr.json
 {"address" : [
     {"name":"?๋ป๋ง??, "addr":"?์์ฑ???์ํน??},
     {"name":"?๋บข๋ง??, "addr":"?์๏ผ???์๏ผ??}]}

C:\Test>
```

**Q1) myaddr.json์ new\_db์ test\_addr ์ด๋ ์ปฌ๋ ์์ผ๋ก import ํ์**

ย mongoimport --db new\_db --collection test\_addr --file myaddr.json

```
C:\Test>mongoimport --db=new_db --collection=test_addr --file=myaddr.json
2021-06-17T18:40:42.718+0900    connected to: mongodb://localhost/
2021-06-17T18:40:42.777+0900    1 document(s) imported successfully. 0 document(s) failed to import.

> db.test_addr.find()
{ "_id" : ObjectId("60cb1791461be1c56e46ded5"), "address" : [ { "name" : "ํ๊ธธ๋", "addr" : "์์ธ์ ์์ด๋" }, { "name" : "์ ๊ธธ๋", "addr" : "์ ์ฃผ์ ์ ์ฃผ๋" } ] }
```

**Q2) test\_addr๋ผ๋ ์ปฌ๋ ์์ myexport.json์ผ๋ก exportํ๋ค.**

mongoexport --db new\_db -c test\_addr --out myexport.json

```
C:\Test>mongoexport --db new_db -c test_addr --out myexport.json
2021-06-17T22:17:10.477+0900    connected to: mongodb://localhost/
2021-06-17T22:17:10.541+0900    exported 1 records


{"_id":{"$oid":"60cb1791461be1c56e46ded5"},"address":[{"name":"ํ๊ธธ๋","addr":"์์ธ์ ์์ด๋"},
{"name":"์ ๊ธธ๋","addr":"์ ์ฃผ์ ์ ์ฃผ๋"}]}
```

  
**Q3) addrtest๋ผ๋ ์ปฌ๋ ์์ mycsv.csv๋ก exportํ๋ค.**

  
mongoexport --db new-db -c test\_addr --out mycsv.csv

```
C:\Test>mongoexport --db newdb -c addrtest --out mycsv.csv
2021-06-17T22:52:06.073+0900    connected to: mongodb://localhost/
2021-06-17T22:52:06.137+0900    exported 1 record
```

  
**Q4) Score๋ผ๋ ์ปฌ๋ ์์ myScore.csv๋ก exportํ๋ค.**

  
mongoexport -d my\_score -c Score --out myScore.csv

```
C:\Test>mongoexport -d my_score -c Score --out myScore.csv
2021-06-17T22:49:07.154+0900    connected to: mongodb://localhost/
2021-06-17T22:49:07.221+0900    exported 7 records
```

  
**Q5) Score๋ผ๋ ์ปฌ๋ ์์ myScore.tsv๋ก exportํ๋ค.**

  
mongoexport -d my\_score -c Score --out myScore.tsv

```
C:\Test>mongoexport -d my_score -c Score --out myScore.tsv
2021-06-17T22:53:17.682+0900    connected to: mongodb://localhost/
2021-06-17T22:53:17.757+0900    exported 7 records
```

  
**Q6) myScore.csv๋ฅผ newdb์ test\_myScore ๋ผ๋ ์ปฌ๋ ์์ผ๋ก importํ๋ค.**

  
mongoimport --db new\_db --collection test\_myScore --file myScore.csv

```
C:\Test>mongoimport --db new_db --collection test_myScore --file myScore.csv
2021-06-17T22:54:42.490+0900    connected to: mongodb://localhost/
2021-06-17T22:54:42.559+0900    7 document(s) imported successfully. 0 document(s) failed to import.

> db.test_myScore.find()
{ "_id" : ObjectId("60c2c46e98e69dd9d8688086"), "name" : "eee", "kor" : 60, "eng" : 80, "mat" : 78, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688084"), "name" : "ccc", "kor" : 80, "eng" : 55, "mat" : 67, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46d98e69dd9d8688082"), "name" : "aaa", "kor" : 90, "eng" : 80, "mat" : 98, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688083"), "name" : "bbb", "kor" : 100, "eng" : 100, "mat" : 76, "test" : "final" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688085"), "name" : "ddd", "kor" : 70, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c46e98e69dd9d8688087"), "name" : "fff", "kor" : 100, "eng" : 69, "mat" : 89, "test" : "midterm" }
{ "_id" : ObjectId("60c2c47198e69dd9d8688088"), "name" : "ggg", "kor" : 75, "eng" : 100, "mat" : 100, "test" : "final" }
>
```

  
**Q7) Score ๋ผ๋ ์ปฌ๋ ์์ ์ด๋ฆ, ๊ตญ์ด ์ ์๋ง a1.txt ์ผ๋ก exportํด๋ณด์.**

  
mongoexport --db my\_score --collection=Score --fields=Name,kor --out=/opt/backups/aa.txt

```
C:\Test>mongoexport --db my_score --collection Score --fields=Name,kor --out a1.txt
2021-06-17T22:59:52.946+0900    connected to: mongodb://localhost/
2021-06-17T22:59:53.009+0900    exported 7 records
```

  
  
**Q8) Score ์ปฌ๋ ์์์ ๊ตญ์ด์ ์๊ฐ 60์ด์ ์ธ ๋ฌธ์๋ง b1.txt ์ผ๋ก exportํด๋ณด์.**  
  
mongoexport --db=my\_score -c=Score -q="{\\"kor\\":{\\"$gte\\":60}}" --out b1.txt

```
C:\Test>mongoexport --db=my_score -c=Score -q="{\"kor\":{\"$gte\":60}}" --out b1.txt
2021-06-17T23:01:41.274+0900    connected to: mongodb://localhost/
2021-06-17T23:01:41.345+0900    exported 7 records
```

## **Sharding**ย 

ย  ๋ฐ์ดํฐ๋ฅผ ์ฌ๋ฌ ์๋ฒ์ ๋ถํ  ํ๋ ๊ฒ์ ๋งํ๋ค.  
ย  (MongoDB์ ๋ฐ์ดํฐ ๋ถํ ์ ์ํฉ์ ๋ฐ๋ผ ๊ฐ Shard๋ก ์ด๋๋์ด Mongodb ์ด์ฉ์(์ฑ, ์น)๋

์ฌ๋ฌ ์๋ฒ๋ฅผ ์ธ์ํ์ง ์๊ณ  ๋ฐ์ดํฐ๋ฅผ ์ ์ฌ ์ํจ๋ค.)  

๋ณต์ ๋ ๋์ผํ ๋ฐ์ดํฐ์ ์ฌ๋ณธ์ ์ฌ๋ฌ DB์ ๊ฐ์ง๊ณ  ์๋ ๋ฐ๋ฉด, Sharding์ ๋ค๋ฅธ ๋ฐ์ดํฐ๋ฅผ ์ฌ๋ฌ์๋ฒ (DB)์ ๊ฐ์ง๋ค.  
๋ณดํต์ ๋ชฝ๊ณ  ์ด์์ Sharding + ReplicaSet(๋ณต์ ) ๊ตฌ์ฑ๋๋ค.

  
**ย 1. shard(์ค๋)**

ย  ย : ์ค์ ๋ก ๋ฐ์ดํฐ๊ฐ ์ ์ฅ๋์ด ์๋ mongod ํ๋ก์ธ์ค์ด๋ฉฐ,

ย  ย  ํ๋์ ๋ฌธ์๋(document) ํ๋์ ์ค๋์ ์ ์ฅ๋์ด ์ค๋๊ฐ์ ๋ฐ์ดํฐ ๋ณต์ ๋ ํ์ง ์๋๋ค.  
ย  ย  ReplicaSet(๋ณต์ ) ๊ตฌ์ฑํ๋ ๊ฒ์ ๊ถ์ฅ.  
  
**ย 2. config ์๋ฒ**

ย  ย  : ์ค๋ ๋ฉํ๋ฐ์ดํฐ๋ฅผ ๊ด๋ฆฌํ๋ mongod ํ๋ก์ธ์ค๋ก ๋จ์ผ ์ฅ์  ์ง์ ์ด ๋๋ค.  
ย  ย  (config -> ํ๊ฒฝ์ค์ )  
  
ย **3\. mongos ์๋ฒ**

ย  ย : ์ค๋์ ๋ผ์ฐํ ํ๋ก์ธ์ค์ด๋ค. ์ค๋์ ํด๋ผ์ด์ธํธ๋ฅผ ์ฐ๊ณ ์ํจ๋ค.  
ํ์ํ๋ค๋ฉด ์ฌ๋ฌ๊ฐ์ mongos ์๋ฒ๋ฅผ ๊ฐ์ง ์ ์๋ค. ์ํ ๊ฐ, ๋ฐ์ดํฐ๋ ์ ํ ๊ฐ์ง๊ณ  ์์ง ์๋ค.  
  
ย **4\. ์ค๋ํค**

ย  ย : ๋ฐ์ดํฐ๋ฅผ ๋ถ์ฐํ๋ ๋ฒ์์ ํค๋ก ๋ณต์ ์ง์  ํ  ์ ์๋ค.  
ํค์ ์ด๋ค ๋ฒ์์ ๋ฐ์ดํฐ๊ฐ ์ด๋ค ์ค๋์ ์ ์ฅ๋๋ ์ง๋ฅผ MongoDB๊ฐ ๊ด๋ฆฌํ๊ณ 

๋ฐ์ดํฐ์ ํธ์ฐจ์ ๋ฐ๋ผ ์๋์ผ๋ก ์กฐ์ ๋๋ค.  
  
ย **5\. ์ฒญํฌ**

ย  ย : ์ค๋์ ๋ฉ์ด๋ฆฌ๋ฅผ ๋งํ๋ฉฐ ๋ถ์ฐ ๋ฐ์ดํฐ์ ๋จ์์ด๋ค.  
ย  ย  ๊ตฌ์ฒด์ ์ผ๋ก๋ ์ปฌ๋ ์์ ์ฐ์ ๋ ๋ฒ์์ ๋ฐ์ดํฐ์ ๋ฌธ์๋ฅผ ๋งํ๋ค.  
ย  ย  ์ฒญํฌ์ ์ต๋ ํฌ๊ธฐ์ ๋๋ฌ ํ๋ฉด ๋ถํ  ๋ ์ค๋๊ฐ ๊ฐ์ง๊ณ  ์๋ ์ฒญํฌ ์์ ๋ฐ๋ผ ํ์ํ ๊ฒฝ์ฐ

ย  ย  ๋ค๋ฅธ ์ค๋๋ก ๋ฐ์ดํฐ๊ฐ ์ด๋๋๋ค.  
ย  ย  ์ฒญํฌ์ ์ต๋ ํฌ๊ธฐ๋ ๋ณ๊ฒฝ ํ  ์ ์๋ค.
