package za.ac.cput.LibrarySystem.repostory;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.LibrarySystem.App;
import za.ac.cput.LibrarySystem.conf.factory.AddressFactory;
import za.ac.cput.LibrarySystem.conf.factory.MemberFactory;
import za.ac.cput.LibrarySystem.domain.Impl.Address;
import za.ac.cput.LibrarySystem.domain.Impl.Member;
import za.ac.cput.LibrarySystem.repository.MemberRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Branwyn on 2015-05-19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudMember extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private MemberRepository repository;

    @Test
    public void testCreate() throws Exception {
        Map<String,String> memberValue = new HashMap<String, String>();
        Map<String,String> addressValue = new HashMap<String, String>();

        memberValue.put("member_id","JJ10");
        memberValue.put("fName","Baliswa");
        memberValue.put("lName","Ntozonke");

        addressValue.put("street","Tano street");
        addressValue.put("suburb","Lolo");
        addressValue.put("postalCode","7100");

        Address address = AddressFactory.createAddress(addressValue,58);
        Member member = MemberFactory.createMember(memberValue,address);

        repository.save(member);
        id = member.getId();
        Assert.assertNotNull(repository.findOne(id));
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Member member = repository.findOne(id);
        Assert.assertEquals("Baliswa", member.getFirstName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Member m1 = repository.findOne(id);
        Member newMember = new Member.Builder(m1.getMember_id())
                .copy(m1)
                .firstName("Xolela")
                .build();
        repository.save(newMember);
        Assert.assertEquals("Xolela", newMember.getFirstName());
        Assert.assertEquals("Baliswa",m1.getFirstName());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Member member = repository.findOne(id);
        repository.delete(member);
        Member mm = repository.findOne(id);
        Assert.assertNull(mm);
    }
}
