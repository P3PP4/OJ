# SELECT *
# FROM FISH_INFO A LEFT JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE




SELECT ID, C.FISH_NAME, A.LENGTH
FROM FISH_INFO A JOIN (SELECT FISH_TYPE, MAX(LENGTH) AS ML
                            FROM FISH_INFO
                            GROUP BY FISH_TYPE) B ON A.FISH_TYPE = B.FISH_TYPE JOIN (SELECT FISH_TYPE, FISH_NAME
                                                                                     FROM FISH_NAME_INFO) C ON B.FISH_TYPE = C.FISH_TYPE
WHERE LENGTH = ML
ORDER BY ID