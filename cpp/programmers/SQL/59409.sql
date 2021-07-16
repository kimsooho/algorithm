/*
  https://programmers.co.kr/learn/courses/30/lessons/59409
*/

SELECT ANIMAL_ID, NAME, if(SEX_UPON_INTAKE LIKE "%Neutered%" OR SEX_UPON_INTAKE LIKE "%Spayed%", "O", "X") AS "중성화"
FROM ANIMAL_INS