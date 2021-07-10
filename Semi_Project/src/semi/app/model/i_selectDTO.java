/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.app.model;

import java.sql.Timestamp;

/**
 *
 * @author PARK YUJEONG
 */
public class i_selectDTO {
    private int no;
    private String kind;
    private int money;
    private Timestamp regdate;

    public i_selectDTO() {
        super();
    }

    public i_selectDTO(int no, String kind, int money, Timestamp regdate) {
        super();
        
        this.no = no;
        this.kind = kind;
        this.money = money;
        this.regdate = regdate;
    }
    
    

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "i_selectDTO{" + "no=" + no + ", kind=" + kind + ", money=" + money + ", regdate=" + regdate + '}';
    }

    



}
