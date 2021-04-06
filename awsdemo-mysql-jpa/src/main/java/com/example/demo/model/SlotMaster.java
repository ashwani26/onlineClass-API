package com.example.demo.model;

public enum SlotMaster {
	EIGHT_TO_NINE_AM("8-9AM"),NINE_TO_TEN_AM("9-10AM"),TEN_TO_ELEVEN_AM("10-11AM"),ELEVEN_TO_TWELVE_PM("11-12PM");
    private String displayName;

    SlotMaster(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }

    // Optionally and/or additionally, toString.
    @Override public String toString() { return displayName; }
}
