package com.liteinventory.editor;

import com.liteinventory.model.DaftarMasukDetilId;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class DetilMasukIdEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            if (text.contains("-")) {
                long idMasuk = Long.valueOf(text.substring(0, text.indexOf("-")));
                int noUrut = Integer.valueOf(text.substring(text.indexOf("-")+1, text.length()));

                this.setValue(new DaftarMasukDetilId(idMasuk, noUrut));
            } else {
                this.setValue(new DaftarMasukDetilId(Long.valueOf(text)));
            }
        } else {
            this.setValue(new DaftarMasukDetilId());
        }
    }

    @Override
    public String getAsText() {
        DaftarMasukDetilId id = (DaftarMasukDetilId) this.getValue();

        return id.getIdMasuk() + (id.getNoItem() != 0 ? "-" + id.getNoItem() : "");
    }
}
