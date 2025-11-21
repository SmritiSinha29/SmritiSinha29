package com.lms.project.entity;


import java.util.*;


public class MemberService {


MemberDao dao = new MemberDao();


public void addMember(Member m) {
dao.save(m);
}


public List<Member> getAllMembers() {
return dao.findAll();

}
}