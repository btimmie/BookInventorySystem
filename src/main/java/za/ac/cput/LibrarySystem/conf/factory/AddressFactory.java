package za.ac.cput.LibrarySystem.conf.factory;

import za.ac.cput.LibrarySystem.domain.Impl.Address;

import java.util.Map;

/**
 * Created by Branwyn on 2015-04-26.
 */
public class AddressFactory {
    public static Address createAddress(Map<String,String> value, int houseNumber){
        return new Address.Builder().houseNumber(houseNumber)
                .street(value.get("street"))
                .suburb(value.get("suburb"))
                .postalCode(value.get("postalCode"))
                .build();
    }
}
