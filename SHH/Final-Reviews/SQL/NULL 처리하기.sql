-- �ڵ带 �Է��ϼ���
-- DEcode �Լ�(�÷� �̸�, ������ ���, ���ǿ� �°�, �����̾�����)
SELECT ANIMAL_TYPE, DECODE(NAME,NULL,'No name',Name) as NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
order by ANIMAL_Id;