-- �ڵ带 �Է��ϼ���
--DISTINCT ��ġ ����� Ȯ���ϱ�
SELECT count(DISTINCT NAME) as count
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;