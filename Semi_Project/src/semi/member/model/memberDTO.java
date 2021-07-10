/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.member.model;

import java.sql.Timestamp;

/**
 *
 * @author STU
 */
public class memberDTO {
    private int m_no;
    private String m_name;
    private String m_id;
    private String m_pwd;
    private Timestamp m_regdate;

    public memberDTO() {
        super();
    }

    public int getM_no() {
        return m_no;
    }

    public void setM_no(int m_no) {
        this.m_no = m_no;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public Timestamp getM_regdate() {
        return m_regdate;
    }

    public void setM_regdate(Timestamp m_regdate) {
        this.m_regdate = m_regdate;
    }

    @Override
    public String toString() {
        return "memberDTO{" + "m_no=" + m_no + ", m_name=" + m_name + ", m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_regdate=" + m_regdate + '}';
    }

   
    
}
