-- 코드를 입력하세요
-- 회원 id, 상품 id
-- 동일한 회원이 동일상품 재주문한 데이터

SELECT USER_ID,
    PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID,
    PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID, PRODUCT_ID DESC;