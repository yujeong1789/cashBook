/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package semi.member.model;

/**
 *
 * @author PARK YUJEONG
 */
public class memberService {
    public static final int LOGIN_OK=1;  //로그인 성공
    public static final int PWD_DISAGREE=2; //비밀번호 불일치
    public static final int USERID_NONE=3;  //해당 아이디 존재하지 않음
    
    //아이디 중복확인 관련 상수
    public static final int USABLE_ID=1;  //사용가능한 아이디
    public static final int NONE_USABLE_ID=2;  //사용불가능한 아이디
    
    private static String m_id;

    public static String getM_id() {
        return m_id;
    }

    public static void setM_id(String m_id) {
        memberService.m_id = m_id;
    }
    
    
}
