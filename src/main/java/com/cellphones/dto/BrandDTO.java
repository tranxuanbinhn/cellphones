package com.cellphones.dto;

public class BrandDTO extends AbstractDTO {
    private String nameBrand;
    private String codeBrand;

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getCodeBrand() {
        return codeBrand;
    }

    public void setCodeBrand(String codeBrand) {
        this.codeBrand = codeBrand;
    }
}
