

SELECT ID, IFNULL(CNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA A LEFT JOIN (SELECT PARENT_ID, COUNT(*) AS CNT
                        FROM ECOLI_DATA
                        GROUP BY PARENT_ID) B ON A.ID = B.PARENT_ID
ORDER BY ID