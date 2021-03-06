package com.cobainc0.beam.core;

public class Vendor {

    /**
     * Entity's unique identifier.
     */


    private long vendorId;

    /**
     * vendor vendorName.
     */
    private String vendorName;

    /**
     * vendor vendorAddress1.
     */

    private String vendorAddress1;

    /**
     * vendor vendorAddress2.
     */
    private String vendorAddress2;

    /**
     * vendor vendorAddress3.
     */
    private String vendorAddress3;

    /**
     * vendor vendorPostcode.
     */
    private String vendorPostcode;

    /**
     * vendor vendorTelephone.
     */
    private String vendorTelephone;

    /**
     * vendor vendorEmail.
     */
    private String vendorEmail;

    /**
     * vendor vendorWebsite.
     */
    private String vendorWebsite;

    /**
     * vendor vendorType.
     */
    private String vendorType;

    /**
     * vendor vendorLat.
     */
    private String vendorLat;

    /**
     * vendor vendorLng.
     */
    private String vendorLng;

    /**
     * A no-argument constructor.
     */
    public Vendor() { }

    /**
     * A constructor to create vendors. Id is not passed, cause it's
     * auto-generated by RDBMS.
     *
     * @param vendorName vendor vendorName
     * @param vendorAddress1 vendor vendorAddress1
     * @param vendorAddress2 vendor vendorAddress2
     * @param vendorAddress3 vendorAddress3
     * @param vendorPostcode vendor vendorPostcode
     * @param vendorTelephone vendor vendorTelephone
     * @param vendorEmail vendor vendorEmail
     * @param vendorWebsite vendor vendorWebsite
     * @param vendorType vendor vendorType
     * @param vendorLat vendor vendorLat
     * @param vendorLng vendor vendorLng
     */
    public Vendor(String vendorName,
                  String vendorAddress1,
                  String vendorAddress2,
                  String vendorAddress3,
                  String vendorEmail,
                  String vendorPostcode,
                  String vendorTelephone,
                  String vendorWebsite,
                  String vendorType,
                  String vendorLat,
                  String vendorLng
                  ) {
        this.vendorName = vendorName;
        this.vendorAddress1 = vendorAddress1;
        this.vendorAddress2 = vendorAddress2;
        this.vendorAddress3 = vendorAddress3;
        this.vendorEmail = vendorEmail;
        this.vendorPostcode = vendorPostcode;
        this.vendorTelephone = vendorTelephone;
        this.vendorWebsite = vendorWebsite;
        this.vendorType = vendorType;
        this.vendorLat = vendorLat;
        this.vendorLng = vendorLng;
    }


    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress1() {
        return vendorAddress1;
    }

    public void setVendorAddress1(String vendorAddress1) {
        this.vendorAddress1 = vendorAddress1;
    }

    public String getVendorAddress2() {
        return vendorAddress2;
    }

    public void setVendorAddress2(String vendorAddress2) {
        this.vendorAddress2 = vendorAddress2;
    }

    public String getVendorAddress3() {
        return vendorAddress3;
    }

    public void setVendorAddress3(String vendorAddress3) {
        this.vendorAddress3 = vendorAddress3;
    }

    public String getVendorPostcode() {
        return vendorPostcode;
    }

    public void setVendorPostcode(String vendorPostcode) {
        this.vendorPostcode = vendorPostcode;
    }

    public String getVendorTelephone() {
        return vendorTelephone;
    }

    public void setVendorTelephone(String vendorTelephone) {
        this.vendorTelephone = vendorTelephone;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorWebsite() {
        return vendorWebsite;
    }

    public void setVendorWebsite(String vendorWebsite) {
        this.vendorWebsite = vendorWebsite;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorLat() {
        return vendorLat;
    }

    public void setVendorLat(String vendorLat) {
        this.vendorLat = vendorLat;
    }

    public String getVendorLng() {
        return vendorLng;
    }

    public void setVendorLng(String vendorLng) {
        this.vendorLng = vendorLng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor)) return false;

        Vendor vendor = (Vendor) o;

        if (getVendorId() != vendor.getVendorId()) return false;
        if (!getVendorName().equals(vendor.getVendorName())) return false;
        if (!getVendorAddress1().equals(vendor.getVendorAddress1())) return false;
        if (!getVendorAddress2().equals(vendor.getVendorAddress2())) return false;
        if (!getVendorAddress3().equals(vendor.getVendorAddress3())) return false;
        if (!getVendorPostcode().equals(vendor.getVendorPostcode())) return false;
        if (!getVendorTelephone().equals(vendor.getVendorTelephone())) return false;
        if (!getVendorEmail().equals(vendor.getVendorEmail())) return false;
        if (!getVendorWebsite().equals(vendor.getVendorWebsite())) return false;
        if (!getVendorType().equals(vendor.getVendorType())) return false;
        if (!getVendorLat().equals(vendor.getVendorLat())) return false;
        return getVendorLng().equals(vendor.getVendorLng());
    }

    @Override
    public int hashCode() {
        int result = (int) (getVendorId() ^ (getVendorId() >>> 32));
        result = 31 * result + getVendorName().hashCode();
        result = 31 * result + getVendorAddress1().hashCode();
        result = 31 * result + getVendorAddress2().hashCode();
        result = 31 * result + getVendorAddress3().hashCode();
        result = 31 * result + getVendorPostcode().hashCode();
        result = 31 * result + getVendorTelephone().hashCode();
        result = 31 * result + getVendorEmail().hashCode();
        result = 31 * result + getVendorWebsite().hashCode();
        result = 31 * result + getVendorType().hashCode();
        result = 31 * result + getVendorLat().hashCode();
        result = 31 * result + getVendorLng().hashCode();
        return result;
    }
}