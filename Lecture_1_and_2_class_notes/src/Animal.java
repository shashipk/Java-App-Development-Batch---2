public abstract class Animal {
    private int ht;
    private int wt;
    private String color;
    public void speak(){
        System.out.println("Animal speaks");
    }

    public int getHt() {
        return ht;
    }

    public void setHt(int ht) {
        if(ht>=0)
        this.ht = ht;
    }

    public int getWt() {
        return wt;
    }

    public void setWt(int wt) {
        this.wt = wt;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
