//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

class buku {
    private int pages;
    private int hari;
    private String namaBuku;
    private int pageread;
    private int lastread;

    public buku(String namaBuku, int pages, int hari) {
        this.namaBuku = namaBuku;
        this.pages = pages;
        this.hari = hari;
        this.pageread = 0;
        this.lastread = 0;
    }

    public String getNamaBuku() {
        return this.namaBuku;
    }

    public int getPages() {
        return this.pages;
    }

    public int getHari() {
        return this.hari;
    }

    public int getPageRead() {
        return this.pageread;
    }

    public int getLastRead() {
        return this.lastread;
    }

    public void update(int pageread1, int lastread1) {
        this.pageread = pageread1;
        this.lastread = lastread1;
    }

    public int newpage() {
        return this.pages - this.pageread;
    }

    public int daysleft() {
        return this.hari - this.lastread;
    }

    public int newtarget() {
        return this.daysleft() <= 0 ? this.newpage() : (int)Math.ceil((double)this.newpage() / (double)this.daysleft());
    }

    public String getStatus() {
        int target = this.pages / this.hari;
        int real = target * this.lastread;
        if (this.pageread > real) {
            return "Kamu lebih cepat dari jadwal!";
        } else {
            return this.pageread < real ? "Kamu terlambat dari jadwal." : "Kamu on track!";
        }
    }

    public String toString() {
        return this.namaBuku;
    }
}
