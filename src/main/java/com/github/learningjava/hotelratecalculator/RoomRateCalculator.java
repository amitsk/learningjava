package com.github.learningjava.hotelratecalculator;

/**
 * Get the room rate for a zip code and the month
 */
public class RoomRateCalculator {

    private final DiscountRateService discountRateService;
    private final BaseRateForZipCodeService baseRateForZipCodeService;
    private final TaxRateByZipCodeService taxRateByZipCodeService;

    public RoomRateCalculator(BaseRateForZipCodeService zipCodeService,
                              DiscountRateService discountRateService,
                              TaxRateByZipCodeService taxRateByZipCodeService) {
        this.baseRateForZipCodeService = zipCodeService;
        this.taxRateByZipCodeService = taxRateByZipCodeService;
        this.discountRateService = discountRateService;
    }



    public double getTotalRoomRate(RoomRateInput roomRateInput) {
        double taxRate = taxRateByZipCodeService.getTaxPercentForZipCode(roomRateInput.getZipCode());
        double baseRate = baseRateForZipCodeService.getBaseRateForZipCode(roomRateInput.getZipCode());
        double discountRateForMonth = discountRateService.getDiscountRateForMonth(roomRateInput.getMonth());

        return baseRate * (1 + discountRateForMonth) + (baseRate * (taxRate / 100));
    }

    public double getDiscountRateForMonth(int month) {
        return discountRateService.getDiscountRateForMonth(month);
    }

    static class RoomRateInput {
        private final String zipCode;
        private final int month;

        RoomRateInput(String zipCode, int month) {
            this.zipCode = zipCode;
            this.month = month;
        }

        public String getZipCode() {
            return zipCode;
        }

        public int getMonth() {
            return month;
        }
    }
}
