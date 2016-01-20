package za.ac.cput.LibrarySystem.domain;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.LibrarySystem.conf.factory.AddressFactory;
import za.ac.cput.LibrarySystem.conf.factory.MemberFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Address;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class MemberTest extends TestCase{
    @Test
    public void testCreateMember() throws Exception {
        Map<String,String> memberValue = new HashMap<String, String>();
        Map<String,String> addressValue = new HashMap<String, String>();

        memberValue.put("member_id","PQ100");
        memberValue.put("fName","Songezo");
        memberValue.put("lName","Nkumatelo");

        addressValue.put("street","Kaap street");
        addressValue.put("suburb","Leiden");
        addressValue.put("postalCode","8000");

        Address address = AddressFactory.createAddress(addressValue,58);
        Member member = MemberFactory.createMember(memberValue,address);

        assertEquals("PQ100",member.getMember_id());
    }

    public void testUpdate() throws Exception {
        Map<String,String> memberValue = new HashMap<String, String>();
        Map<String,String> addressValue = new HashMap<String, String>();

        memberValue.put("member_id","PQ100");
        memberValue.put("fName","Songezo");
        memberValue.put("lName","Nkumatelo");

        addressValue.put("street","Kaap street");
        addressValue.put("suburb","Leiden");
        addressValue.put("postalCode","8000");

        Address address = AddressFactory.createAddress(addressValue,58);
        Member member = MemberFactory.createMember(memberValue, address);

        Member newMember = new Member.Builder(member.getMember_id())
                .copy(member)
                .firstName("Yongama")
                .build();

        assertEquals("Yongama",newMember.getFirstName());
        assertEquals("Songezo",member.getFirstName());
        assertEquals("PQ100",member.getMember_id());
        assertEquals("PQ100",newMember.getMember_id());
    }
}
