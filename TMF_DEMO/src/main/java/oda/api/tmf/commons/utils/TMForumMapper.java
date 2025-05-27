package oda.api.tmf.commons.utils;

import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface TMForumMapper {


    /*@Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillFormatVO map(BillFormatCreateVO billFormatCreateVO, URI id);

    BillFormatVO map(BillFormat billFormat);

    @Mapping(target = "href", source = "id")
    BillFormat map(BillFormatVO billFormatVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillFormatVO map(BillFormatUpdateVO billFormatUpdateVO, String id);

    //BillingAccount

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillingAccountVO map(BillingAccountCreateVO billingAccountCreateVO, URI id);

    BillingAccountVO map(BillingAccount billingAccount);

    @Mapping(target = "href", source = "id")
    BillingAccount map(BillingAccountVO billingAccountVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillingAccountVO map(BillingAccountUpdateVO billingAccountUpdateVO, String id);

    //BillingCycleSpecification

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillingCycleSpecificationVO map(BillingCycleSpecificationCreateVO billingCycleSpecificationCreateVO, URI id);

    BillingCycleSpecificationVO map(BillingCycleSpecification billingCycleSpecification);

    @Mapping(target = "href", source = "id")
    BillingCycleSpecification map(BillingCycleSpecificationVO billingCycleSpecificationVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillingCycleSpecificationVO map(BillingCycleSpecificationUpdateVO billingCycleSpecificationUpdateVO, String id);

    //BillPresentationMedia

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillPresentationMediaVO map(BillPresentationMediaCreateVO billPresentationMediaCreateVO, URI id);

    BillPresentationMediaVO map(BillPresentationMedia billPresentationMedia);

    @Mapping(target = "href", source = "id")
    BillPresentationMedia map(BillPresentationMediaVO billPresentationMediaVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    BillPresentationMediaVO map(BillPresentationMediaUpdateVO billPresentationMediaUpdateVO, String id);

    //FinancialAccount

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    FinancialAccountVO map(FinancialAccountCreateVO financialAccountCreateVO, URI id);

    FinancialAccountVO map(FinancialAccount financialAccount);

    @Mapping(target = "href", source = "id")
    FinancialAccount map(FinancialAccountVO financialAccountVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    FinancialAccountVO map(FinancialAccountUpdateVO financialAccountUpdateVO, String id);

    //PartyAccount

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    PartyAccountVO map(PartyAccountCreateVO partyAccountCreateVO, URI id);

    PartyAccountVO map(PartyAccount partyAccount);

    @Mapping(target = "href", source = "id")
    PartyAccount map(PartyAccountVO partyAccountVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    PartyAccountVO map(PartyAccountUpdateVO partyAccountUpdateVO, String id);

    //SettlementAccount

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    SettlementAccountVO map(SettlementAccountCreateVO settlementAccountCreateVO, URI id);

    SettlementAccountVO map(SettlementAccount settlementAccount);

    @Mapping(target = "href", source = "id")
    SettlementAccount map(SettlementAccountVO settlementAccountVO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "href", source = "id")
    SettlementAccountVO map(SettlementAccountUpdateVO settlementAccountUpdateVO, String id);

    @Mapping(target = "query", source = "rawQuery")
    EventSubscriptionVO map(TMForumSubscription subscription);

    TimePeriod map(TimePeriodVO value);

    default String map(URL value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    default URI mapToURI(String value) {
        if (value == null) {
            return null;
        }
        return URI.create(value);
    }

    default URL mapToURL(String value) {
        if (value == null) {
            return null;
        }
        try {
            return new URL(value);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    default String mapFromURI(URI value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }*/

}
