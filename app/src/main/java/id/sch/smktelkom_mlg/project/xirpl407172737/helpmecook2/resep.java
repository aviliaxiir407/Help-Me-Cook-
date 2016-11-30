package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

/**
 * Created by user_ on 11/8/2016.
 */

class Resep {
    //name and address string
    private String namaresep;
    private String bahan;
    private String caramembuat;
    private String urlgambar;

    public Resep() {
      /*Blank default constructor essential for Firebase*/
    }

    public String getName() {
        return namaresep;
    }
    public void setName(String namaresep) {
        this.namaresep = namaresep;
    }
    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }
    public String getCara() {
        return caramembuat;
    }
    public void setCara(String caramembuat) {
        this.caramembuat = caramembuat;
    }

    public String getUrlgambar() {
        return urlgambar;
    }

    public void setUrlgambar(String urlgambar) {
        this.urlgambar = urlgambar;
    }

}