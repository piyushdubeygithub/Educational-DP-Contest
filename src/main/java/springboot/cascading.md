
CASCADING

Entity relationships often depend on the existence of another entity — 
for example, the Person–Address relationship. Without the Person, the 
Address entity doesn't have any meaning of its own. When we delete the Person entity, 
our Address entity should also get deleted.

Cascading is the way to achieve this. When we perform some action on the target entity, 
the same action will be applied to the associated entity.
