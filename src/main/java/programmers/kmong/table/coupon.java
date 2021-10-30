package programmers.kmong.table;

import java.time.LocalDateTime;

public class coupon {
    //PK
    private String id;
    private String name;
    //TODO::ENUM으로 관리
    //"won" : 금액 할인, "per" : 퍼센트 할인
    private String discountType;
    private Integer discountAmount;

    private Integer minOfferCondition;
    private Integer maxOfferCondition;
    //적용 조건
    private String offerCondition;

    private LocalDateTime expirationDate;

}
