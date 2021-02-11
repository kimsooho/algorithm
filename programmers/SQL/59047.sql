/*
  https://programmers.co.kr/learn/courses/30/lessons/59047
*/

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE "%el%" AND ANIMAL_TYPE = "DOG"
ORDER BY NAME;