/*
 * Team 6 (Amy Osborne, Gabriel Agbo, Tyree McDowell, David Jones)
 * Virtual Library Project
 * C211
 * 12/2/2021
 */
package repositories;

import com.teamsix.virtuallibrary.models.Member;
import java.util.ArrayList;

public class MemberRepo {

    private ArrayList<Member> _members = new ArrayList<Member>();
    
    public MemberRepo (ArrayList<Member> members){
        _members = members;
    }
    
    public Member CreateMember(Member member){
        _members.add(member);
        return null;
    }
    
    public Member UpdateMember(Member member){
        Member result = this.GetMember(member.memberId);
        
        if(result != null){            
            int index = _members.indexOf(result);
            _members.set(index, member);        
            
            return member;   
        }       
        return null;
    }   

    public void DeleteMember(int memberId){
        Member member = this.GetMember(memberId);
        
        if(member == null) return;
        
        _members.remove(member); 
    }

    public Member GetMember(int memberId){
        for(Member member : _members){
            if(member.getMemberId() == memberId){
                return member;
            }
        }
        return null;
    }    

}
