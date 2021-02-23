// ICalcService.aidl
package com.sendytest.mycalcapp;

// Declare any non-default types here with import statements

interface ICalcService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double add(in double value1, in double value2);

    double subtract(in double value1, in double value2);

    double divide(in double value1, in double value2);

    double mutliply(in double value1, in double value2);
}