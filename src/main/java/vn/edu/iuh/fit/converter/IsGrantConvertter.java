package vn.edu.iuh.fit.converter;

import vn.edu.iuh.fit.models.isGrant;

public class IsGrantConvertter {
    public static int enumToBit(isGrant grant) {
        switch (grant) {
            case ONE:
                return 1;
            case MINUS_ONE:
                return -1;
            case ZERO:
                return 0;
            default:
                throw new IllegalArgumentException("Invalid enum value: " + grant);
        }
    }

    public static isGrant bitToEnum(int bitValue) {
        switch (bitValue) {
            case 1:
                return isGrant.ONE;
            case -1:
                return isGrant.MINUS_ONE;
            case 0:
                return isGrant.ZERO;
            default:
                throw new IllegalArgumentException("Invalid bit value: " + bitValue);
        }
    }
}
