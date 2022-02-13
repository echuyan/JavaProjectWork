package app.enums;

public enum Currency {
    CUR1FORM("рубль"),
    CUR2FORM("рубля"),
    CUR3FORM("рублей");

    private String form;

    Currency(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }

}


