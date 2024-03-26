----------------- 메뉴 목록---------------------
CREATE  TABLE   MENUS (
     MENU_ID     VARCHAR2(6)   PRIMARY KEY
    ,MENU_NAME   VARCHAR2(100)
    ,MENU_SEQ    NUMBER(5)
);

INSERT  INTO   MENUS  VALUES ('MENU01', 'JAVA', 1 );
COMMIT;

-------------------회원정보----------------------

CREATE TABLE TUSER(
  
    USERID       VARCHAR2(12)  PRIMARY KEY
  , PASSWD       VARCHAR2(12)  NOT NULL
  , USERNAME     VARCHAR2(30)  NOT NULL
  , EMAIL        VARCHAR2(320) 
  , UPOINT       NUMBER(10)    DEFAULT 0
  , INDATE       DATE          DEFAULT SYSDATE
  
  );
  
  COMMIT;
  
  --이 방식은 springboot에서 적용되지 않음 -> between  and 사용하기
  10,000P <= VIP
  6,001 <= 우수회원 <= 8,000
  4,001 <= 일반회원 <= 6,000
  2,001 <= 준 회 원 <= 4,000
      0 <=  손  님  <= 2,000
     
               ▽
               
  CASE
   WHEN UPOINT BETWEEN 8001 AND 9999999999 THEN 'VIP'
   WHEN UPOINT BETWEEN 6001 AND 8000  THEN '우수회원'
   WHEN UPOINT BETWEEN 4001 AND 6000  THEN '일반회원'
   WHEN UPOINT BETWEEN 2001 AND 4000  THEN '준회원'
   WHEN UPOINT BETWEEN    0 AND 2000  THEN '손님'
                                        END  AS UPT  
                                        
