package com.paglione.entity;

import javax.persistence.*;

@Entity
@Table(name = "CONFIG")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parcelas;
    private String currentdate;
    private boolean logMessages;
    private boolean showFormDebug;
    private boolean verBoletoAutomaticamente;

    private String canhotoWidth;
    private String canhotoHeight;
    private String canhotoBorder;
    private String canhotoPadding;
    private String canhotoFont;

    private String reciboWidth;
    private String reciboHeight;
    private String reciboBorder;
    private String reciboPadding;
    private String reciboFont;

    public Config() {
    }

    public Config(Long id, String parcelas, String currentdate, boolean logMessages, boolean showFormDebug, boolean verBoletoAutomaticamente, String canhotoWidth, String canhotoHeight, String canhotoBorder, String canhotoPadding, String canhotoFont, String reciboWidth, String reciboHeight, String reciboBorder, String reciboPadding, String reciboFont) {
        this.id = id;
        this.parcelas = parcelas;
        this.currentdate = currentdate;
        this.logMessages = logMessages;
        this.showFormDebug = showFormDebug;
        this.verBoletoAutomaticamente = verBoletoAutomaticamente;
        this.canhotoWidth = canhotoWidth;
        this.canhotoHeight = canhotoHeight;
        this.canhotoBorder = canhotoBorder;
        this.canhotoPadding = canhotoPadding;
        this.canhotoFont = canhotoFont;
        this.reciboWidth = reciboWidth;
        this.reciboHeight = reciboHeight;
        this.reciboBorder = reciboBorder;
        this.reciboPadding = reciboPadding;
        this.reciboFont = reciboFont;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", parcelas='" + parcelas + '\'' +
                ", currentdate='" + currentdate + '\'' +
                ", logMessages='" + logMessages + '\'' +
                ", showFormDebug='" + showFormDebug + '\'' +
                ", verBoletoAutomaticamente='" + verBoletoAutomaticamente + '\'' +
                ", canhotoWidth='" + canhotoWidth + '\'' +
                ", canhotoHeight='" + canhotoHeight + '\'' +
                ", canhotoBorder='" + canhotoBorder + '\'' +
                ", canhotoPadding='" + canhotoPadding + '\'' +
                ", canhotoFont='" + canhotoFont + '\'' +
                ", reciboWidth='" + reciboWidth + '\'' +
                ", reciboHeight='" + reciboHeight + '\'' +
                ", reciboBorder='" + reciboBorder + '\'' +
                ", reciboPadding='" + reciboPadding + '\'' +
                ", reciboFont='" + reciboFont + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }

    public boolean getLogMessages() {
        return logMessages;
    }

    public void setLogMessages(boolean logMessages) {
        this.logMessages = logMessages;
    }

    public boolean getShowFormDebug() {
        return showFormDebug;
    }

    public void setShowFormDebug(boolean showFormDebug) {
        this.showFormDebug = showFormDebug;
    }

    public boolean getVerBoletoAutomaticamente() {
        return verBoletoAutomaticamente;
    }

    public void setVerBoletoAutomaticamente(boolean verBoletoAutomaticamente) {
        this.verBoletoAutomaticamente = verBoletoAutomaticamente;
    }

    public String getCanhotoWidth() {
        return canhotoWidth;
    }

    public void setCanhotoWidth(String canhotoWidth) {
        this.canhotoWidth = canhotoWidth;
    }

    public String getCanhotoHeight() {
        return canhotoHeight;
    }

    public void setCanhotoHeight(String canhotoHeight) {
        this.canhotoHeight = canhotoHeight;
    }

    public String getCanhotoBorder() {
        return canhotoBorder;
    }

    public void setCanhotoBorder(String canhotoBorder) {
        this.canhotoBorder = canhotoBorder;
    }

    public String getCanhotoPadding() {
        return canhotoPadding;
    }

    public void setCanhotoPadding(String canhotoPadding) {
        this.canhotoPadding = canhotoPadding;
    }

    public String getCanhotoFont() {
        return canhotoFont;
    }

    public void setCanhotoFont(String canhotoFont) {
        this.canhotoFont = canhotoFont;
    }

    public String getReciboWidth() {
        return reciboWidth;
    }

    public void setReciboWidth(String reciboWidth) {
        this.reciboWidth = reciboWidth;
    }

    public String getReciboHeight() {
        return reciboHeight;
    }

    public void setReciboHeight(String reciboHeight) {
        this.reciboHeight = reciboHeight;
    }

    public String getReciboBorder() {
        return reciboBorder;
    }

    public void setReciboBorder(String reciboBorder) {
        this.reciboBorder = reciboBorder;
    }

    public String getReciboPadding() {
        return reciboPadding;
    }

    public void setReciboPadding(String reciboPadding) {
        this.reciboPadding = reciboPadding;
    }

    public String getReciboFont() {
        return reciboFont;
    }

    public void setReciboFont(String reciboFont) {
        this.reciboFont = reciboFont;
    }
}
