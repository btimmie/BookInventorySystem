package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Address;
import za.ac.cput.LibrarySystem.domain.Impl.Member;

import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class MemberFactory {
    public static Member createMember(Map<String,String> value, Address address){
        return new Member.Builder(value.get("member_id"))
                .firstName(value.get("fName"))
                .lastName(value.get("lName"))
                .Address(address)
                .build();

    }
}
