package entity;

public class ShengHui {
    private int id;
    private String shengming;
    private String huiming;
    private String meishi;
    private String jingdian;
    private String gaoxiao;


    public ShengHui(int id, String shengming, String huiming, String meishi, String jingdian, String gaoxiao) {
        this.id = id;
        this.shengming = shengming;
        this.huiming = huiming;
        this.meishi = meishi;
        this.jingdian = jingdian;
        this.gaoxiao = gaoxiao;
    }

    public ShengHui(String shengming, String huiming, String meishi, String jingdian, String gaoxiao) {
        this.shengming = shengming;
        this.huiming = huiming;
        this.meishi = meishi;
        this.jingdian = jingdian;
        this.gaoxiao = gaoxiao;
    }

    public ShengHui() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShengming() {
        return shengming;
    }

    public void setShengming(String shengming) {
        this.shengming = shengming;
    }

    public String getHuiming() {
        return huiming;
    }

    public void setHuiming(String huiming) {
        this.huiming = huiming;
    }

    public String getMeishi() {
        return meishi;
    }

    public void setMeishi(String meishi) {
        this.meishi = meishi;
    }

    public String getJingdian() {
        return jingdian;
    }

    public void setJingdian(String jingdian) {
        this.jingdian = jingdian;
    }

    public String getGaoxiao() {
        return gaoxiao;
    }

    public void setGaoxiao(String gaoxiao) {
        this.gaoxiao = gaoxiao;
    }




}
