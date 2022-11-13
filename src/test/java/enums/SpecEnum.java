package enums;

public enum SpecEnum {
    URL("booker_url"),
    FILEPATH("src/test/resources/urls.properties");
    private final String specInfos;
    SpecEnum(String specInfos) {
        this.specInfos = specInfos;
    }
    public String getSpecInfos() {
        return specInfos;
    }
}
