SELECT CAR_ID,CAR_TYPE, CEIL(FEE) AS FEE
FROM
    (
        SELECT AA.CAR_ID, AA.CAR_TYPE, AA.DAILY_FEE,
               CEIL(AA.DAILY_FEE * (100-CAST(REPLACE(COALESCE(BB.DISCOUNT_RATE,'0%'),'%','') AS FLOAT))*0.01 *30) AS FEE
        FROM (
                 SELECT CAR_ID, CAR_TYPE, DAILY_FEE
                 FROM CAR_RENTAL_COMPANY_CAR A
                 WHERE CAR_TYPE IN ('세단','SUV')
                   AND CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                      WHERE DATE_FORMAT(START_DATE,'%Y%m%d')  between '20221101' and '20221130'
                                         OR DATE_FORMAT(END_DATE,'%Y%m%d')  between '20221101' and '20221130')
             ) AA  JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN BB
                        ON AA.CAR_TYPE = BB.CAR_TYPE
                            AND BB.DURATION_TYPE='30일 이상'
    ) AAA
WHERE FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID ASC