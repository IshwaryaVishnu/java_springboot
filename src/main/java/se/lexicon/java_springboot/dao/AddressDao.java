package se.lexicon.java_springboot.dao;

import se.lexicon.java_springboot.entity.Address;

import java.util.Collection;
import java.util.Optional;

public interface AddressDao {

    Address persist(Address address);
    Optional<Address>findById(Integer id);

    Collection<Address>findAll();
    Address update(Address address);
    void remove(Integer id);
}
