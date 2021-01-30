
CASCADING

Entity relationships often depend on the existence of another entity — 
for example, the Person–Address relationship. Without the Person, the 
Address entity doesn't have any meaning of its own. When we delete the Person entity, 
our Address entity should also get deleted.

Cascading is the way to achieve this. When we perform some action on the target entity, 
the same action will be applied to the associated entity.

Let's see it in an example:

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
Note that in OneToMany associations, we've mentioned cascade type in the annotation.

Now, let's see the associated entity Address:

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private int houseNumber;
    private String city;
    private int zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}
